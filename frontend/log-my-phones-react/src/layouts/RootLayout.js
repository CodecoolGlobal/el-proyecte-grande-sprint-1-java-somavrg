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
import { blue, } from '@mui/material/colors';
import { Avatar, Typography } from '@mui/material';




const drawerWidth = 260;



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
        <Box sx={{
            display: 'flex',


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
                <Box sx={{
                    display: 'flex',
                    alignItems: 'center',
                    m: 3
                    }}>
                    <Avatar sx={{mx: 3}}/>
                    <Typography sx={{lineHeight: 'normal'}}>Example Ltd.</Typography>
                </Box>
                <Divider />
                <List sx={{
                    mx: 1.5

                }}>
                    {menuItems.map(item => (
                        <ListItem key={item.text} disablePadding onClick={() => (navigate(item.path))}>
                            <ListItemButton sx={{ borderRadius: '16px' }}  >
                                <ListItemIcon>
                                    {item.icon}
                                </ListItemIcon>
                                <ListItemText sx={{ fontWeight: 'medium',  }} primary={item.text} />
                            </ListItemButton>
                        </ListItem>
                    ))}
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




