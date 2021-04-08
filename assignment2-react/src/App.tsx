import React from 'react';
import { Switch, Route } from 'react-router-dom';
import Menu from './Menu';
import Home from './Home'
import About from './About';
import Contact from './Contact';
import PageNotFound from './PageNotFound'


//import Login from './login';
import ViewConfigData from './viewConfigData/ViewConfigData';
//import SecureConfigUpdate from "./SecureConfigUpdate/SecureConfigUpdate";


function App(){
return (
<div>

<Menu/>
<Switch>
        <Route exact path="/" >
          <Home />
        </Route>





<ViewConfigData/>

</Switch>
</div>


);

}
export default App

