import React, {Component} from 'react'
import '../../css/user/signin.css'
import {Col, Input, message, Spin} from 'antd'
import Button from "antd/lib/button";
import md5 from 'js-md5'

const InputGroup = Input.Group;
const props = {
    action: '/upload.do',
    multiple: true,
    onStart(file) {
        console.log('onStart', file, file.name);
    },
    onSuccess(ret) {
        console.log('onSuccess', ret);
    },
    onError(err) {
        console.log('onError', err);
    },
    beforeUpload(file, fileList) {
        console.log(file, fileList);
    },
};

class SignInComponent extends Component {


    constructor(props) {
        super(props)
        this.handleNumberInput = this.handleNumberInput.bind(this)
        this.handleConfirmPsd = this.handleConfirmPsd.bind(this)
        this.handleRalPsd = this.handleRalPsd.bind(this)
        this.signIn = this.signIn.bind(this)
        this.handleName = this.handleName.bind(this)
        this.handleCompany = this.handleCompany.bind(this)
        this.handleTitle = this.handleTitle.bind(this)
        this.handleEmail = this.handleEmail.bind(this)
        this.handleIntroduction = this.handleIntroduction.bind(this)

        this.state = {
            userexit: false,
            userexitshow:false,
            psdSame:true,
            realPsd: '',
            psdConfirm: '',
            number: '',
            email: '',
            level: 1,
            name: '',
            company: '',
            title: '',
            avatar: '',
            introduction: '',
            signIning: false
        }

        document.title = '注册'

        message.config({
            maxCount: 1,
            getContainer: () =>{
                return document.getElementById('inputPsdAgainId')
            }
        })

    }

    render() {

        let numberTipStyle = {
            display: this.state.userexit && this.state.userexitshow ? 'inline' : 'none'
        }

        let psdTipStyle = {
            display: this.state.psdSame? 'none' : 'inline'
        }

        let mustInputTip = {
            color: 'red',
        }

        let signinStyle = {
            display: this.state.signIning? 'inline': 'none'
        }

        return (
            <div className='signin'>
                <h1 className='signinTitle'>注册</h1>
                <div className='signinDiv'>
                    <InputGroup size='large'>
                        <Col className='signinCol'>
                            <Input placeholder={'请输入用户名'}  onChange={this.handleName}/><text style={mustInputTip}>*必填</text>
                            <Input placeholder={'请输入手机号码'} maxLength={11} onChange={this.handleNumberInput}/>
                            <text style={mustInputTip}>*必填</text>
                            <text style={numberTipStyle}>改手机号码已被注册</text>
                            <Input placeholder={'请输入密码'} type='password' maxLength={16} onChange={this.handleRalPsd}/>
                            <text style={mustInputTip}>*必填</text>
                            <Input placeholder={'再次输出密码'} type='password' maxLength={16} onChange={this.handleConfirmPsd} />
                            <text style={mustInputTip}>*必填</text>
                            <text style={psdTipStyle}>两次密码不一致</text>
                            <Input placeholder={'请输入你的邮箱'} onChange={this.handleEmail}/>
                            <Input placeholder={'请输入你所在的组织'} onChange={this.handleCompany}/>
                            <Input placeholder={'请输入你的职业Title'} onChange={this.handleTitle}/>
                            <Input placeholder={'一句话介绍下自己'} onChange={this.handleIntroduction}/>
                            {/*<div className='signinUpladDiv'>*/}
                                {/*<Upload {...props} className='signinUpload'>*/}
                                    {/*<Button>*/}
                                        {/*<Icon type="upload" /> 点击上传头像*/}
                                    {/*</Button>*/}
                                {/*</Upload>*/}
                            {/*</div>*/}
                            <Button type='primary' className='signinBtn' size='large' onClick={this.signIn} id='inputPsdAgainId'>注册</Button>
                        </Col>
                    </InputGroup>
                    <Spin className='spinSignIn' style={signinStyle}/>
                </div>
            </div>
        )
    }

    handleNumberInput = (value) => {
        this.judgeUserIsExit(value)
    }

    async judgeUserIsExit(value) {
        let number = value.target.value
        this.setState({
            number: number
        })
        if (number.length === 11) {
            // 输满手机号
            console.log('请求验证用户是否存在')
            let request = new Request('http://localhost:8080/user/query/isexit/'+number, {
                method: 'GET'
            })
            try {
                let response = await fetch(request)
                let data = (await response.json()).data
                console.log('根据手机号验证用户是否存在：', data)
                if (data) {
                    this.setState({
                        userexit: true,
                        userexitshow: true
                    })
                }
            } catch (e) {
                console.log(e)
            }
        } else {
            this.setState({
                userexitshow: false,
                userexit: false
            })
        }
    }

    handleName = (value) => {

        this.setState({
            name: value.target.value
        })

    }

    handleEmail = (value) => {
        this.setState({
            email: value.target.value
        })
    }

    handleCompany = (value) => {
        this.setState({
            company: value.target.value
        })
    }

    handleTitle = (value) => {
        this.setState({
            title: value.target.value
        })
    }

    handleIntroduction = (value) => {
        this.setState({
            introduction: value.target.value
        })
    }

    handleConfirmPsd = (value) => {
        let psdConfirm = value.target.value
        this.setState({
            psdConfirm: psdConfirm
        })
        this.judePsdSame(this.state.realPsd, psdConfirm)
    }

    handleRalPsd = (value) => {
        let realPsd = value.target.value
        this.setState({
            realPsd: realPsd
        })
        this.judePsdSame(realPsd, this.state.psdConfirm)
    }

    /**
     *  判断密码是否一致
     */
    judePsdSame(realPsd, confirmPsd) {
        if (realPsd === '' || confirmPsd === '') {
            this.setState({
                psdSame: true
            })
            return
        }

        // 密码是否一致
        this.setState({
            psdSame: realPsd === confirmPsd
        })
    }

    /**
     * 注册
     */
    signIn = () => {
        this.requestSignIn()
    }


    async requestSignIn() {
        let number = this.state.number
        let name = this.state.name
        let password = this.state.realPsd
        let email = this.state.email
        let level = this.state.level
        let company = this.state.company
        let title = this.state.title
        let introduction = this.state.introduction
        let avatar = this.state.avatar

        if (number === '' || name === '' || password === '')  {
            message.warning('请填写必须填写的内容')
            return
        }

        this.setState({
            signIning: true
        })

        // 密码加密
        let inputPsd = password
        password = md5(password)


        console.log('密码', password)

        let request = new Request('http://localhost:8080/user//insert', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            },
            body: 'number='+number+'&email='+email+'&level='+level+'&name='+name+'&password='+password+'&company='+company+
                '&title='+title+'&avatar='+avatar+'&introduction='+introduction
        })

        try {
            let response = await fetch(request)
            this.setState({
                signIning: false
            })
            let json = await response.json()
            console.log('注册数据:', json)
            if (json.code === -1) {
                message.success('注册成功！')

                let data = {
                    username: name,
                    password: inputPsd
                }
                this.props.history.push({
                    pathname: '/login',
                    state: data
                })

            } else {
                message.success('注册失败！请重试')
            }
        } catch (e) {
            console.error('注册请求错误')
            message.success('注册失败！请重试')
            this.setState({
                signIning: false
            })
        }
    }
}



export default SignInComponent
