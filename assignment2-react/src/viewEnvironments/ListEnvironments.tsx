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
                <fieldset className="environment">
                    <legend>{environment.shortName}</legend>
                    <div> <b>ID:</b> {environment.id}</div>
                    <div> <b> Description:</b> {environment.longName}</div>
                </fieldset>
                    ))}
            </div>

        </>
    );
}