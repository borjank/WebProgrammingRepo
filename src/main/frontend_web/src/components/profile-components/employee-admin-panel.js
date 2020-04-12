import React from "react";
class EmployeeAdminPanel extends React.Component{

    render() {
        return(
            <div>
                <div className="card text-center mb-3">
                    <div className="card-header">
                        <ul className="nav nav-tabs card-header-tabs">
                            <li className="nav-item">
                                <a className="nav-link active" href="#">Applicants</a>
                            </li>
                            <li className="nav-item">
                                <a className="nav-link" href="#">Employees</a>
                            </li>
                            <li className="nav-item">
                                <a className="nav-link" href="#">Applications</a>
                            </li>
                            <li className="nav-item">
                                <a className="nav-link" href="#">Interviews</a>
                            </li>
                            <li className="nav-item">
                                <a className="nav-link" href="#">Jobs</a>
                            </li>
                        </ul>
                    </div>
                    <div className="card-body">
                    {/*    TODO: Utilize all the administrative APIs and place forms for them in the separate tabs*/}
                    </div>
                </div>
            </div>
        );
    }
}
export default EmployeeAdminPanel