import React, {Component} from 'react'
import '../css/header.css'
import Log from '../components/log'

class Header extends Component {
    render() {
        return (
            <div className="header">
                <Log />
            </div>
        )
    }
}

export default Header
