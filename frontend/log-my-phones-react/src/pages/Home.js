import React, {useEffect, useState} from 'react';
import {Alert, Grid, Modal, Snackbar, Typography} from "@mui/material";
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
    const [openRegistration, setOpenRegistration] = useState(false);
    const [openRegistrationSuccess, setOpenRegistrationSuccess] = useState(false);
    const [openLogin, setOpenLogin] = useState(false);

    const handleOpenRegistration = () => setOpenRegistration(true);
    const handleCloseRegistration = () => setOpenRegistration(false);
    const handleOpenLogin = () => setOpenLogin(true);
    const handleCloseLogin = () => setOpenLogin(false);
    const handleSuccessfulRegistration = () => {
        setOpenRegistrationSuccess(true);
        setOpenRegistration(false);
    }

    const handleCloseRegistrationSuccess = (event, reason) => {
        if (reason === 'clickaway') {
            return;
        }
        setOpenRegistrationSuccess(false);
    };

    useEffect(() => {
        if (token) {
            navigate("/app/dashboard");
        }
    }, []);

    return (
        <ThemeProvider theme={theme}>
            <NavigationMenu onLogin={handleOpenLogin} onRegister={handleOpenRegistration}/>
            <Modal
                open={openRegistration}
                onClose={handleCloseRegistration}
            >
                <RegisterWindow onRegister={handleSuccessfulRegistration}/>
            </Modal>
            <Modal
                open={openLogin}
                onClose={handleCloseLogin}
            >
                <LoginWindow/>
            </Modal>
            <Box sx={{width:'1100px', mx:'auto'}}>
                <Headline />
                <DisplayDashboard theme={theme}/>
            </Box>
            <Snackbar open={openRegistrationSuccess} autoHideDuration={6000}
                      onClose={handleCloseRegistrationSuccess}>
                <Alert onClose={handleCloseRegistrationSuccess} severity="success"
                       sx={{width: '100%'}}>
                    Registration successful!
                </Alert>
            </Snackbar>
        </ThemeProvider>
    );
}

export default Home;