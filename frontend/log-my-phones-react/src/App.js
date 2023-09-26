import './App.css';
import { createBrowserRouter, createRoutesFromElements, Route, RouterProvider } from "react-router-dom";
import Contacts from './pages/Contacts';
import RootLayout from './layouts/RootLayout';

const router = createBrowserRouter(
  createRoutesFromElements(
    <Route path="/" element={<RootLayout />}>
      <Route path="contacts" element={<Contacts />}></Route>
    </Route>

  )
)

function App() {
  return (
    <RouterProvider router={router} />
  );
}

export default App;
