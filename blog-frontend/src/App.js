import { Route, Routes, BrowserRouter } from "react-router-dom";
import Home from "./components/pages/Home";
import Navbar from "./components/common/Navbar";
import Footer from "./components/common/Footer";



function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Navbar />
        <Routes>
          <Route path="/" index element={<Home />} />
        </Routes>
        <Footer />
      </BrowserRouter>
    </div>
  );
}

export default App;
