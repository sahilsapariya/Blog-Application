import React, { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import useFetch from "../../hook/useFetch";
import { baseurl } from "../../config";

const UpdatePost = () => {
  const { blogId } = useParams();
  const {
    data: post,
    loading,
    error,
    putData: updateData,
  } = useFetch(`${baseurl}/posts/${blogId}`);

  const navigate = useNavigate();

  const [formData, setFormData] = useState(post);

  useEffect(() => {
    setFormData(post);
  }, [post]);

  const handleInputChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      await updateData(`${baseurl}/posts`, formData);
      navigate(`/blogs/${blogId}`);
    } catch (error) {
      console.error("Error adding post:", error);
    }
  };

  if (loading) return <div>Loading...</div>;
  if (error) return <div>Error: {error}</div>;

  return (
    <div className="form__container">
      <form onSubmit={handleSubmit}>
        <div className="form__group">
          <label htmlFor="title">Title</label>
          <input
            type="text"
            name="title"
            placeholder="Enter title"
            value={formData?.title}
            onChange={handleInputChange}
            id="title"
          />
        </div>
        <div className="form__group">
          <label htmlFor="body">Body</label>
          <textarea
            id="body"
            name="content"
            placeholder="Enter content"
            onChange={handleInputChange}
            rows="15"
            value={formData?.content}
          ></textarea>
        </div>
        <button type="submit">Update Post</button>
      </form>
    </div>
  );
};

export default UpdatePost;
