import React, { Component } from 'react';
import Header from './components/header'
import ArtItem from './components/artitem'

class App extends Component {
    render() {
        return (
            <div>
                <Header/>
                <ArtItem title='Android 源码分析' date='2018.04.21'
                    content='DaoMaster、具体的Dao 和 DaoSession对象为greedao生成的代码
                    从平时的使用可以看出他们的作用

                    DaoMaster
                    GreenDao的总入口，负责整个库的运行，实现了SqliteOpenHelper
                    DaoSession
                    会话层，操作Dao的具体对象，包括DAO对象的注册'/>
            </div>
        );
    }
}

export default App;
