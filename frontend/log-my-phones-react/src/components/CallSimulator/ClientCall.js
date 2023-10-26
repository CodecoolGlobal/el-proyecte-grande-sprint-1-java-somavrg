import React from 'react';
import Box from "@mui/material/Box";
import TextField from "@mui/material/TextField";
import {Button, Grid, Switch, Typography} from "@mui/material";
import FormControlLabel from "@mui/material/FormControlLabel";

function ClientCall(props) {
    return (
        <Box sx={{flexGrow: 1, border: '1px solid', borderRadius:4, padding: '20px'}}>
            <Grid container spacing={2}>
                <Grid item xs={12}>
                    <Box textAlign='center'>
                        <Typography color='grey'>Client Call Simulation</Typography>
                    </Box>
                </Grid>
                <Grid item xs={12}>
                    <TextField
                        id="client-phone-number"
                        sx={{width: '100%'}}
                        label="Client Phone Number"></TextField>
                </Grid>
                <Grid item xs={12}>
                    <TextField
                        id="dispatcher-phone-number"
                        sx={{width: '100%'}}
                        label="Dispatcher Phone Number"
                    ></TextField>
                </Grid>
                <Grid item xs={12}>
                    <FormControlLabel
                        defaultChecked
                        control={
                            <Switch name="isSuccessful"/>
                        }
                        label="Dispatcher availability"
                    />
                </Grid>
                <Grid item xs={12}>
                    <Button variant="contained" size="large" sx={{width: '100%'}}>
                        CALL
                    </Button>
                </Grid>

            </Grid>
        </Box>
    );
}

export default ClientCall;