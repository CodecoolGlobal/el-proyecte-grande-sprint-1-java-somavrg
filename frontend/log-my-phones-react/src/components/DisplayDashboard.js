import React from 'react';
import {Image} from "@mui/icons-material";
import {Button, Grid, Paper, Typography} from "@mui/material";
import NavigateNextIcon from '@mui/icons-material/NavigateNext';

function DisplayDashboard(props) {
    return (
        <Grid container my={7}>
            <Grid item xs={4} paddingRight={7}>
                <Typography variant='h3' fontWeight='700' paddingBottom={2}>
                    <Typography variant='h3' fontWeight='700' color="primary">Elevate</Typography> your call management game
                </Typography>
                <Typography variant='headline2' paddingBottom={2}>
                    With the ability to display recent calls by device and status, it delivers valuable insights into your communication operations.
                </Typography>
                <br/>
                <Button variant="contained" sx={{marginY: '20px'}} endIcon={<NavigateNextIcon />} size='large'>Let's begin!</Button>
            </Grid>
            <Grid item xs={8}>
                <Paper
                    component='img'
                    alt="Display dashboard of the application."
                    src="/dashboard-display.png"
                    elevation={6}
                    sx={{
                        width: '100%',
                        borderRadius: 4
                    }}
                />
            </Grid>
        </Grid>
    );
}

export default DisplayDashboard;