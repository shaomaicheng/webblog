import React, {Component} from 'react'
import ReactMarkdown from 'react-markdown'
import '../../css/artdetails/artcontent.css'

export default class ArtContent extends Component {
    constructor(props) {
        super(props)
        this.state = {
            content: ''
        }
        this.fetchContentUrl = this.fetchContentUrl.bind(this)
        this.fetchContentUrl()
    }

    fetchContentUrl() {
        const url = 'http://127.0.0.1:8080' + this.props.url
        console.log('文章地址是：' + url)
        fetch(url, {
            method: 'GET',
        })
            .then(res => {
                return res.text()
            })
            .then(content => {
                this.setState({
                    content: content
                })
            })
            .catch(e => {
                console.log('fetch artcontent url has error ', e)
            })
    }

    render() {
        return(
            <div>
                <ReactMarkdown
                    source={this.state.content}
                    className='markdown-body'>
                </ReactMarkdown>
            </div>
        )
    }
}
