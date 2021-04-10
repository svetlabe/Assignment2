import React from 'react';
import { Switch, Route } from 'react-router-dom';
import Menu from './Menu';
import Home from './Home'
import About from './About';
import PageNotFound from './PageNotFound'
import ViewConfigData from './viewConfigData/ViewConfigData';
import Environments from "./viewEnvironments/Environments";
import Environment from "./viewEnvironments/Environment";
import Login from "./login";
import EditEnvironments2 from "./viewEnvironments/EditEnvironment2";
import EditEnvironments3 from "./viewEnvironments/EditEnvironments3";



function App(){
return (
<div>
<Menu/>

<Switch>
        <Route exact path="/" >
          <Home />
        </Route>

        <Route path="/environments">
            <Environments />
        </Route>

        <Route path="/addenvironment">
            <EditEnvironments3 />
        </Route>

        <Route path="/environment/:id">
            <Environment/>
        </Route>

        <Route path="/login">
            <Login />
        </Route>

        <Route path="/about">
            <About />
        </Route>

        <Route path="/viewConfigData">
            <ViewConfigData/>
        </Route>

        <Route path="*" >
            <PageNotFound />
        </Route>


</Switch>
</div>


);

}
export default App

