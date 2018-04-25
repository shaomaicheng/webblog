import React, { Component } from 'react';
// import { Router, Route} from 'react-router'
// import { BrowserRouter ,Switch} from 'react-router-dom'
import { BrowserRouter} from 'react-router-dom'
import { Route} from 'react-router'
import App from './App'


export default class Navigation extends Component {
    render() {
        return (
            <BrowserRouter>
                <div>
                    <Route exact path='/' component={App}/>
                </div>
            </BrowserRouter>
        )
    }
}
