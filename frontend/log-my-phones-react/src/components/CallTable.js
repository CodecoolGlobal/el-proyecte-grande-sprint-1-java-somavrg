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

const getStatusColor = (callStatus) => {
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
    return statusColor;
}

function CallTable({calls, onPageChange, onPageSizeChange, onCallDirectionChange}) {
    const [value, setValue] = React.useState('');
    const [page, setPage] = React.useState(0);

    const [rowsPerPage, setRowsPerPage] = React.useState(10);
    const handleChangePage = (event, newPage) => {
        setPage(newPage);
        onPageChange(newPage);
    };
    const handleChangeRowsPerPage = (event) => {
        setRowsPerPage(event.target.value);
        onPageSizeChange(event.target.value);
        setPage(0);
    };

    const handleChange = (event, newValue) => {
        setValue(newValue);
        onCallDirectionChange(newValue)
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
                                 value=""
                                 label="All"
                                 sx={{textTransform: 'none'}}/>
                            <Tab disableTouchRipple
                                 value="INCOMING"
                                 label="In"
                                 sx={{textTransform: 'none'}}/>
                            <Tab disableTouchRipple
                                 value="OUTGOING"
                                 label="Out"
                                 sx={{textTransform: 'none'}}/>
                        </Tabs>
                    </Grid>
                    <Grid item sm={5} alignContent='center'>
                        <TablePagination
                            sx={{display: 'inline-block'}}
                            rowsPerPageOptions={[10, 25, 100]}
                            component="div"
                            count={calls?.totalElements}
                            rowsPerPage={rowsPerPage}
                            page={page}
                            onPageChange={handleChangePage}
                            onRowsPerPageChange={handleChangeRowsPerPage}
                        />
                    </Grid>
                    <Grid item sm={4}>
                        <Pagination count={calls?.totalPages} page={page + 1}
                                    onChange={(event, page) => {handleChangePage(event, (page - 1))}}/>
                    </Grid>
                </Grid>
                <Table>
                    <TableBody>
                        {calls?.content.map(call => (
                            <TableRow>
                                <TableCell align='center'>
                                    <CallTableDateCell date={call.startTime}/>
                                </TableCell>
                                <TableCell>
                                    <CallTableTimeCell date={call.startTime}/>
                                </TableCell>
                                <TableCell>
                                    <CallTablePhoneNumberCell phoneNumber={call.clientPhone.phoneNumber}/>
                                </TableCell>
                                <TableCell>
                                    <CallTableDispatcherCell dispatcher={call.dispatcher.name}/>
                                </TableCell>
                                <TableCell>
                                    <CallTableStatusCell status={call.callStatus} color={getStatusColor(call.callStatus)}/>
                                </TableCell>
                                <TableCell>
                                    <CallTableDurationCell duration={call.duration}/>
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