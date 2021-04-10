import React from "react";
import {RestClient} from "../RestClient";
import './ListEnvironments.css'

export default function ListEnvironments(){
    let [environments, setEnvironments] = React.useState<Array<any>>([])

    React.useEffect(() => {
            RestClient.getEnvironments()
                .then(environments => setEnvironments(environments))},
        [])

    return (
        <>
            <div className="listEnvironments">
                {environments.map((environment:any, i:number) => (
                <div >
                    <h2>{environment.shortName}</h2>
                    <p> Description: {environment.longName}</p>
                </div>
                    ))}
            </div>
        </>
    );
}