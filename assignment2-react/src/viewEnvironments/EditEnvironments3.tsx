import React from "react";
import AddEnvironment2 from "./AddEnvironment";
import ListEnvironments from "./ListEnvironments";
import {Link} from "react-router-dom";

export default function EditEnvironments3(){
    return(
        <div>
            <form action="/dashboard">
                <input type="submit" value="BACK TO DASHBOARD" />
            </form>
            <AddEnvironment2/>
            <ListEnvironments/>

        </div>
    )
}