import React from 'react';
import {Paper} from "@mui/material";
import Box from "@mui/material/Box";
import {grey} from "@mui/material/colors";

const monthNamesShort = [
    'Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'
]

function CallTableDateCell({ date }) {
    const displayDate = (date) => {
        const theDate = new Date(date);
        return {
            month: monthNamesShort[theDate.getMonth()],
            day: theDate.getDate()
        }
    }
    return (
        <Paper
            elevation={0}
            sx={{
                backgroundColor: grey[200],
                display: 'inline-block',
                borderRadius: 50,
                p: 1,
        }}>
            <Box>
                {displayDate(date).month}
            </Box>
            <Box>
                {displayDate(date).day}
            </Box>
        </Paper>
    );
}

export default CallTableDateCell;