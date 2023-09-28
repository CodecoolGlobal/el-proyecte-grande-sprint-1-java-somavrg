import React from 'react';
import { Outlet, useNavigate, useLocation } from "react-router-dom";
import Box from '@mui/material/Box';
import Drawer from '@mui/material/Drawer';
import CssBaseline from '@mui/material/CssBaseline';
import Toolbar from '@mui/material/Toolbar';
import List from '@mui/material/List';
import ListItem from '@mui/material/ListItem';
import ListItemButton from '@mui/material/ListItemButton';
import ListItemIcon from '@mui/material/ListItemIcon';
import ListItemText from '@mui/material/ListItemText';
import SpaceDashboardRoundedIcon from '@mui/icons-material/SpaceDashboardRounded';
import AddIcCallRoundedIcon from '@mui/icons-material/AddIcCallRounded';
import LeaderboardRoundedIcon from '@mui/icons-material/LeaderboardRounded';
import PermContactCalendarRoundedIcon from '@mui/icons-material/PermContactCalendarRounded';
import { Avatar, Typography } from '@mui/material';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import KeyboardArrowDownIcon from '@mui/icons-material/KeyboardArrowDown';
import IconButton from '@mui/material/IconButton';
import MenuItem from '@mui/material/MenuItem';
import Fade from '@mui/material/Fade';
import Menu from '@mui/material/Menu';








const drawerWidth = 280;

const theme = createTheme({
    palette: {
        main: "#1C2536",
        light: "#6366F1",
        dark: "#bdbdbd",
        hover: "#252E3E"
    }
});


const RootLayout = () => {

    const [anchorEl, setAnchorEl] = React.useState(null);
    const open = Boolean(anchorEl);
    const handleClick = (event) => {
        setAnchorEl(event.currentTarget);
    };
    const handleClose = () => {
        setAnchorEl(null);
    };
    const navigate = useNavigate();
    const location = useLocation();

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
            text: "Statistics",
            icon: <LeaderboardRoundedIcon />,
            path: "/statistics"
        }
    ]

    return (
        <Box sx={{
            display: 'flex',
        }}>
            <ThemeProvider theme={theme}>
                <CssBaseline />
                <Drawer
                    sx={{
                        width: drawerWidth,
                        flexShrink: 0,

                        '& .MuiDrawer-paper': {
                            width: drawerWidth,
                            boxSizing: 'border-box',
                            backgroundColor: "main",
                            color: "dark"
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

                        <Avatar sx={{ marginRight: 3 }} />

                        <Box>
                            <Typography sx={{ fontSize: 12, }}>Logged in as</Typography>
                            <Typography variant='h6' sx={{ lineHeight: 'normal', color: "#F9F9F9" }}>Example Ltd.</Typography>
                        </Box>
                        <Box >
                            <IconButton id="fade-button"
                                aria-controls={open ? 'fade-menu' : undefined}
                                aria-haspopup="true"
                                aria-expanded={open ? 'true' : undefined}
                                onClick={handleClick}>
                                <KeyboardArrowDownIcon sx={{ marginLeft: 2, color: "dark" }}></KeyboardArrowDownIcon>
                            </IconButton>
                            <Menu
                                id="fade-menu"
                                MenuListProps={{
                                    'aria-labelledby': 'fade-button',
                                }}
                                anchorEl={anchorEl}
                                open={open}
                                onClose={handleClose}
                                TransitionComponent={Fade}
                            >
                                <MenuItem onClick={handleClose}>Profile</MenuItem>
                                <MenuItem onClick={handleClose}>Logout</MenuItem>
                            </Menu>
                        </Box >
                    </Box>
                    <List sx={{
                        mx: 1.5
                    }}>
                        {menuItems.map(item => (
                            <ListItem key={item.text} sx={{ my: 1 }} disablePadding onClick={() => (navigate(item.path))}>
                                <ListItemButton sx={{
                                    borderRadius: '16px',
                                    backgroundColor: location.pathname === item.path ? "hover" : "transparent",
                                    color: location.pathname === item.path ? "light" : "dark",
                                    '& .MuiListItemIcon-root': {
                                        color: location.pathname === item.path ? "light" : "dark",
                                    },
                                    '&:hover': {
                                        backgroundColor: location.pathname === item.path ? "hover" : "hover",
                                    },
                                }}  >
                                    <ListItemIcon sx={{ color: 'dark' }} >
                                        {item.icon}
                                    </ListItemIcon>
                                    <ListItemText primary={item.text} primaryTypographyProps={{
                                        sx: {
                                        },
                                    }} />
                                </ListItemButton>
                            </ListItem>
                        ))}
                    </List>
                </Drawer>
            </ThemeProvider>
            <Box
                component="main"
                sx={{ flexGrow: 1, bgcolor: 'background.default', p: 3 }}
            >
                <Outlet />
            </Box>
        </Box>
    );
}

export default RootLayout




