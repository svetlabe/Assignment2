import React from "react";
import './Dashboard.css'
import splash1 from '../config.png';
import {Link} from "react-router-dom";



function Dashboard() {
    return (
        <div className="dashboard">
            <h1> Welcome to Admin Site. Use it carefully!</h1>
            <img src={splash1} className = "dashboarding" />
            <div className="centered"></div>
            <fieldset className="adminMenu">
                <p><Link className='blockLink2' to={`adminenvironments`}> SEE ENVIRONMETS </Link></p>
                <p><Link className='blockLink2' to={`addenvironment`}> ADD ENVIRONMENTS </Link></p>
                <p><Link className='blockLink2' to={`viewConfigData`}> SEE AND EDIT CONFIGURATIONS </Link></p>
            </fieldset>
        </div>
    )
}
export default Dashboard;