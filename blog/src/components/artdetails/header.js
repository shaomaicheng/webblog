import React, {Component} from 'react'
import '../../css/artdetails/header.css'
import {getLocalTime} from '../../util'

class ArtDetailsHeader extends Component {

    constructor(props) {
        super(props)

        this.state = {
            title: 'Android源码分析的Android源码分析',
            author: '烧麦',
            date: 1525016249
        }
    }

    render() {
        return(
            <div className='artdetailsheader'>
                <a className='artdetailshome' href='/'>HOME</a>
                <div className='headerinfo'>
                    <h1>{this.state.title}</h1>
                    <p className='headerinfotext'>作者: {this.state.author}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;日期：{getLocalTime(this.state.date)}</p>
                </div>
            </div>
        )
    }
}


export default ArtDetailsHeader
