import React, {Component} from 'react'
import ArtDetailsHeader from '../artdetails/header'
import ArtContent from '../artdetails/artcontent'

export default class ArtDetails extends Component {

    constructor(props) {
        super(props)
    }

    render() {
        return (
            <div>
                <ArtDetailsHeader item={this.props.location.state}/>
                <ArtContent url={this.props.location.state.url}/>
            </div>
        )
    }
}
