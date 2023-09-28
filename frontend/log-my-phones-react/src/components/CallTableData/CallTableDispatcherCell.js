import React from 'react';
import {Chip} from "@mui/material";
import AccountCircleIcon from '@mui/icons-material/AccountCircle';

function CallTableDispatcherCell({dispatcher}) {
    return (
        <Chip icon={<AccountCircleIcon />} label={dispatcher} variant='outlined' />
    );
}

export default CallTableDispatcherCell;