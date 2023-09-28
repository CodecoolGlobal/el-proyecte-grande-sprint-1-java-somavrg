import React from 'react';
import PhoneIcon from '@mui/icons-material/Phone';
import {Grid, Typography} from "@mui/material";
import Box from "@mui/material/Box";

function CallTablePhoneNumberCell({phoneNumber}) {
    return (
        <Grid container alignItems='center'>
            <PhoneIcon fontSize='small' sx={{display: 'inline-block', marginRight: '8px'}}/>
            <Typography sx={{display: 'inline-block'}}>{phoneNumber}</Typography>
        </Grid>
    );
}

export default CallTablePhoneNumberCell;