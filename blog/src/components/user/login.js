import React, {Component} from 'react'

import {Input, Col, Spin,  message} from 'antd'
import Button from 'antd/lib/button'
import '../../css/user/login.css'
import md5 from 'js-md5'
import {isEmpty} from '../../util'

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
        this.gotoSignin = this.gotoSignin.bind(this)

        let routerState = this.props.location.state
        console.log('登录页面路由数据：', routerState)
        this.state = {
            username: routerState === undefined ? '' : routerState.username,
            password: routerState === undefined ? '' : routerState.password,
            logining: false
        }

        document.title = '登录'

        message.config({
            getContainer: () => document.getElementById('loginInputDiv'),
            top: 40,
            maxCount:1
        })
    }

    render () {
        // login page
        let logining = this.state.logining
        return (
            <div className="logininputGroup" id='loginInputDiv'>
                <InputGroup size="large">
                    <Col>
                        <Input placeholder={'请输入用户名'} className='loginInput' onChange={this.handleUsernameChange}
                            value={this.state.username}/>
                    </Col>
                    <br /><br /><br />
                    <Col>
                        <Input placeholder={'请输入密码'} type='password' className='loginInput' onChange={this.handlePasswordChange}
                            value={this.state.password}/>
                    </Col>
                </InputGroup>
                <br /><br />
                <div className="tipLinks">
                    <a className='forgetpsd'>忘记密码</a>
                    <a className='gotoSignin' onClick={this.gotoSignin}>还没账号？去注册</a>
                </div>
                <br/>
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

        password  = md5(password)

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
            } else {
                message.success(resJson.msg)
                let user = resJson.data
                console.log('login success, user is=> ' + user.userId)
            }

        } catch (e) {
            console.log('login error: ', e)
        }
    }

    /**
     * 去注册
     */
    gotoSignin() {
        this.props.history.push({
            pathname: '/signin'
        })
    }
}
