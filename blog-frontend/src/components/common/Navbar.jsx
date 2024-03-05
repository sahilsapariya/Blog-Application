import React from "react";
import { NavLink } from "react-router-dom";
import './../styles/Components.scss'


const Navbar = () => {
  return (
    <nav>
      <h1>Blog App</h1>
      <ul>
        <li>
          <NavLink to="/">Home</NavLink>
        </li>
        <li>
          <NavLink to="/add-blog">Add Blog</NavLink>
        </li>
      </ul>
    </nav>
  );
};

export default Navbar;
