import React, {useEffect} from 'react';
import {Typography} from "@mui/material";
import {Outlet, useNavigate} from "react-router-dom";

function Home(props) {
    const hasToken = localStorage.getItem("jsonwebtoken");
    const navigate = useNavigate();

    useEffect(() => {
        console.log(hasToken)
        if (hasToken) {
            navigate("/app");
        }
    }, []);

    return (
        <div>
            <Typography variant='h1'>
                Home Page
            </Typography>
            <Outlet />
        </div>
    );
}

export default Home;