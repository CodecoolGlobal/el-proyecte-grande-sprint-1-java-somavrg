import React from 'react';
import {
    createTheme, Grid, Pagination,
    Paper, Tab,
    Table,
    TableBody,
    TableCell,
    TableContainer,
    TableHead,
    TablePagination,
    TableRow, Tabs, Typography
} from "@mui/material";
import CallTableDateCell from "./CallTableData/CallTableDateCell";
import CallTableTimeCell from "./CallTableData/CallTableTimeCell";
import CallTablePhoneNumberCell from "./CallTableData/CallTablePhoneNumberCell";
import CallTableDispatcherCell from "./CallTableData/CallTableDispatcherCell";
import CallTableStatusCell from "./CallTableData/CallTableStatusCell";
import CallTableDurationCell from "./CallTableData/CallTableDurationCell";
import Box from "@mui/material/Box";

const columns = [
    {
        id: 'name',
        label: 'Date',
    },
    {
        id: 'time',
        label: 'Time',
    },
    {
        id: 'phoneNumber',
        label: 'Phone Number',
    },
    {
        id: 'dispatcher',
        label: 'Dispatcher',
    },
    {
        id: 'callStatus',
        label: 'Call status',
    },
    {
        id: 'duration',
        label: 'Duration',
    },
]

const createData = (id, localDateTime, clientPhone, dispatcher, callStatus, duration) => {
    let statusColor = '';
    switch (callStatus) {
        case 'ONGOING':
            statusColor = 'info';
            break;
        case 'FAILED':
            statusColor = 'error';
            break;
        case 'SUCCESSFUL':
            statusColor = 'success';
    }
    return {localDateTime, clientPhone, dispatcher, callStatus, duration, statusColor}
}

const rows = [
    createData(1, '2019-01-15T14:22:45.123', '+36123456789', 'James', 'ONGOING', '2min 15sec'),
    createData(2, '2020-03-20T09:45:30.789', '+36234567890', 'Emma', 'SUCCESSFUL', '5min 47sec'),
    createData(3, '2021-05-10T16:55:10.456', '+36345678901', 'Oliver', 'FAILED', '1min 50sec'),
    createData(4, '2019-07-08T08:33:55.222', '+36456789012', 'Ava', 'ONGOING', '3min 10sec'),
    createData(5, '2020-08-25T22:11:40.654', '+36567890123', 'Liam', 'SUCCESSFUL', '6min 25sec'),
    createData(6, '2021-10-03T18:09:18.987', '+36678901234', 'Isabella', 'FAILED', '2min 38sec'),
    createData(7, '2019-02-12T11:44:20.321', '+36789012345', 'Noah', 'ONGOING', '4min 12sec'),
    createData(8, '2020-04-29T07:29:05.888', '+36890123456', 'Sophia', 'SUCCESSFUL', '7min 53sec'),
    createData(9, '2021-06-17T15:07:35.555', '+36901234567', 'Mason', 'FAILED', '1min 15sec'),
    createData(10, '2019-08-01T12:18:50.222', '+36101234567', 'Charlotte', 'ONGOING', '5min 30sec'),
    createData(11, '2020-11-09T13:55:15.999', '+36211234567', 'William', 'SUCCESSFUL', '8min 42sec')
];

function CallTable(props) {
    const [value, setValue] = React.useState('one');
    const [page, setPage] = React.useState(0);

    const [rowsPerPage, setRowsPerPage] = React.useState(10);
    const handleChangePage = (event, newPage) => {
        setPage(newPage);

    };
    const handleChangeRowsPerPage = (event) => {
        setRowsPerPage(+event.target.value);
        setPage(0);
    };

    const handleChange = (event, newValue) => {
        setValue(newValue);
    };

    return (
        <Paper sx={{width: '100%', overflow: 'hidden', borderRadius: 4}}>
            <TableContainer sx={{overflowX: 'hidden'}}>
                <Box m={3}>
                    <Typography variant='h5' fontWeight='bold'>List of calls</Typography>
                    <Typography variant='subtitle2' color='text.secondary'>Based on recent dispatcher activity</Typography>
                </Box>
                <Grid container alignItems='center' marginTop={4}>
                    <Grid item sm={3}>
                        <Tabs
                            value={value}
                            onChange={handleChange}
                            textColor="primary"
                            indicatorColor="primary"
                            aria-label="secondary tabs example"
                        >
                            <Tab disableTouchRipple
                                 value="all"
                                 label="All"
                                 sx={{textTransform: 'none'}}/>
                            <Tab disableTouchRipple
                                 value="in"
                                 label="In"
                                 sx={{textTransform: 'none'}}/>
                            <Tab disableTouchRipple
                                 value="out"
                                 label="Out"
                                 sx={{textTransform: 'none'}}/>
                        </Tabs>
                    </Grid>
                    <Grid item sm={5} alignContent='center'>
                        <TablePagination
                            sx={{display: 'inline-block'}}
                            rowsPerPageOptions={[10, 25, 100]}
                            component="div"
                            count={rows.length}
                            rowsPerPage={rowsPerPage}
                            page={page}
                            onPageChange={handleChangePage}
                            onRowsPerPageChange={handleChangeRowsPerPage}
                        />
                    </Grid>
                    <Grid item sm={4}>
                        <Pagination count={10} />
                    </Grid>
                </Grid>
                <Table>
                    <TableBody>
                        {rows.map(data => (
                            <TableRow>
                                <TableCell align='center'>
                                    <CallTableDateCell date={data.localDateTime}/>
                                </TableCell>
                                <TableCell>
                                    <CallTableTimeCell date={data.localDateTime}/>
                                </TableCell>
                                <TableCell>
                                    <CallTablePhoneNumberCell phoneNumber={data.clientPhone}/>
                                </TableCell>
                                <TableCell>
                                    <CallTableDispatcherCell dispatcher={data.dispatcher}/>
                                </TableCell>
                                <TableCell>
                                    <CallTableStatusCell status={data.callStatus} color={data.statusColor}/>
                                </TableCell>
                                <TableCell>
                                    <CallTableDurationCell duration={data.duration}/>
                                </TableCell>
                            </TableRow>
                        ))}
                    </TableBody>
                </Table>
            </TableContainer>
        </Paper>
    );
}

export default CallTable;