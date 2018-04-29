import React, {Component} from 'react'
import ArtItem from '../components/artitem'
import '../css/artlist.css'

export default class ArtList extends Component {

    constructor(props) {
        super(props)
        this.state = {
            list: [
                {
                    id: 1,
                    title: 'Android源码分析',
                    date: '2018.04.21',
                    content: 'DaoMaster、具体的Dao 和 DaoSession对象为greedao生成的代码'+
                    '从平时的使用可以看出他们的作用'+
                    'DaoMaster' +
                    'GreenDao的总入口，负责整个库的运行，实现了SqliteOpenHelper'+
                    'DaoSession'+
                    '会话层，操作Dao的具体对象，包括DAO对象的注册'
                },
                {
                    id: 2,
                    title:'Android源码分析',
                    date: '2018.04.19',
                    content: 'DaoMaster、具体的Dao 和 DaoSession对象为greedao生成的代码'+
                    '从平时的使用可以看出他们的作用'+
                    'DaoMaster' +
                    'GreenDao的总入口，负责整个库的运行，实现了SqliteOpenHelper'+
                    'DaoSession'+
                    '会话层，操作Dao的具体对象，包括DAO对象的注册'
                }
            ]
        }
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
                                date={item.date}
                                content={item.content}/>
                        )
                    })
                }
            </div>
        )
    }
}
