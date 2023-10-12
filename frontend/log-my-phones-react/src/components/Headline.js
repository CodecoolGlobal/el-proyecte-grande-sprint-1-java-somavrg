import React from 'react';
import {Grid, Typography} from "@mui/material";
import PhonelinkRingTwoToneIcon from "@mui/icons-material/PhonelinkRingTwoTone";
import LocalPhoneTwoToneIcon from '@mui/icons-material/LocalPhoneTwoTone';

function Headline(props) {
    return (
        <Grid container justifyContent='center' sx={{
            paddingX: '120px',
            paddingTop: '100px',
            textAlign: 'center',
            fontFamily: 'Outfit'
        }}>
            <Grid item>
                <Typography variant='h2' sx={{fontWeight: 600}}>
                    Simplify Business Calls
                    <LocalPhoneTwoToneIcon color='primary' fontSize='inherit' sx={{mx: '15px'}}/>
                    with LogMyPhones <PhonelinkRingTwoToneIcon color='primary' fontSize='inherit' sx={{mx: '15px'}}/>
                </Typography>
            </Grid>
            <Grid item mt={5}>
                <Typography variant='h6' sx={{fontWeight: 300}}>
                    LogMyPhones simplifies call tracking, filtering, and device performance analysis for businesses.
                </Typography>
            </Grid>
        </Grid>
    );
}

export default Headline;