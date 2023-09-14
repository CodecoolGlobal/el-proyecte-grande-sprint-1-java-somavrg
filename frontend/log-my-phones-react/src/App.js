import './App.css';
import {createBrowserRouter, createRoutesFromElements, Route, RouterProvider} from "react-router-dom";
import Contacts from './pages/Contacts';

const router = createBrowserRouter(
  createRoutesFromElements(
    <Route path="/" element={<Contacts/>}></Route>
  )
)

function App() {
  return (
   <RouterProvider router={router}/>
  );
}

export default App;
