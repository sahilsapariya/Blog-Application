import React from "react";
import "../styles/Home.scss";

import { useNavigate } from "react-router-dom";
import useFetch from "../../hook/useFetch";
import { baseurl } from "../../config";

const Home = () => {
  const { data: posts, loading, error } = useFetch(`${baseurl}/posts`);

  if (loading) return <div>Loading...</div>;

  if (error) return <div>Error: {error}</div>;

  return (
    <div className="home__container">
      <BlogList blogs={posts} />
    </div>
  );
};

const BlogList = ({ blogs }) => {
  return (
    <div className="blog__list">
      {blogs?.map((blog) => {
        return <BlogCard key={blog.id} blog={blog} />;
      })}
    </div>
  );
};

const BlogCard = ({ blog }) => {
  const navigate = useNavigate();

  return (
    <div className="blog__card" onClick={() => navigate(`blogs/${blog.id}`)}>
      <div className="blog__header">
        <h2>{blog.title}</h2>
        <span>{blog.createdOn}</span>
      </div>
      <div className="blog__content">
        <p>{blog.content}</p>
      </div>
    </div>
  );
};

export default Home;
