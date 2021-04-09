import React from "react";
import { NavLink } from "react-router-dom";
import "./Menu.css";

export default function Login() {
    return (
        <div>
            <h1>Login</h1>
            <p>
                Welcome to login
            </p>
            <p>
                Enter username and password
            </p>

            <p>
                &copy; Team
            </p>
        </div>
    )


    function RequestLogin() {

            let RequestLogin= {
                username: (document.getElementById('Username') as HTMLInputElement).value,
                password: (document.getElementById('Password') as HTMLInputElement).value,
            }

            fetch("http://localhost:8111/admin/login",
                {
                    method: 'POST',
                    headers: {'Content-Type': 'application/json', 'Authorisation': 'token'},
                    body: JSON.stringify(RequestLogin)
                })

        }




}
