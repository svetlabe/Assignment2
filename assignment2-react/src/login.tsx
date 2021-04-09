import React from "react";
import { NavLink } from "react-router-dom";Be om kontroll

                                           Be om kontroll









                                           Forlat








                                           Forlat

import "./Menu.css";

export default function Login() {

 let [userData, setUserData] = React.useState<Array<any>>([])

    return (
        <div className="login">
            <h1>Login</h1>

            <div className="requestLogin">
                            <h2> Login </h2>
                            <form onSubmit={RequestLogin}>
                                <p>
                                    <label htmlFor='username'> Usernname </label>
                                    <input id='username' type='text' />
                                </p>
                                <p>
                                    <label htmlFor='password'> Password </label>
                                    <input id='password' type='text' />
                                </p>
                                <button> Submit </button>
                            </form>
                        </div>
        </div>
    )


    function RequestLogin() {

                    let RequestLogin= {
                        username: (document.getElementById('Username') as HTMLInputElement).value,
                        password: (document.getElementById('Password') as HTMLInputElement).value,
                        token: (document.getElementById('token') as HTMLInputElement).value,
                    }

                    fetch("http://localhost:8111/admin/login",
                        {
                            method: 'POST',
                            headers: {'Content-Type': 'application/json'},
                            body: JSON.stringify(RequestLogin)
                        })

                }
}
