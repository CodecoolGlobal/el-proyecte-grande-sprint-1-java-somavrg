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
import {useNavigate} from "react-router-dom";
import {useState} from "react";
import validator from "validator";

const MINIMUM_COMPANY_NAME_CHARACTERS = 3;
const PASSWORD_VALIDATOR_CONFIGURATION = {
    minLength: 8,
    minUppercase: 1,
    minNumbers: 1,
    minSymbols: 1
}

const style = {
    position: 'absolute',
    top: '50%',
    left: '50%',
    transform: 'translate(-50%, -50%)',
    height: 'auto',
    borderRadius: 4,
    width: '1200px'
};

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

export default function RegisterWindow({onRegister}) {
    const AUTH_REGISTRATION_URL = "api/auth/register";

    const [openPwValidationAlert, setOpenPwValidationAlert] = useState(false);
    const [companyNameError, setCompanyNameError] = useState(false);
    const [emailError, setEmailError] = useState(false);
    const [passwordError, setPasswordError] = useState(false);
    const [passwordMatchError, setPasswordMatchError] = useState(false);
    const [companyNameErrorText, setCompanyNameErrorText] = useState("");
    const [emailErrorText, setEmailErrorText] = useState("");
    const [passwordErrorText, setPasswordErrorText] = useState("");
    const [passwordMatchErrorText, setPasswordMatchErrorText] = useState("");

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

    const isValidCompanyName = (companyName) => {
        return (companyName.length > MINIMUM_COMPANY_NAME_CHARACTERS);
    }

    const isValidEmail = (email) => {
        return validator.isEmail(email);
    }

    const isValidPassword = (password) => {
        return validator.isStrongPassword(password, {
            minLength: PASSWORD_VALIDATOR_CONFIGURATION.minLength,
            minUppercase: PASSWORD_VALIDATOR_CONFIGURATION.minUppercase,
            minNumbers: PASSWORD_VALIDATOR_CONFIGURATION.minNumbers,
            minSymbols: PASSWORD_VALIDATOR_CONFIGURATION.minSymbols
        })
    }

    const isPasswordMatch = (password, confirmPassword) => {
        return password === confirmPassword;
    }

    const handleSubmit = async (event) => {
        event.preventDefault();

        setCompanyNameError(false);
        setEmailError(false);
        setPasswordError(false);
        setPasswordMatchError(false);
        setCompanyNameErrorText("");
        setEmailErrorText("");
        setPasswordErrorText("");
        setPasswordMatchErrorText("");
        let isValidForm = true;

        const data = new FormData(event.currentTarget);
        const name = data.get('companyName');
        const email = data.get('email');
        const password = data.get('password');
        const confirmPassword = data.get('confirmPassword');

        const registrationData = {
            name: name,
            email: email,
            password: password
        };

        if (!isValidCompanyName(registrationData.name)) {
            setCompanyNameError(true);
            setCompanyNameErrorText(`Company name should be at least ${MINIMUM_COMPANY_NAME_CHARACTERS} characters.`);
            isValidForm = false;
        }
        if (!isValidEmail(registrationData.email)) {
            setEmailError(true);
            setEmailErrorText("Not a valid e-mail address.");
            isValidForm = false;
        }
        if (!isValidPassword(registrationData.password)) {
            setPasswordError(true);
            setPasswordMatchError(true);
            setPasswordErrorText("Your password should be at least 8 characters long, contain an uppercase letter, a number and a symbol.");
            isValidForm = false;
        }
        if (!isPasswordMatch(password, confirmPassword)) {
            setPasswordMatchError(true);
            setPasswordMatchErrorText("Passwords do not match. Please try again.");
            isValidForm = false;
        }
        if (isValidForm) {
            const response = await sendRegistrationRequest(AUTH_REGISTRATION_URL, registrationData);
            onRegister();
        }

    };

    return (
        <ThemeProvider theme={defaultTheme}>
            <Grid container component={Paper} elevation={6} sx={style}>
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
                                error={companyNameError}
                                helperText={companyNameErrorText}
                            />
                            <TextField
                                margin="normal"
                                required
                                fullWidth
                                id="email"
                                label="Email Address"
                                name="email"
                                autoComplete="email"
                                error={emailError}
                                helperText={emailErrorText}
                            />
                            <TextField
                                margin="normal"
                                required
                                fullWidth
                                name="password"
                                label="Password"
                                type="password"
                                id="password"
                                error={passwordError}
                                helperText={passwordErrorText}
                            />
                            <TextField
                                margin="normal"
                                required
                                fullWidth
                                name="confirmPassword"
                                label="Confirm Password"
                                type="password"
                                id="confirmPassword"
                                error={passwordMatchError}
                                helperText={passwordMatchErrorText}
                            />
                            <Button
                                type="submit"
                                fullWidth
                                variant="contained"
                                sx={{mt: 3, mb: 2}}
                            >
                                Register
                            </Button>

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
        </ThemeProvider>
    );
}