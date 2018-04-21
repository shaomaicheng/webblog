import React, {Component} from 'react'
import '../css/log.css'

export default class Log extends Component {
    render() {
        return (
            <div className='log'>
                <a className='logname' href='https://www.baidu.com'>烧麦</a>
                <a className='authorname' href='https://www.baidu.com'>'s Blog</a>
            </div>
        )
    }
}
