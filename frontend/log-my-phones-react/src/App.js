import './App.css';
import { createBrowserRouter, createRoutesFromElements, Route, RouterProvider } from "react-router-dom";
import Contacts from './pages/Contacts';
import RootLayout from './layouts/RootLayout';
import Dashboard from './pages/Dashboard';
import Statics from './pages/Statics';
import AddPhone from './pages/AddPhone';

const router = createBrowserRouter(
  createRoutesFromElements(
    <Route path="/" element={<RootLayout />}>
      <Route path="dashboard" element={<Dashboard/>}></Route>
      <Route path="contacts" element={<Contacts />}></Route>
      <Route path="statics" element={<Statics/>}></Route>
      <Route path="addphone" element={<AddPhone/>}></Route>
    </Route>
  )
)

function App() {
  return (
    <RouterProvider router={router} />
  );
}

export default App;
