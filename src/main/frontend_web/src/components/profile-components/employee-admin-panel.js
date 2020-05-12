import React from "react";
import AdminpanelApplicants from "./AdminPanel/adminpanel-applicants";
import AdminpanelJobs from "./AdminPanel/adminpanel-jobs";
import AdminpanelEmployees from "./AdminPanel/adminpanel-employees";
import AdminpanelInterviews from "./AdminPanel/adminpanel-interviews";
import AdminpanelApplications from "./AdminPanel/adminpanel-applications";
class EmployeeAdminPanel extends React.Component{
    state={
        current : ""
    }
    handleChange = (event) =>{
        const {type,checked,name,value} = event.target
        this.setState({
            [name] : value
        })
        console.log(name,":",value)
    }
    decide = () =>{
        const now = this.state.current
        if(now === "Applicants"){
            return <AdminpanelApplicants/>
        }else if(now === "Applications"){
            return <AdminpanelApplications/>
        }else if(now === "Interviews"){
            return <AdminpanelInterviews/>
        }else if(now === "Employees"){
            return <AdminpanelEmployees/>
        }else if(now === "Jobs"){
            return <AdminpanelJobs/>
        }else{
            return <p></p>
        }
    }
    render() {

        return(
            <div>
                <div className="card border-dark">
                    <div className="card-header border-dark">
                        <ul className="nav nav-tabs card-header-tabs">
                            <form action="">
                                <div className="form-row">
                                    <li className="nav-item"><label htmlFor="one" className="pr-3"><input type="radio" name="current" value="Applicants" id="one" onChange={this.handleChange} checked={this.state.current === "Applicants"}/>Applicants</label></li>
                                    <li className="nav-item"><label htmlFor="two" className="pr-3"><input type="radio" name="current" value="Applications" id="two" onChange={this.handleChange} checked={this.state.current === "Applications"}/>Applications</label></li>
                                    <li className="nav-item"><label htmlFor="three" className="pr-3"><input type="radio" name="current" value="Interviews" id="three" onChange={this.handleChange} checked={this.state.current === "Interviews"}/>Interviews</label></li>
                                    <li className="nav-item"><label htmlFor="four" className="pr-3"><input type="radio" name="current" value="Employees" id="four" onChange={this.handleChange} checked={this.state.current === "Employees"}/>Employees</label></li>
                                    <li className="nav-item"><label htmlFor="five" className="pr-3"><input type="radio" name="current" value="Jobs" id="five" onChange={this.handleChange} checked={this.state.current === "Jobs"}/>Jobs</label></li>
                                </div>
                            </form>
                        </ul>
                    </div>
                    <div className="card-body">
                        {this.decide()}
                    </div>
                </div>
            </div>
        )
    }

}
export default EmployeeAdminPanel