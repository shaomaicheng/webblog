import React, {Component} from 'react'
import ArtItem from '../components/artitem'
import '../css/artlist.css'
import {getLocalTime} from '../util'

export default class ArtList extends Component {

    constructor(props) {
        super(props)
        this.state = {
            list: [
            ]
        }
        this.getArtList('http://127.0.0.1:8080/artlist', {
            pageNo: 0,
            pageSize: 10
        })
    }

    getArtList(url, params) {
        if (params != null) {
            let paramsArray = []
            Object.keys(params).forEach(key => {
                paramsArray.push(key + '=' + params[key])
            })
            if (url.search(/\?/ == -1)) {
                url += '?' + paramsArray.join('&')
            } else{
                url += '&' + paramsArray.join('&')
            }
        }
        this.requestArtList(url)
    }

    requestArtList(url) {
        let request = new Request(url, {
            method: 'GET',
        })
        fetch(request).then(res=>{
            return res.json()
        }).then(json => {
            return json.data
        }).then(data=>{
            if (data.arts !== undefined) {
                this.setState({
                    list: data.arts
                })
            }
        }).catch(e => {
            console.log('请求文章列表出错，错误：' + e)
        })
    }

    render() {
        const data = this.state.list
        return(
            <div className='artlist'>
                {
                    data.map(item => {
                        return (
                            <ArtItem
                                key={'artitem_' + item.id}
                                id={item.id}
                                title={item.title}
                                date={getLocalTime(item.date)}
                                content={item.content}
                                url={item.url}
                                author={item.author}/>
                        )
                    })
                }
            </div>
        )
    }
}
