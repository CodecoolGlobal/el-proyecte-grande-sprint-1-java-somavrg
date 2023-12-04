import React, {useEffect, useState} from 'react';
import {Grid, Modal, Typography} from "@mui/material";
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
    const [openLogin, setOpenLogin] = useState(false);

    const handleOpenRegistration = () => setOpenRegistration(true);
    const handleCloseRegistration = () => setOpenRegistration(false);
    const handleOpenLogin = () => setOpenLogin(true);
    const handleCloseLogin = () => setOpenLogin(false);

    useEffect(() => {
        if (token) {
            navigate("/app");
        }
    }, []);

    return (
        <ThemeProvider theme={theme}>
            <NavigationMenu onLogin={handleOpenLogin} onRegister={handleOpenRegistration}/>
            <Modal
                open={openRegistration}
                onClose={handleCloseRegistration}
            >
                <RegisterWindow onRegister={handleCloseRegistration}/>
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
        </ThemeProvider>
    );
}

export default Home;