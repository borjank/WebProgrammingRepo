import React from "react";
import axios from "axios";
class AdminpanelInterviews extends React.Component{
    state = {
        interviews: []
    }
    componentDidMount() {
        fetch("http://localhost:8080/interviews")
            .then(response => response.json())
            .then(data => {
                this.setState({jobs: data})
            })
    }
    handleDelete = (event) =>{
        axios.delete("http://localhost:8080/deleteInterview/"+event.target.value)
        this.forceUpdate()
    }
    render() {
        const listItem = this.state.interviews.map(interview =>
            <li className="list-group-item">{interview.id}.
                <span className="float-right"><button className="btn btn-outline-danger" value={interview.id} onClick={this.handleDelete}> X </button></span>
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
export default AdminpanelInterviews