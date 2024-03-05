import React, { useState } from "react";
import { useParams } from "react-router-dom";
import "./../styles/Blog.scss";
import Popup from "../common/Popup";
import useFetch from "../../hook/useFetch";
import { baseurl } from "../../config";

const ViewBlog = () => {
  const { blogId } = useParams();
  const [removePopupTrigger, setRemovePopupTrigger] = useState(false);

  const { data: post, loading, error } = useFetch(`${baseurl}/posts/${blogId}`);


  if (loading) return <div>Loading...</div>;

  if (error) return <div>Error: {error}</div>;


  const handleDelete = () => {};

  return (
    <>
      <div className="blog__container">
        <div className="blog__content">
          <div className="blog__header">
            <h1>{post?.title}</h1>
            <span>Blog Created : {post?.createdOn}</span>
          </div>
          <div className="blog__body">
            <p>{post?.content}</p>
          </div>
          <hr />
          <div className="blog__controller">
            <button>Edit</button>
            <button
              style={{
                backgroundColor: "red",
                color: "white",
              }}
              onClick={() => setRemovePopupTrigger(true)}
            >
              Delete
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