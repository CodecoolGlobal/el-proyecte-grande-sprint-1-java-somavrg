import React from 'react';
import { Outlet, useNavigate } from "react-router-dom";
import Box from '@mui/material/Box';
import Drawer from '@mui/material/Drawer';
import CssBaseline from '@mui/material/CssBaseline';
import Toolbar from '@mui/material/Toolbar';
import List from '@mui/material/List';
import Divider from '@mui/material/Divider';
import ListItem from '@mui/material/ListItem';
import ListItemButton from '@mui/material/ListItemButton';
import ListItemIcon from '@mui/material/ListItemIcon';
import ListItemText from '@mui/material/ListItemText';
import InboxIcon from '@mui/icons-material/MoveToInbox';
import MailIcon from '@mui/icons-material/Mail';


const drawerWidth = 240;


const RootLayout = () => {

   
    const navigate = useNavigate();

    const menuItems = [
        {
            text: "Dashboard",
            icon: <InboxIcon />,
            path: "/dashboard"
        },
        {
            text: "Contacts",
            icon: <InboxIcon />,
            path: "/contacts"
        },
        {
            text: "Add Phone",
            icon: <InboxIcon />,
            path: "/addphone"
        },
        {
            text: "Statics",
            icon: <InboxIcon />,
            path: "/statics"
        }
    ]

 

    return (
        <Box sx={{ display: 'flex' }}>
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
                <Toolbar />
                <Divider />
                <List>

                    <List>
                        {menuItems.map(item => (
                            <ListItem key={item.text} disablePadding onClick={() => (navigate(item.path))}>
                                <ListItemButton>
                                    <ListItemIcon>
                                        <MailIcon />
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




