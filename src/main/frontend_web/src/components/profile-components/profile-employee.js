import React from "react";
import EmployeeAdminPanel from "./employee-admin-panel";
import ApplicantProfile from "./applicant-profile";
class ProfileEmployee extends React.Component{

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
                            <li className="list-group-item"><h6>Address:</h6> <i>{this.props.address}</i></li>
                            <li className="list-group-item"><h6>Date of birth:</h6> <i>{this.props.dateOfBirth}</i></li>
                            <li className="list-group-item"><h6>Job position: </h6> <i>{this.props.position}[{this.props.position_code}]</i></li>
                            <li className="list-group-item"><h6>Salary:</h6> <i>{this.props.salary}</i></li>
                            <li className="list-group-item"><h6>Bank account number:</h6> <i>{this.props.bankAccountNumber}</i></li>
                            <li className="list-group-item"><h6>Social security number:</h6> <i>{this.props.ssn}</i></li>
                            <li className="list-group-item"><h6>Contract valid from:</h6> <i>{this.props.dateOfContract}</i></li>
                        </ul>
                    </div>
                </div>
                {this.props.position_rank>3?
                    <EmployeeAdminPanel/>:
                    <p></p>
                }
            </div>
        );
    }
}
export default ProfileEmployee