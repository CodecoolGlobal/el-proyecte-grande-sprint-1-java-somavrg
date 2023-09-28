import React from 'react';
import Box from "@mui/material/Box";

function DashboardCardIcon({icon, color}) {
    return (
        <Box sx={{
            backgroundColor: color,
            borderRadius: 4,
            padding: 2,
            color: 'white',
            boxShadow: `0px 0px 20px ${color}`

        }}>
            {icon}
        </Box>
    );
}

export default DashboardCardIcon;