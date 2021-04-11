import React from "react";
import AddEnvironment2 from "./AddEnvironment";
import ListEnvironments from "./ListEnvironments";
import {Link} from "react-router-dom";

export default function EditEnvironments3(){
    return(
        <div>
            <p><Link to={"/dashboard"}> BACK TO DASHBOARD </Link></p>
            <AddEnvironment2/>
            <ListEnvironments/>

        </div>
    )
}