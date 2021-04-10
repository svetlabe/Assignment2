import React from 'react';
import { Switch, Route } from 'react-router-dom';
import Menu from './Menu';
import Home from './Home'
import About from './About';
import PageNotFound from './pageNotFound/PageNotFound'
import ViewConfigData from './viewConfigData/ViewConfigData';
import Environments from "./viewEnvironments/Environments";
import Environment from "./viewEnvironments/Environment";
import Login from "./login";
import EditEnvironments3 from "./viewEnvironments/EditEnvironments3";
import Dashboard from "./Dashboard/Dashboard";
import AdminEnvironments from "./viewEnvironments/AdminEnvironments";
import AdminEnvironment from "./viewEnvironments/AdminEnvironment";



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

        <Route path="/adminenvironments">
            <AdminEnvironments />
        </Route>
        <Route path="/adminenvironment/:id">
            <AdminEnvironment/>
        </Route>

        <Route path="/login">
            <Login />
        </Route>
        <Route path="/dashboard">
            <Dashboard />
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

