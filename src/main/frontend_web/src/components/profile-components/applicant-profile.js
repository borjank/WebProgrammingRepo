import React from "react";
import ApplicantApplications from "./applicant-applicaitons";
class ApplicantProfile extends React.Component{
    render() {
        return(
            <div>
                <h3 className="float-left">Welcome <b>{this.props.name+" "+this.props.surname}</b></h3>
                <div>
                    <a href="/logout" className="btn btn-danger float-right">LOGOUT</a>
                </div><br/><br/>
                <p>
                    <b>ID: </b> <i>{this.props.id}</i><br/>
                    <b>E-mail:</b> <i>{this.props.email}</i>
                </p>
                <br/>
                <hr/>
                <br/>

                <ApplicantApplications data=""/>
            </div>
        );
        //TODO: ADD APPLICATIONS LIST
    }
}
export default ApplicantProfile