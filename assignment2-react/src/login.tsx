import React from "react";
import { NavLink } from "react-router-dom";
import "./Menu.css";

function Login() {
    const handleLogin = () => {

    }

    return (
        <div>
            <h1>Login</h1>
            <p>
                Welcome to login
            </p>
            <p>
                Enter username and password

            </p>

            <form action="/dashboard">
                <input type="submit" value="I am admin" />
            </form>


            <p>
                &copy; Team
            </p>
        </div>
    )
}
export default Login;