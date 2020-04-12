import React from "react";
class JobCard extends React.Component{
    render() {
        return(
            <div className="card mb-3 text-center">
                <div className="card-header">
                    <h2>{this.props.info.title}</h2>
                </div>
                <div className="card-body">
                    <p>{this.props.info.text}</p>
                </div>
            </div>
        );
    }
}
export default JobCard