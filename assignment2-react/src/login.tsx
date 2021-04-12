import React from "react";
import { NavLink } from "react-router-dom";
import "./Menu.css";

function Login() {
    const handleLogin = () => {

    }

    return (
        <div>
            <h1>Login</h1>

            <div className="requestLogin">

                            <form action="/dashboard">
                            <p>
                            Welcome to the login for adminstrators
                            </p>
                                <p>

                                    <label htmlFor='username'> Usernname </label><br></br>
                                    <input id='username' type='text' />
                                </p>
                                <p>
                                    <label htmlFor='password'> Password </label><br></br>
                                    <input id='password' type='text' />
                                </p>
                                <button> Submit </button>
                            </form>
                            <p>
                            Please contact us if you don't have access, and a chance to participate in our raffe to win a seat on our first Mars journey.
                            </p>
                        </div>


            <form action="/dashboard">
                <input type="submit" value="Admin login (testing)" />
            </form>
            <div>
            </div>


            <p>

            </p>
        </div>
    )
}
export default Login;