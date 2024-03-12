import React, { useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import "./../styles/Blog.scss";
import Popup from "../common/Popup";
import useFetch from "../../hook/useFetch";
import { baseurl } from "../../config";

const ViewBlog = () => {
  const { blogId } = useParams();
  const navigate = useNavigate();

  const [removePopupTrigger, setRemovePopupTrigger] = useState(false);
  const [currentComment, setCurrentComment] = useState(null);

  const { data, loading, error, deleteData, postData, fetchData } = useFetch(
    `${baseurl}/posts/${blogId}`
  );

  var post = data?.post;
  var comments = data?.comments;

  const handleDelete = async () => {
    try {
      await deleteData(`${baseurl}/posts/${blogId}`);
      navigate("/");
    } catch (error) {
      console.error("Error deleting blog:", error);
    } finally {
      setRemovePopupTrigger(false);
    }
  };

  const handleCommentAdd = async () => {
    try {
      await postData(`${baseurl}/comments`, {
        post: blogId,
        comment: currentComment,
      });
    } catch (error) {
      console.error("Error adding comment:", error);
    } finally {
      setCurrentComment(null);
      fetchData(`${baseurl}/posts/${blogId}`);
    }
  };

  const formattedContent = post?.content.split("\n").map((paragraph, index) => (
    <p key={index} style={{ padding: "0.5rem 0" }}>
      {paragraph}
    </p>
  ));

  if (loading) return <div>Loading...</div>;

  if (error) return <div>Error: {error}</div>;

  return (
    <>
      <div className="blog__container">
        <div className="blog__content">
          <div className="blog__header">
            <h1>{post?.title}</h1>
            <span>Blog Created : {post?.createdOn}</span>
          </div>
          <div className="blog__body">
            <p>{formattedContent}</p>
          </div>
          <hr />

          <h3>Comments</h3>
          <div className="add_comment__container">
            <textarea
              value={currentComment}
              rows={5}
              placeholder="Add a comment..."
              onChange={(e) => setCurrentComment(e.target.value)}
            ></textarea>
            <button onClick={() => handleCommentAdd()}>Add comment</button>
          </div>
          {comments?.length === 0 ? (
            <>
              <p style={{ fontSize: "smaller", margin: "1rem 0" }}>
                No other comments yet
              </p>
            </>
          ) : (
            <div>
              {comments?.map((comment, index) => {
                return (
                  <div key={index} className="comment__container">
                    <p className="content">{comment.comment}</p>
                    <p className="date">Created on : {comment.createdOn}</p>
                  </div>
                );
              })}
            </div>
          )}
          <hr />
          <div className="blog__controller">
            <button onClick={() => navigate(`/blogs/${blogId}/edit`)}>
              Edit Blog
            </button>

            <button
              style={{
                backgroundColor: "red",
                color: "white",
              }}
              onClick={() => setRemovePopupTrigger(true)}
            >
              Delete Blog
            </button>
          </div>
        </div>
      </div>

      <Popup trigger={removePopupTrigger}>
        <h3>Are you sure?</h3>
        <p>
          Would you like to delete this blog? This action cannot be undone
        </p>{" "}
        <br />
        <div className="controller">
          <button
            className="remove-btn"
            style={{ width: "4rem", margin: "0 0.5rem" }}
            onClick={handleDelete}
          >
            Yes
          </button>
          <button
            className="remove-btn"
            style={{ width: "4rem", margin: "0 0.5rem" }}
            onClick={() => setRemovePopupTrigger(false)}
          >
            No
          </button>
        </div>
      </Popup>
    </>
  );
};

export default ViewBlog;
