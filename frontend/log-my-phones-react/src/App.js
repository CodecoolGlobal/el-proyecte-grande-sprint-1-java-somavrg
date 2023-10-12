import './App.css';
import {createBrowserRouter, createRoutesFromElements, Route, RouterProvider} from "react-router-dom";
import Contacts from './pages/Contacts';
import RootLayout from './layouts/RootLayout';
import Dashboard from './pages/Dashboard';
import Statistics from './pages/Statistics';
import AddPhone from './pages/AddPhone';
import LoginWindow from './components/LoginWindow';
import RegisterWindow from './components/RegisterWindow';
import Home from "./pages/Home";

const router = createBrowserRouter(
    createRoutesFromElements(
        [
            <Route path="/" element={<Home/>}>
                <Route path="login" element={<LoginWindow />}/>
                <Route path="register" element={<RegisterWindow />}/>
            </Route>,
            <Route path="/app" element={<RootLayout/>}>
                <Route path="dashboard" element={<Dashboard/>}/>
                <Route path="contacts" element={<Contacts/>}/>
                <Route path="statics" element={<Statistics/>}/>
                <Route path="addphone" element={<AddPhone/>}/>
            </Route>
        ]
    )
)

function App() {
    return (
        <RouterProvider router={router}/>
    );
}

export default App;
