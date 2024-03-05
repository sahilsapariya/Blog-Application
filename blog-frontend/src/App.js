import { createBrowserRouter, RouterProvider } from 'react-router-dom'
import Home from './components/pages/Home';

const router = createBrowserRouter([
  {
    path: '/',
    element: <Home />
  },
])

function App() {
  return (
    <div className="App">
      <RouterProvider router={router} />
    </div>
  );
}

export default App;
