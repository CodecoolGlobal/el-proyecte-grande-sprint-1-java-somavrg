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
import { secondsToTimeString } from "../utils/TimeConverter";


const DASHBOARD_DATA_ICON_SIZE = 40;

const dashboardCards = {
    handledCalls: {
        icon: <PhoneInTalkTwoToneIcon sx={{fontSize: DASHBOARD_DATA_ICON_SIZE, display: 'block'}}/>,
        title: 'Handled calls',
        buttonText: 'See calls',
        infoType: 'success'
    },
    averageCallTime: {
        icon: <WatchLaterTwoToneIcon sx={{fontSize: DASHBOARD_DATA_ICON_SIZE, display: 'block'}}/>,
        title: 'Avg. call duration',
        buttonText: 'See statistics',
        infoType: 'info'
    },
    failedCalls: {
        icon: <PhoneMissedTwoToneIcon sx={{fontSize: DASHBOARD_DATA_ICON_SIZE, display: 'block'}}/>,
        title: 'Missed calls',
        buttonText: 'See pending calls',
        infoType: 'error'
    }
}

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
            <CssBaseline/>
            <Grid item sx={{my: 5, width: '100%'}}>
                <Typography variant='h2' fontWeight='bold'>Dashboard</Typography>
            </Grid>
            <Grid item sx={{width: '100%'}}>
                <Grid container spacing={4}>
                    <Grid item md={4} xs={12}>
                        <DashboardCard
                            data={dashboardCards.handledCalls}
                            statisticValue={callStatistics?.handledCalls}
                        />
                    </Grid>
                    <Grid item md={4} xs={12}>
                        <DashboardCard
                            data={dashboardCards.averageCallTime}
                            statisticValue={secondsToTimeString(callStatistics?.averageCallTime, true)}
                        />
                    </Grid>
                    <Grid item md={4} xs={12}>
                        <DashboardCard
                            data={dashboardCards.failedCalls}
                            statisticValue={callStatistics?.failedCalls}
                        />
                    </Grid>
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

