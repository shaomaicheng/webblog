import React, {Component} from 'react'
import '../css/artitem.css'
import date from '../resource/date.svg'
import {withRouter} from "react-router-dom";

class ArtItem extends Component {
    constructor(props) {
        super(props)
        this.state = {
            titleColor: 'gray',
        }
        this.onDivMouseOver = this.onDivMouseOver.bind(this)
        this.onMouseOut = this.onMouseOut.bind(this)
        this.onClickArt = this.onClickArt.bind(this)
    }

    onDivMouseOver() {
        this.setState({
            titleColor: '#FC7097',
        });
    }

    onMouseOut() {
        this.setState({
            titleColor: 'gray',
        })
    }

    onClickArt() {
        this.props.history.push('/art/' + this.props.id)
    }

    render() {
        const style = {
            color: this.state.titleColor
        }
        return (
            <div className='artitemdiv'
                onMouseOver={this.onDivMouseOver}
                onMouseOut={this.onMouseOut}
                onClick={this.onClickArt}>
                {/* 标题 */}
                <p className='artitemtitle'
                    style={style}>{this.props.title}</p>
                {/* 图标 */}
                <img src={date} className='artitemicon' alt='图标飞了'/>
                {/* 日期 */}
                <p className='artitemdate'>{this.props.date}</p>
                <br/>
                {/* 文章开头 */}
                <p className='artitemcontent'>{this.props.content}</p>
            </div>
        )
    }
}
export default withRouter(ArtItem);
