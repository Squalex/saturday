import React, { Component } from 'react';
import './App.css';
import Home from './Home';
import Login from './Login.js';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import GroupList from './GroupList';
import GroupEdit from "./GroupEdit";

class App extends Component {
    render() {
        return (
            <Router>
                <Switch>
                    <Route path='/' exact={true} component={Home}/>
                    <Route path='/groups' exact={true} component={GroupList}/>
                    <Route path='/groups/:id' component={GroupEdit} />
                    <Route path='/login' component={Login} />
                </Switch>
            </Router>
        )
    }
}

export default App;