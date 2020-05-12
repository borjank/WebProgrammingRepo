import React from "react";
import axios from "axios";
class AdminpanelEmployees extends React.Component {
    state = {
        employees: []
    }

    componentDidMount() {
        fetch("http://localhost:8080/employees")
            .then(response => response.json())
            .then(data => {
                this.setState({employees: data})
            })
    }

    handleDelete = (event) => {
        axios.delete("http://localhost:8080/deleteEmployee/" + event.target.value)
        this.forceUpdate()
    }

    render() {
        const listItem = this.state.employees.map(emp =>
            <li className="list-group-item">{emp.id}. {emp.name} {emp.surname} [{emp.position.name}]
                <span className="float-right"><button className="btn btn-outline-danger" value={emp.id}
                                                      onClick={this.handleDelete}> X </button></span>
            </li>)
        return (
            <div>
                <ul className="list-group">

                    {listItem}
                </ul>
            </div>
        )
    }
}
export default AdminpanelEmployees