import React, { useState } from "react";
import { useParams } from "react-router-dom";
import "./../styles/Blog.scss";
import Popup from "../common/Popup";

const ViewBlog = () => {
  const { blogId } = useParams();
  const [removePopupTrigger, setRemovePopupTrigger] = useState(false);

  const post = {
    id: 4,
    title: "Post 4",
    content:
      "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc.",
    createdOn: "2021-08-01",
  };

  const handleDelete = () => {};

  return (
    <>
      <div className="blog__container">
        <div className="blog__content">
          <div className="blog__header">
            <h1>{post.title}</h1>
            <span>Blog Created : {post.createdOn}</span>
          </div>
          <div className="blog__body">
            <p>{post.content}</p>
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
