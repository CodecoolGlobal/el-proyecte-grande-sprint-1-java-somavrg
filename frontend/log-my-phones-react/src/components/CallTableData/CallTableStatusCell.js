import React from 'react';
import {Chip} from "@mui/material";

function CallTableStatusCell({status, color}) {
    return (
        <Chip size="small" label={status} variant='outlined' color={color} sx={{color: 'text.primary'}}/>
    );
}

export default CallTableStatusCell;