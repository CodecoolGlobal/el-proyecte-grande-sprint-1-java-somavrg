import React from 'react';
import {Button, Card, CardActions, CardContent, createTheme, ThemeProvider} from "@mui/material";
import Typography from "@mui/material/Typography";
import Divider from "@mui/material/Divider";
import Box from "@mui/material/Box";
import CssBaseline from "@mui/material/CssBaseline";
import ArrowForwardIcon from '@mui/icons-material/ArrowForward';
import DashboardCardIcon from "./DashboardCardIcon";

const theme = createTheme({
    typography: {
        button: {
            textTransform: "none",
            fontWeight: 'bold',
        }
    }
});

function DashboardCard({data}) {
    const infoTypeColor = theme.palette[`${data.infoType}`].light;
    return (
        <ThemeProvider theme={theme}>
            <CssBaseline/>
            <Card elevation={2} sx={{
                borderRadius: 4,
                background: `linear-gradient(to bottom right,
                    ${theme.palette[`${data.infoType}`].main + '44'} 0%,
                    ${theme.palette[`${data.infoType}`].main + '00'} 80%)`
            }}>
                <CardContent
                    spacing={3}
                    sx={{
                        mx: 5,
                        my: 2,
                        display: 'flex',
                        gap: '24px',
                        justifyContent: 'flex-start',
                        alignItems: 'center',
                    }}>
                    <Box>
                        <DashboardCardIcon icon={data.icon} color={infoTypeColor} />
                    </Box>
                    <Box sx={{
                        display: 'inline'
                    }}>
                        <Box sx={{
                            display: 'inline-block'
                        }}>
                            <Box sx={{
                                fontWeight: 'light',
                                color: 'text.secondary',
                            }}>{data.title}</Box>
                            <Box sx={{my: 0.5}}>
                                <Typography variant={"h4"} sx={{
                                    color: 'text.primary',
                                    fontWeight: 'bold'

                                }}>
                                    {data.statistic}
                                </Typography>
                            </Box>
                        </Box>
                    </Box>
                </CardContent>
                <Divider/>
                <CardActions>
                    <Button size="small" sx={{
                        color: 'text.primary',
                        '&:hover': {
                            backgroundColor: '#ffffff00',
                            color: 'text.primary',
                        }
                    }}>{data.buttonText}
                        <ArrowForwardIcon sx={{fontSize: 'medium', m: 0.5}}/>
                    </Button>
                </CardActions>
            </Card>
        </ThemeProvider>
    );
}

export default DashboardCard;