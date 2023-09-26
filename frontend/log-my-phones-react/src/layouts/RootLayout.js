import React from 'react';
import { Link, Outlet } from "react-router-dom";

const RootLayout = () => {
    return (
        <div className="root-layout">
            <header>
                <nav>
                    <Link to="/" className="title"><h1>Log my phone</h1></Link>
                </nav>
            </header>
            <main className="content-container">
                <Outlet />
            </main>
        </div>
    );
}

export default RootLayout