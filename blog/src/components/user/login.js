import React, {Component} from 'react'

import {Input, Col, Spin,  message} from 'antd'
import Button from 'antd/lib/button'
import '../../css/user/login.css'

const InputGroup = Input.Group;


export default class LoginComponent extends Component {
    handleUsernameChange = (value) => {
        let username = value.target.value
        this.setState({
            username: username
        })
    }

    handlePasswordChange = (value) => {
        let password = value.target.value
        this.setState({
            password: password
        })
    }

    constructor(props) {
        super(props)
        this.login = this.login.bind(this)
        this.handleUsernameChange = this.handleUsernameChange.bind(this)
        this.handlePasswordChange = this.handlePasswordChange.bind(this)
        this.state = {
            username: '',
            password: '',
            logining: false
        }
        message.config({
            getContainer: () => document.getElementById('loginInputDiv'),
            maxCount: 1,
            top: 40
        })
    }

    render () {
        // login page
        let logining = this.state.logining
        return (
            <div className="logininputGroup" id='loginInputDiv'>
                <InputGroup size="large">
                    <Col>
                        <Input placeholder={'请输入用户名'} className='loginInput' onChange={this.handleUsernameChange}/>
                    </Col>
                    <br /><br /><br />
                    <Col>
                        <Input placeholder={'请输入密码'} type='password' className='loginInput' onChange={this.handlePasswordChange}/>
                    </Col>
                </InputGroup>
                <br /><br /><br />
                <Button type='primary' className='loginBtn' size='large' onClick={this.login}>登录</Button>
                <Spin className={logining? 'loginSpinCommon': 'loginSpinCommon, loginSpinDismiss'}/>
            </div>
        )
    }

    /**
     * 验证登录本地数据
     */
    login() {
        let username = this.state.username
        let password = this.state.password

        if (username === '') {
            message.warning('请输入用户名')
            return
        }

        if (password === '') {
            message.warning('请输入密码')
            return
        }

        this.requestLogin(username, password)
    }

    /**
     * 登录请求
     */
    async requestLogin(username, password) {
        this.setState({
            logining: true
        })
        console.log('login data: username => ',username, "; password =>", password)

        let headers = new Headers({
            'Content-Type': 'application/x-www-form-urlencoded'
        })

        let request = new Request('http://localhost:8080/user/login', {
            method: 'POST',
            headers: headers,
            body: 'username='+username+'&password='+password
        })
        try {
            let response = await fetch(request)
            let resJson = await response.json()
            console.log('login: ', resJson)

            this.setState({
                logining: false
            })

            if (resJson.code !== -1) {
                message.error(resJson.msg);
            }

        } catch (e) {
            console.log('login error: ', e)
        }
    }
}
