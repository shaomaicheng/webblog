import React, {Component} from 'react'
import '../../css/user/signin.css'
import {Input, Col, Spin,  message} from 'antd'

const InputGroup = Input.Group;

class SignInComponent extends Component {

    constructor(props) {
        super(props)
    }

    render() {
        return (
            <div className='signin'>
                <h1 className='signinTitle'>注册</h1>
                <div className='signinDiv'>
                    <InputGroup size='large'>
                        <Col className='signinCol'>
                            <Input placeholder={'请输入用户名'} />
                            <Input placeholder={'请输入手机号码'} />
                            <Input placeholder={'请输入密码'} />
                            <Input placeholder={'再起输出密码'} />
                        </Col>
                    </InputGroup>
                </div>
            </div>
        )
    }
}


export default SignInComponent
