import React from "react";

class HomeCard extends React.Component{
    state = {
    }
    render() {
        return(
            <div className="card mb-3">
                <img src={this.props.img} style={{"max-height": "200px"}} className="card-img-top" alt=""/>
                <div className="card-body">
                    <h4 className="card-title">{this.props.title}</h4>
                    <p className="card-text">{this.props.text}</p>
                </div>
            </div>
        );
    }
}
export default HomeCard