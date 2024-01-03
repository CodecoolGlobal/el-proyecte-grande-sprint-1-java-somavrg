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
        statisticName: 'handledCalls',
        buttonText: 'See calls',
        infoType: 'success'
    },
    {
        icon: <WatchLaterTwoToneIcon sx={{fontSize: DASHBOARD_DATA_ICON_SIZE, display: 'block'}}/>,
        title: 'Avg. call duration',
        statisticName: 'averageCallTime',
        buttonText: 'See statistics',
        infoType: 'info'
    },
    {
        icon: <PhoneMissedTwoToneIcon sx={{fontSize: DASHBOARD_DATA_ICON_SIZE, display: 'block'}}/>,
        title: 'Missed calls',
        statisticName: 'failedCalls',
        buttonText: 'See pending calls',
        infoType: 'error'
    },
]

const Dashboard = () => {
    const token = localStorage.getItem("jsonwebtoken");
    const [calls, setCalls] = useState();
    const [callStatistics, setCallStatistics] = useState();
    const [paginationPage, setPaginationPage] = useState()
    const [paginationPageSize, setPaginationPageSize] = useState()
    const [callDirection, setCallDirection] = useState("")

    useEffect(() => {
        const queries = [];

        if (paginationPage) queries.push(`pageNo=${paginationPage}`);
        if (paginationPageSize) queries.push(`pageSize=${paginationPageSize}`);
        if (callDirection) queries.push(`callDirection=${callDirection}`);

        let fetchString = `/api/calls?${queries.join("&")}`;

        const getCalls = async (token) => {
            const response =
                await fetch(fetchString, {
                headers: {
                    "Authorization": `Bearer ${token}`
                }
            });
            const callsData = await response.json();

            setCalls(callsData);
        }

        const getCallStatistics = async (token) => {
            const response =
                await fetch("/api/statistics/calls", {
                    headers: {
                        "Authorization": `Bearer ${token}`
                    }
                });
            const callStatistics = await response.json();

            setCallStatistics(callStatistics);
        }

        getCallStatistics(token);
        getCalls(token);

    }, [paginationPage, paginationPageSize, callDirection]);

    const handlePageChange = (newPage) => {
        setPaginationPage(newPage);
    }

    const handlePageSizeChange = (newSize) => {
        setPaginationPageSize(newSize);
    }

    const handleCallDirectionChange = (direction) => {
        setCallDirection(direction);
    }

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
                            <DashboardCard data={data} callStatistics={callStatistics}/>
                        </Grid>
                    ))}
                </Grid>
            </Grid>
            <Grid item sx={{my: 5, width: '100%'}}>
                <CallTable calls={calls}
                           onPageChange={handlePageChange}
                           onPageSizeChange={handlePageSizeChange}
                           onCallDirectionChange={handleCallDirectionChange}
                />
            </Grid>
        </Grid>
    )
}

export default Dashboard;

