import React, { Component } from 'react';
import { BrowserRouter} from 'react-router-dom'
import { Route} from 'react-router'
import App from './App'
import ArtDetails from './components/artdetails/artdetails'
import LoginComponent from './components/user/login'
import SignInComponent from './components/user/signin'

export default class Navigation extends Component {
    render() {
        return (
            <BrowserRouter>
                <div>
                    <Route exact path='/' component={App}/>
                    <Route path='/art/:id' component={ArtDetails}/>
                    <Route path='/login' component={LoginComponent}/>
                    <Route path='/signin' component={SignInComponent}/>
                </div>
            </BrowserRouter>
        )
    }
}
