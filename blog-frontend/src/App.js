import { Route, Routes, BrowserRouter } from "react-router-dom";
import Home from "./components/pages/Home";
import Navbar from "./components/common/Navbar";



function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Navbar />
        <Routes>
          <Route path="/" index element={<Home />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
