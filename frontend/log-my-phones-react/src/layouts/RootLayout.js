import React from 'react';
import { Link, NavLink, Outlet } from "react-router-dom";

const RootLayout = () => {
    return (
        <div className="root-layout">
            <header>
                <nav>
                    <Link to="/" className="title"><h1>Log my phone</h1></Link>
                    <NavLink to="/dashboard">Dashboard</NavLink>
                    <NavLink to="/contacts">Contacts</NavLink>
                    <NavLink to="/statics">Statics</NavLink>
                    <NavLink to="/addphone">Add Phone</NavLink>
                </nav>
            </header>
            <main className="content-container">
                <Outlet />
            </main>
        </div>
    );
}

export default RootLayout