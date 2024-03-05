import React from "react";

const AddPost = () => {
  const handleSubmit = (e) => {
    e.preventDefault();

    const data = {
      title: e.target.title.value,
      content: e.target.content.value,
    };

    console.log(data);
  };

  return (
    <div className="form__container">
      <form onSubmit={handleSubmit}>

        <div className="form__group">
          <label htmlFor="title">Title</label>
          <input
            type="text"
            name="title"
            placeholder="Enter title"
            id="title"
          />
        </div>
        <div className="form__group">
          <label htmlFor="body">Body</label>
          <textarea
            id="body"
            name="content"
            placeholder="Enter content"
            rows="15"
          ></textarea>
        </div>
        <button type="submit">Add Post</button>
      </form>
    </div>
  );
};

export default AddPost;
