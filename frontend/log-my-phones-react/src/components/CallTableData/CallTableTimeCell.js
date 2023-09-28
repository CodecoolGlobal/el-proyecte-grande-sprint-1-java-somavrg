import React from 'react';
import {Typography} from "@mui/material";

const getTime = (date) => {
    const theDate = new Date(date);

    return {
        hours: theDate.getHours(),
        minutes: theDate.getMinutes()
    };
}

function CallTableTimeCell({ date }) {
    return <Typography>{getTime(date).hours}:{getTime(date).minutes}</Typography>;
}

export default CallTableTimeCell;