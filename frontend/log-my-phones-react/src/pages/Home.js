import React, {useEffect, useState} from 'react';
import {Grid, Typography} from "@mui/material";
import {Outlet, useNavigate} from "react-router-dom";
import NavigationMenu from "../components/NavigationMenu";
import {createTheme, ThemeProvider} from "@mui/material/styles";
import Box from "@mui/material/Box";
import Headline from "../components/Headline";
import DisplayDashboard from "../components/DisplayDashboard";
import LoginWindow from "../components/LoginWindow";
import RegisterWindow from "../components/RegisterWindow";

const theme = createTheme({
    typography: {
        fontFamily: "'Outfit', sans-serif"
    }
})

function Home(props) {
    const token = localStorage.getItem("jsonwebtoken");
    const navigate = useNavigate();
    const [showLoginWindow, setShowLoginWindow] = useState(false);
    const [showRegisterWindow, setShowRegisterWindow] = useState(false);

    useEffect(() => {
        if (token) {
            navigate("/app");
        }
    }, []);

    function handleLoginClick() {
        setShowLoginWindow(true);
    }

    function handleRegisterClick() {
        setShowRegisterWindow(true);
    }

    function handleAfterRegister() {
        setShowRegisterWindow(false);
    }

    return (
        <ThemeProvider theme={theme}>
            {showLoginWindow ? <LoginWindow /> : null}
            {showRegisterWindow ? <RegisterWindow onRegister={handleAfterRegister}/> : null}
            <NavigationMenu onLogin={handleLoginClick} onRegister={handleRegisterClick}/>
            <Box sx={{width:'1100px', mx:'auto'}}>
                <Headline />
                <DisplayDashboard theme={theme}/>
            </Box>
        </ThemeProvider>
    );
}

export default Home;