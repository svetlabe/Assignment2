import React from "react";
import './Home.css'
import splash from './baseball-home-plate.png';   // Tell Webpack this code file uses this image



function Home() {
    return (
        <div className="container">
            <img src={splash} alt="DNBs Mars database of artifacs"/>
            <div className="centered">Welcome to DNBs Mars Mission computer repository</div>
        </div>
    )
}
export default Home;