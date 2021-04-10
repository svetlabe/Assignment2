import  React, { useState, useEffect } from "react";
import { NavLink } from "react-router-dom";

import "./Menu.css";

export default function Login() {

const [postId, setPostId] = useState(null);

 let [userData, setUserData] = React.useState<Array<any>>([])


    return (
        <div className="login">


            <div className="requestLogin">
                            <h2> Login for approved administrators </h2>
                            <form onSubmit={RequestLogin}>
                                <p>
                                    <label htmlFor='username'> Username </label>
                                    <input id='username' type='text' />
                                </p>
                                <p>
                                    <label htmlFor='password'> Password </label>
                                    <input id='password' type='text' />
                                </p>
                                <button> Submit </button> <p>
                                </p>
                                Please read our guideline befor apply for administrator role. You will find these <a href='http://www.mars-one.com/faq/selection-and-preparation-of-the-astronauts/what-are-the-qualifications-to-apply'> here </a>
                            </form>
                        </div>
            <div className="requestLogin">
                            <h2> Login for approved administrators </h2>
                            <form onSubmit={RequestLoginTest}>
                                <p>
                                    <label htmlFor='username'> Username </label>
                                    <input id='username' type='text' />
                                </p>
                                <p>
                                    <label htmlFor='password'> Password </label>
                                    <input id='password' type='text' />
                                </p>
                                <button> Submit </button> <p>
                                </p>
                                Please read our guideline befor apply for administrator role. You will find these <a href='http://www.mars-one.com/faq/selection-and-preparation-of-the-astronauts/what-are-the-qualifications-to-apply'> here </a>
                            </form>
                        </div>



                                    <div className="card text-center m-3">
                                        <h5 className="card-header">Simple POST Request</h5>
                                        <div className="card-body">
                                            Hei
                                        </div>
                                    </div>


        </div>
    )


//Returnerer ett brukernavn og token tilbake.Login (Username.token)
//Returnerer til Home ()
//Lagre i sesjonscookie
    function RequestLogin() {

                    let RequestLogin = {
                        username: (document.getElementById('username') as HTMLInputElement).value,
                        password: (document.getElementById('password') as HTMLInputElement).value,
                    }

                   let state = {
                         token: null
                         }

                    fetch("http://localhost:8111/admin/login",
                        {
                            method: 'POST',
                            headers: {'Content-Type': 'application/json'},
                            body: JSON.stringify(RequestLogin)
                        }
                        )
                            //.then(response => response.json())
                            //.then(data => state.token({token: data.token}));
    }

    function RequestLoginTest() {

                        let RequestLogin = {
                            username: (document.getElementById('username') as HTMLInputElement).value,
                            password: (document.getElementById('password') as HTMLInputElement).value,
                        }


                        const requestOptions = {
                            method: 'POST',
                            headers: {'Content-Type': 'application/json'},
                            body: JSON.stringify(RequestLogin)
                        }
                        fetch("http://localhost:8111/admin/login",
                            {
                                method: 'POST',
                                headers: {'Content-Type': 'application/json'},
                                body: JSON.stringify(RequestLogin)
                            }
                        )
        }


}
