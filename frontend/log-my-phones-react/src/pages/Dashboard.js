import {
    Grid,
    Typography
} from "@mui/material";
import DashboardCard from "../components/DashboardCard";
import PhoneInTalkTwoToneIcon from '@mui/icons-material/PhoneInTalkTwoTone';
import WatchLaterTwoToneIcon from '@mui/icons-material/WatchLaterTwoTone';
import PhoneMissedTwoToneIcon from '@mui/icons-material/PhoneMissedTwoTone';
import CallTable from "../components/CallTable";
import CssBaseline from "@mui/material/CssBaseline";
import {useEffect, useState} from "react";


const DASHBOARD_DATA_ICON_SIZE = 40;

const dashboardData = [
    {
        icon: <PhoneInTalkTwoToneIcon sx={{fontSize: DASHBOARD_DATA_ICON_SIZE, display: 'block'}} />,
        title: 'Handled calls',
        statistic: 624,
        buttonText: 'See calls',
        infoType: 'success'
    },
    {
        icon: <WatchLaterTwoToneIcon sx={{fontSize: DASHBOARD_DATA_ICON_SIZE, display: 'block'}}/>,
        title: 'Avg. call duration',
        statistic: 367,
        buttonText: 'See statistics',
        infoType: 'info'
    },
    {
        icon: <PhoneMissedTwoToneIcon sx={{fontSize: DASHBOARD_DATA_ICON_SIZE, display: 'block'}}/>,
        title: 'Missed calls',
        statistic: 4,
        buttonText: 'See pending calls',
        infoType: 'error'
    },
]

const Dashboard = () => {
    const token = localStorage.getItem("jsonwebtoken");
    const [calls, setCalls] = useState();

    useEffect(() => {
        const getCalls = async (token) => {
            const response = await fetch("/api/calls", {
                headers: {
                    "Authorization": `Bearer ${token}`
                }
            });
            const callsData = await response.json();

            setCalls(callsData);
        }

        getCalls(token)

    }, []);

    console.log(token);

    return (
        <Grid container>
            <CssBaseline />
            <Grid item sx={{my: 5, width: '100%'}}>
                <Typography variant='h2' fontWeight='bold'>Dashboard</Typography>
            </Grid>
            <Grid item sx={{width: '100%'}}>
                <Grid container spacing={4}>
                    {dashboardData.map(data => (
                        <Grid item md={4} xs={12}>
                            <DashboardCard data={data}/>
                        </Grid>
                    ))}
                </Grid>
            </Grid>
            <Grid item sx={{my: 5, width: '100%'}}>
                <CallTable calls={calls}/>
            </Grid>
        </Grid>
    )
}

export default Dashboard;

