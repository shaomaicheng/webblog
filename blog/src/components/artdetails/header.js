import React, {Component} from 'react'
import '../../css/artdetails/header.css'

class ArtDetailsHeader extends Component {

    constructor(props) {
        super(props)
    }

    render() {
        return(
            <div className='artdetailsheader'>
                <a className='artdetailshome' href='/'>HOME</a>
                <div className='headerinfo'>
                    <h1>{this.props.item.title}</h1>
                    <p className='headerinfotext'>作者: {this.props.item.author}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;日期：{this.props.item.date}</p>
                </div>
            </div>
        )
    }
}


export default ArtDetailsHeader
