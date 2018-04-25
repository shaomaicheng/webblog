import React, {Component} from 'react'
import '../css/friends.css'

export default class Friends extends Component {
    constructor(props) {
        super(props)
        this.state = {
            data: [
                {
                    id:1,
                    name: '梁飞',
                    link: 'http://liangfei.me/'
                },
                {
                    id:2,
                    name:'省长',
                    link: 'https://geminiwen.com/'
                },
                {
                    id:3,
                    name:'有赞移动技术',
                    link:'https://zhuanlan.zhihu.com/youzanmobile'
                }
            ]
        }
    }
    render() {
        let data = this.state.data
        return (
            <div>
                {
                    data.map(item => {
                        return <a href={item.link}
                            key={'f_link_'+ item.id}
                            target='_blank' className='friend_a'
                            >{item.name}</a>
                    })
                }
            </div>
        )
    }
}
