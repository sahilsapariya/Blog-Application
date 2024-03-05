import React from "react";
import "../styles/Home.scss";
import { posts } from "../../data/data";

const Home = () => {
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
  return (
    <div className="blog__card">
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
