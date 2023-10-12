import * as React from 'react';
import Avatar from '@mui/material/Avatar';
import Button from '@mui/material/Button';
import CssBaseline from '@mui/material/CssBaseline';
import TextField from '@mui/material/TextField';
import Link from '@mui/material/Link';
import Paper from '@mui/material/Paper';
import Box from '@mui/material/Box';
import Grid from '@mui/material/Grid';
import PersonAddIcon from '@mui/icons-material/PersonAdd';
import Typography from '@mui/material/Typography';
import {createTheme, ThemeProvider} from '@mui/material/styles';
import {Alert, Snackbar} from "@mui/material";
import {grey} from "@mui/material/colors";

function Copyright(props) {
    return (
        <Typography variant="body2" color="text.secondary" align="center" {...props}>
            {'Copyright © '}
            <Link color="inherit" href="https://mui.com/">
                logmyphones.com
            </Link>{' '}
            {new Date().getFullYear()}
            {'.'}
        </Typography>
    );
}

const defaultTheme = createTheme();

export default function RegisterWindow() {
    const AUTH_REGISTRATION_URL = "api/auth/register";

    const [openPwValidationAlert, setOpenPwValidationAlert] = React.useState(false);
    const [openRegistrationSuccess, setOpenRegistrationSuccess] = React.useState(false);

    const sendRegistrationRequest = async (url, registrationFormData) => {
        try {
            return await fetch(url, {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(registrationFormData)
            });
        } catch (error) {
            console.error(error)
        }
    }

    const isPasswordValid = (password, confirmPassword) => {
        return password === confirmPassword;
    }

    const handleSubmit = async (event) => {
        event.preventDefault();
        const data = new FormData(event.currentTarget);

        const name = data.get('companyName');
        const email = data.get('email');
        const password = data.get('password');
        const confirmPassword = data.get('confirmPassword');

        const registrationData = {
            name: name,
            email: email,
            password: password
        }

        if (isPasswordValid(password, confirmPassword)) {
            const response = await sendRegistrationRequest(AUTH_REGISTRATION_URL, registrationData);
            setOpenRegistrationSuccess(true);

        } else {
            setOpenPwValidationAlert(true);
        }
    };

    const handleClosePwAlert = (event, reason) => {
        if (reason === 'clickaway') {
            return;
        }

        setOpenPwValidationAlert(false);
    };

    const handleCloseRegistrationSuccess = (event, reason) => {
        if (reason === 'clickaway') {
            return;
        }

        setOpenRegistrationSuccess(false);
    };


    return (
        <ThemeProvider theme={defaultTheme}>
            <Box sx={{
                display: 'flex',
                justifyContent: 'center',
                alignItems: 'center',
                position: 'absolute',
                width: '100vw',
                height: '100vh',
                overflow: 'hidden',
                backgroundColor: 'rgba(0, 0, 0, 0.7)',
                zIndex: 10
            }}>
                <Grid container component={Paper} elevation={6} sx={{height: 'auto', borderRadius: 4, width: '1200px'}}>
                    <CssBaseline/>
                    <Grid
                        item
                        xs={false}
                        sm={5}
                        md={6}
                        sx={{
                            backgroundImage: "url('/register.jpg')",
                            backgroundRepeat: 'no-repeat',
                            backgroundColor: (t) =>
                                t.palette.mode === 'light' ? t.palette.grey[50] : t.palette.grey[900],
                            backgroundSize: 'cover',
                            backgroundPosition: 'center',
                            borderRadius: 4,
                            height: 'auto'
                        }}
                    />
                    <Grid item xs={12} sm={7} md={6}>
                        <Box
                            sx={{
                                my: 8,
                                mx: 4,
                                display: 'flex',
                                flexDirection: 'column',
                                alignItems: 'center',
                                padding: '30px'
                            }}
                        >
                            <Avatar sx={{m: 1, bgcolor: 'secondary.main'}}>
                                <PersonAddIcon/>
                            </Avatar>
                            <Typography component="h1" variant="h5">
                                Register
                            </Typography>
                            <Box component="form" noValidate onSubmit={handleSubmit} sx={{mt: 1}}>
                                <Typography align="center" variant="subtitle1" sx={{color: grey[600]}}>
                                    Please fill form to register.
                                </Typography>
                                <TextField
                                    margin="normal"
                                    required
                                    fullWidth
                                    id="companyName"
                                    label="Company Name"
                                    name="companyName"
                                    autoFocus
                                />
                                <TextField
                                    margin="normal"
                                    required
                                    fullWidth
                                    id="email"
                                    label="Email Address"
                                    name="email"
                                    autoComplete="email"
                                />
                                <TextField
                                    margin="normal"
                                    required
                                    fullWidth
                                    name="password"
                                    label="Password"
                                    type="password"
                                    id="password"
                                />
                                <TextField
                                    margin="normal"
                                    required
                                    fullWidth
                                    name="confirmPassword"
                                    label="Confirm Password"
                                    type="password"
                                    id="confirmPassword"
                                />
                                <Button
                                    type="submit"
                                    fullWidth
                                    variant="contained"
                                    sx={{mt: 3, mb: 2}}
                                >
                                    Register
                                </Button>
                                <Snackbar open={openPwValidationAlert} autoHideDuration={6000}
                                          onClose={handleClosePwAlert}>
                                    <Alert onClose={handleClosePwAlert} severity="error" sx={{width: '100%'}}>
                                        Passwords don't match. Please try again!
                                    </Alert>
                                </Snackbar>
                                <Snackbar open={openRegistrationSuccess} autoHideDuration={6000}
                                          onClose={handleCloseRegistrationSuccess}>
                                    <Alert onClose={handleCloseRegistrationSuccess} severity="success"
                                           sx={{width: '100%'}}>
                                        Registration successful!
                                    </Alert>
                                </Snackbar>
                                <Grid container>
                                    <Grid item>
                                        <Link href="#" variant="body2">
                                            {"Already have an account? Sign In"}
                                        </Link>
                                    </Grid>
                                </Grid>
                                <Copyright sx={{mt: 5}}/>
                            </Box>
                        </Box>
                    </Grid>
                </Grid>
            </Box>
        </ThemeProvider>
    );
}