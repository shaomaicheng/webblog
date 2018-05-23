import React, {Component} from 'react'
import '../css/info.css'
import Avatar from '../resource/avatar.png'
import Friends from '../components/fridens'
import '../css/friends.css'

export default class Info extends Component {
    render() {
        return (
            <div className='info'>
                <img src={Avatar} className='avatar' alt='博主的头像'/>
                <p className='username'>程磊</p>
                <p className='usersign'><u>Android工程师，擅长搬砖</u></p>
                <br/>
                <p className='friend_a'>Friends</p>
                <Friends className='userflinks'/>
            </div>
        )
    }
}
