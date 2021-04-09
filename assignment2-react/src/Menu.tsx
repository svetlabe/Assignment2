import React from "react";
import { NavLink } from "react-router-dom";
import "./Menu.css";

function Menu() {
    return (
        <nav>
            {/*<NavLink exact to="/">Home</NavLink>&nbsp;|&nbsp;*/}
            <NavLink exact to="/">Home </NavLink>&nbsp;|&nbsp;
            <NavLink to="./viewConfigData">View Configuration Data</NavLink>&nbsp;|&nbsp;
            <NavLink to="./SecureConfigUpdate">Edit Configuration Data</NavLink>&nbsp;|&nbsp;
            <NavLink to ="/environments">Environments</NavLink>&nbsp;|&nbsp;
            <NavLink to="./login"> Login (for administrators)</NavLink>&nbsp;|&nbsp;
            <NavLink to="./about"> About </NavLink>&nbsp;|&nbsp;


        </nav>
    )
}
export default Menu;

