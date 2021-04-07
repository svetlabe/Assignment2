import React from "react";
import { NavLink } from "react-router-dom";
import "./Menu.css";

function Menu() {
    return (
        <nav>
            {/*<NavLink exact to="/">Home</NavLink>&nbsp;|&nbsp;*/}
            <NavLink to="/viewconfigdata">View Configuration Data</NavLink>&nbsp;|&nbsp;

        </nav>
    )
}
export default Menu;

