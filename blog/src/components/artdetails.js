import React, {Component} from 'react'
import ArtDetailsHeader from './artdetails/header'
import ArtContent from '../components/artdetails/artcontent'

export default class ArtDetails extends Component {
    render() {
        return (
            <div>
                <ArtDetailsHeader />
                <ArtContent/>
            </div>
        )
    }
}
