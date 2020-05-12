import React from "react";
import EmployeeAdminPanel from "./employee-admin-panel";
import ApplicantProfile from "./applicant-profile";
class EmployeeProfile extends React.Component{

    render() {
        return(
            <div>
                <h3 className="float-left">Welcome <b>{this.props.name+" "+this.props.surname}</b></h3>
                <div>
                    <a href="/logout" className="btn btn-danger float-right">LOGOUT</a>
                </div>
                <br/>
                <br/>
                            <p className="text-left justify-content-center">
                            <b>ID: </b> <i>{this.props.id}</i><br/>
                            <b>E-mail:</b> <i>{this.props.email}</i><br/>
                            <b>Address:</b> <i>{this.props.address}</i><br/>
                            <b>Date of birth:</b> <i>{this.props.dateOfBirth}</i><br/>
                            <b>Job position:</b>  <i>{this.props.position}[{this.props.position_code}]</i><br/>
                            <b>Salary:</b> <i>{this.props.salary}</i><br/>
                            <b>Bank account number:</b> <i>{this.props.bankAccountNumber}</i><br/>
                            <b>Social security number:</b> <i>{this.props.ssn}</i><br/>
                            <b>Contract valid from:</b> <i>{this.props.dateOfContract}</i></p>
                {this.props.position_rank>3?
                    <EmployeeAdminPanel/>:
                    <p></p>
                }
            </div>
        );
        //TODO: ADD ADMINPANEL
    }
}
export default EmployeeProfile