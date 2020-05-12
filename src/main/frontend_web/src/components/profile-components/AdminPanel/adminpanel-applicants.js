import React from "react";
import axios from "axios";
class AdminpanelApplicants extends React.Component{
    state = {
        applicants: []
    }
    componentDidMount() {
        fetch("http://localhost:8080/applicants")
            .then(response => response.json())
            .then(data => {
                this.setState({applicants: data})
            })
    }
    handleDelete = (event) =>{
        axios.delete("http://localhost:8080/deleteApplicant/"+event.target.value)
        this.forceUpdate()
    }
    render() {
        const listItem = this.state.applicants.map(applicant =>
            <li className="list-group-item">{applicant.id}. {applicant.name} {applicant.surname} <span className="text-info">{applicant.email}</span>
                <span className="float-right"><button className="btn btn-outline-danger" value={applicant.id} onClick={this.handleDelete}> X </button></span>
            </li>)
        return(
            <div>
                <ul className="list-group">
                    {listItem}
                </ul>
            </div>
        )
    }
}
export default AdminpanelApplicants