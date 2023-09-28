import React from 'react';
import Box from "@mui/material/Box";
import {Grid, Typography} from "@mui/material";
import AccessTimeIcon from '@mui/icons-material/AccessTime';

function CallTableDurationCell({duration}) {
    return (
        <Grid container alignItems='center'>
            <AccessTimeIcon fontSize='small' sx={{display: 'inline-block', marginRight: '8px'}}/>
            <Typography sx={{display: 'inline-block'}}>{duration}</Typography>
        </Grid>
    );
}

export default CallTableDurationCell;
