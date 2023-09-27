import React from 'react';
import { Outlet, useNavigate } from "react-router-dom";
import Box from '@mui/material/Box';
import Drawer from '@mui/material/Drawer';
import ListSubheader from '@mui/material/ListSubheader';
import CssBaseline from '@mui/material/CssBaseline';
import Toolbar from '@mui/material/Toolbar';
import List from '@mui/material/List';
import Divider from '@mui/material/Divider';
import ListItem from '@mui/material/ListItem';
import ListItemButton from '@mui/material/ListItemButton';
import ListItemIcon from '@mui/material/ListItemIcon';
import ListItemText from '@mui/material/ListItemText';
import SpaceDashboardRoundedIcon from '@mui/icons-material/SpaceDashboardRounded';
import AddIcCallRoundedIcon from '@mui/icons-material/AddIcCallRounded';
import LeaderboardRoundedIcon from '@mui/icons-material/LeaderboardRounded';
import PermContactCalendarRoundedIcon from '@mui/icons-material/PermContactCalendarRounded';
import { Typography } from '@mui/material';





const drawerWidth = 340;



const RootLayout = () => {


    const navigate = useNavigate();

    const menuItems = [
        {
            text: "Dashboard",
            icon: <SpaceDashboardRoundedIcon />,
            path: "/dashboard"
        },
        {
            text: "Contacts",
            icon: <PermContactCalendarRoundedIcon />,
            path: "/contacts"
        },
        {
            text: "Add Phone",
            icon: <AddIcCallRoundedIcon />,
            path: "/addphone"
        },
        {
            text: "Statics",
            icon: <LeaderboardRoundedIcon />,
            path: "/statics"
        }
    ]



    return (
        <Box sx={{ display: 'flex'
         }}>
            <CssBaseline />

            <Drawer
                sx={{
                    width: drawerWidth,
                    flexShrink: 0,
                    '& .MuiDrawer-paper': {
                        width: drawerWidth,
                        boxSizing: 'border-box',
                    },
                }}
                variant="permanent"
                anchor="left"
            >
                <ListSubheader component="div" id="nested-list-subheader">
                    Example Ltd.
                </ListSubheader>
                <Divider />
                <List>
                        <List >
                            {menuItems.map(item => (
                                <ListItem key={item.text} disablePadding onClick={() => (navigate(item.path))}>
                                    <ListItemButton>
                                        <ListItemIcon>
                                            {item.icon}
                                        </ListItemIcon>
                                        <ListItemText primary={item.text} />
                                    </ListItemButton>
                                </ListItem>
                            ))}
                        </List>
                </List>
                <Divider />

            </Drawer>
            <Box
                component="main"
                sx={{ flexGrow: 1, bgcolor: 'background.default', p: 3 }}
            >
                <Toolbar />
                <Outlet />
            </Box>
        </Box>



    );
}

export default RootLayout




