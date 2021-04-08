import React from "react";
import { NavLink } from "react-router-dom";
import "./Menu.css";

function Menu() {
    return (
        <nav>
            {/*<NavLink exact to="/">Home</NavLink>&nbsp;|&nbsp;*/}
            <NavLink exact to="/">Home </NavLink>&nbsp;|&nbsp;
            <NavLink exact to="./viewConfigData/ViewConfigData">View Configuration Data</NavLink>&nbsp;|&nbsp;
            <NavLink exact to="./SecureConfigUpdate/secureconfigupdate">Edit Configuration Data</NavLink>&nbsp;|&nbsp;
            <NavLink exact to="./login"> Login (for administrators)</NavLink>&nbsp;|&nbsp;

        </nav>
    )
}
export default Menu;

