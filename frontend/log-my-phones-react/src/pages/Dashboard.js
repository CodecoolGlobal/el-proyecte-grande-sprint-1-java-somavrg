import {Card, Grid, makeStyles} from "@mui/material";
import DashboardCard from "../components/DashboardCard";
import PhoneInTalkTwoToneIcon from '@mui/icons-material/PhoneInTalkTwoTone';
import WatchLaterTwoToneIcon from '@mui/icons-material/WatchLaterTwoTone';
import PhoneMissedTwoToneIcon from '@mui/icons-material/PhoneMissedTwoTone';

const DASHBOARD_DATA_ICON_SIZE = 40;

const Dashboard = () => {
    const dashboardData = [
        {
            icon: <PhoneInTalkTwoToneIcon sx={{fontSize: DASHBOARD_DATA_ICON_SIZE}} />,
            title: 'Handled calls',
            statistic: 624,
            buttonText: 'See calls',
            infoType: 'success'
        },
        {
            icon: <WatchLaterTwoToneIcon sx={{fontSize: DASHBOARD_DATA_ICON_SIZE}}/>,
            title: 'Avg. call duration',
            statistic: 367,
            buttonText: 'See statistics',
            infoType: 'info'
        },
        {
            icon: <PhoneMissedTwoToneIcon sx={{fontSize: DASHBOARD_DATA_ICON_SIZE}}/>,
            title: 'Missed calls',
            statistic: 4,
            buttonText: 'See pending calls',
            infoType: 'error'
        },

    ]
    return (
        <div>
            <Grid container spacing={4}>
                {dashboardData.map(data => (
                    <Grid item md={4} xs={12}>
                        <DashboardCard data={data}/>
                    </Grid>
                ))}
            </Grid>
        </div>
    )
}

export default Dashboard;

