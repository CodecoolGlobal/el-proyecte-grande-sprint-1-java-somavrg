import React, {useEffect, useState} from 'react';
import {Typography} from "@mui/material";
import {Outlet, useNavigate} from "react-router-dom";

function Home(props) {
    const token = localStorage.getItem("jsonwebtoken");

    const navigate = useNavigate();

    useEffect(() => {
        if (token) {
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