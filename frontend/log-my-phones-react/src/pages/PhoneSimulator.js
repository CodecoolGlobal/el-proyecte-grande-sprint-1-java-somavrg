import React from 'react';
import {Grid, Paper, Typography} from "@mui/material";
import Box from "@mui/material/Box";
import {createTheme, ThemeProvider} from "@mui/material/styles";
import CssBaseline from "@mui/material/CssBaseline";
import ClientCall from "../components/CallSimulator/ClientCall";

const theme = createTheme({
    palette: {
        mode: 'dark'
    }
})

function Call(dispatcherPhoneNumber, clientPhoneNumber, startTime, isSuccessful, callDirection) {
    this.dispatcherPhoneNumber = dispatcherPhoneNumber;
    this.clientPhoneNumber = clientPhoneNumber;
    this.startTime = startTime;
    this.isSuccessful = isSuccessful;
    this.callDirection = callDirection;
}

const activeCalls = [];

function PhoneSimulator(props) {
    return (
        <ThemeProvider theme={theme}>
            <CssBaseline />
            <Box sx={{flexGrow: 1}} padding={3}>
                <Grid container spacing={3} justifyContent='space-around'>
                    <Grid item container xs={12} spacing={3}>
                        <Grid item xs={6}>
                            <Typography variant='h5' align='center' sx={{marginBottom: '30px'}}>INCOMING</Typography>
                            <ClientCall />
                        </Grid>
                        <Grid item xs={6}>
                            <Typography variant='h5' align='center' sx={{marginBottom: '30px'}}>OUTGOING</Typography>
                            <ClientCall />
                        </Grid>
                    </Grid>
                </Grid>
            </Box>
        </ThemeProvider>
    );
}

export default PhoneSimulator;