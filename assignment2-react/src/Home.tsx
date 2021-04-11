import React from "react";
import './Home.css'
import splash from './baseball-home-plate.png';   // Tell Webpack this code file uses this image



function Home() {
    return (
        <div className="container">
            <img src={splash} className="home"/>
            <div className="centered">Repository</div>
        </div>
    )
}
export default Home;