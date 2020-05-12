import React from "react";
import axios from "axios";
class AdminpanelJobs extends React.Component{
    state = {
        jobs: []
    }
    componentDidMount() {
        fetch("http://localhost:8080/jobs")
            .then(response => response.json())
            .then(data => {
                this.setState({jobs: data})
            })
    }
    handleDelete = (event) =>{
        axios.delete("http://localhost:8080/deleteJob/"+event.target.value)
        this.forceUpdate()
    }
    render() {
        const listItem = this.state.jobs.map(job =>
            <li className="list-group-item">{job.id}. {job.name}[{job.code}] Job-ranking: <b><i>{job.rank}</i></b>
                <span className="float-right"><button className="btn btn-outline-danger" value={job.id} onClick={this.handleDelete}> X </button></span>
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
export default AdminpanelJobs