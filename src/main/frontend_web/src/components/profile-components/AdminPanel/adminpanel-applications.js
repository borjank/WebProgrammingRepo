import React from "react";
import axios from "axios";
class AdminpanelApplications extends React.Component{
    state = {
        applications: [],
        rating:-1
    }
    componentDidMount() {
        fetch("http://localhost:8080/applications")
            .then(response => response.json())
            .then(data => {
                this.setState({applications: data})
            })


    }

    handleChange = (event) =>{
        const {type,checked,name,value} = event.target
        this.setState({
            [name] : value
        })
        console.log(name,":",value)
    }
    handleReview = (event) =>{
        axios.get("http://localhost:8080/reviewApplication/"+event.target.value+"/"+this.state.rating)
            .then(r => console.log(r.data))
        this.forceUpdate();
    }
    render() {
        const applications = this.state.applications.map(app =>
        app.reviewed === true?
            <li className="list-group-item bg-primary text-white">{app.id}. applied for {app.job.name}[<i>{app.job.code}</i>] on <u>{app.issuingDate}</u>. <span className="float-right">Review rating: <b><i>{app.rating}/5</i></b></span></li>:
            <li className="list-group-item bg-secondary text-white">{app.id}. applied for {app.job.name}[<i>{app.job.code}</i>] on <u>{app.issuingDate}</u>.
                <span className="float-right"><form action="" onChange={this.handleChange}>
                    <select name="rating" className="" onChange={this.handleChange}>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                    </select>
                    <button value={app.id} onClick={this.handleReview} className="btn btn-success">APPLY</button>
                </form></span></li>)

        return (
            <div>
                {applications}
            </div>
        )
    }
}
export default AdminpanelApplications