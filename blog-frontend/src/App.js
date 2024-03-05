import { Route, Routes, BrowserRouter } from "react-router-dom";
import Home from "./components/pages/Home";
import Navbar from "./components/common/Navbar";
import Footer from "./components/common/Footer";
import AddPost from "./components/pages/AddPost";
import ViewBlog from "./components/pages/ViewBlog";
import UpdatePost from "./components/pages/UpdatePost";



function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Navbar />
        <Routes>
          <Route path="/" index element={<Home />} />
          <Route path="/add-blog" exact element={<AddPost />} />
          <Route path="/blogs/:blogId" exact element={<ViewBlog />} />
          <Route path="/blogs/:blogId/edit" exact element={<UpdatePost />} />
        </Routes>
        <Footer />
      </BrowserRouter>
    </div>
  );
}

export default App;
