import React, {Component} from 'react'
import ReactMarkdown from 'react-markdown'
import '../../css/artdetails/artcontent.css'

export default class ArtContent extends Component {
    constructor(props) {
        super(props)
        this.state = {
            id: 1,
            contenturl: 'http://localhost:8080/test.md',
            content: ''
        }
        this.fetchContentUrl = this.fetchContentUrl.bind(this)
    }

    fetchContentUrl() {
        fetch(this.state.contenturl, {
            method: 'GET',
        })
            .then(res => {
                return res.text()
            })
            .then(content => {
                // this.setState({
                //     content: content
                // })
            })
            .catch(e => {
                console.log('fetch artcontent url has error ', e)
            })
    }

    render() {

        this.fetchContentUrl()

        return(
            <div>
                <ReactMarkdown
                    source={this.state.content}
                    className='artcontent'
                    skipHtml={true} />
            </div>
        )
    }
}
