import React from "react";
import { Link } from "react-router-dom";

import { RestClient } from "../RestClient";


function Environments() {

    let [environments, setEnvironments] = React.useState<Array<any>>([])


    React.useEffect(() => {
        RestClient.getEnvironments()
            .then(environments => setEnvironments(environments))},
    [])

    return (
        <div>
            <h1>Here you can find registered environments </h1>
    {environments.map((e: any, i: number) =>
        <Link key={i} className='blockLink' to={`environment/${e.id}`}>{e.shortName}</Link>
    )}
    </div>
)
}
export default Environments;