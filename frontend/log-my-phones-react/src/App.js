import './App.css';
import { createBrowserRouter, createRoutesFromElements, Route, RouterProvider } from "react-router-dom";
import Contacts from './pages/Contacts';
import RootLayout from './layouts/RootLayout';
import Dashboard from './pages/Dashboard';
import Statistics from './pages/Statistics';
import AddPhone from './pages/AddPhone';
import LoginWindow from './components/LoginWindow';
import RegisterWindow from './components/RegisterWindow';

const router = createBrowserRouter(
  createRoutesFromElements(
    <Route path="/" element={<RootLayout />}>
      <Route path='login' element={<LoginWindow />}></Route>
      <Route path='register' element={<RegisterWindow />}></Route>
      <Route path="dashboard" element={<Dashboard />}></Route>
      <Route path="contacts" element={<Contacts />}></Route>
      <Route path="statics" element={<Statistics />}></Route>
      <Route path="addphone" element={<AddPhone />}></Route>
    </Route>
  )
)

function App() {
  return (
    <RouterProvider router={router} />
  );
}

export default App;
