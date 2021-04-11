import React from "react";
import { Link } from "react-router-dom";

import { RestClient } from "../RestClient";



function AdminEnvironments() {

    let [environments, setEnvironments] = React.useState<Array<any>>([])


    React.useEffect(() => {
        RestClient.getEnvironments()
            .then(environments => setEnvironments(environments))},
    [])

    return (
        <div>
            <form action="/dashboard">
                <input type="submit" value="BACK TO DASHBOARD" />
            </form>
            <h1 className= "headder">Here you can find registered environments </h1>
    {environments.map((e: any, i: number) =>
        <Link key={i} className='blockLink' to={`adminenvironment/${e.id}`}>{e.shortName} </Link>
    )}
    </div>
)
}
export default AdminEnvironments;