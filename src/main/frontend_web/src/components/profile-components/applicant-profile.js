import React from "react";
class ApplicantProfile extends React.Component{

    render() {
        return(
            <div>
                <div className="card mb-3">
                    <div className="card-header">
                        <h3>Welcome {this.props.name+" "+this.props.surname}</h3>
                    </div>
                    <div className="card-body">
                        <ul className="list-group">
                            <li className="list-group-item"><h6>E-mail:</h6> <i>{this.props.email}</i></li>
                        </ul>
                    </div>
                </div>
            </div>
        );
    }
}
export default ApplicantProfile