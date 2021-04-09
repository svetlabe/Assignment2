import React from "react";
import './PageNotFound.css'
import { Link } from "react-router-dom";

function PageNotFound() {
    return (
	<div className="pagenotfound">
		<h1> 404 PAGE NOT FOUND  </h1>
		<p>Invalid URL: {window.location.pathname}</p>
		<p>Full URL: {window.location.href}</p>
		<p><Link to="/">Home</Link></p>
	</div>
    )
}
export default PageNotFound;
