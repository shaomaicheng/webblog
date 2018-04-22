import React, { Component } from 'react';
import Header from './components/header'
import ArtList from './components/artlist'

class App extends Component {
    render() {
        return (
            <div>
                <Header/>
                <ArtList/>
            </div>
        );
    }
}

export default App;
