import React, { Component } from 'react';
import Header from './components/header'
import ArtList from './components/artlist'
import Info from './components/info'

class App extends Component {
    render() {
        return (
            <div>
                <Header/>
                <ArtList/><Info/>
            </div>
        );
    }
}

export default App;
