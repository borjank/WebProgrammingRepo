import React from "react";

class JobForm extends React.Component{
    render() {
        const jobs = this.props.jobs.map(job => <option value={job.id}>{job.name}</option>);
        return(
            <div className="card">
                <div className="card-header">
                    <h2>Job Application</h2>
                </div>
                <div className="card-body">
                    <form onSubmit={this.props.handleSubmit}>
                        <div className="form-row">
                            <div className="form-group col-md-6">
                                <label htmlFor="firstName">Name</label>
                                <input type="text" value={this.props.name} name="name" className="form-control" id="firstName" autoFocus placeholder="Enter first name"/>
                            </div>
                            <div className="form-group col-md-6">
                                <label htmlFor="lastName">Surname</label>
                                <input type="text" value={this.props.surname} name="surname" className="form-control" id="lastName" placeholder="Enter last name"/>
                            </div>
                        </div>
                        <div className="form-row">
                            <div className="form-group col-md-12">
                                <label htmlFor="email">Email</label>
                                <input type="text" value={this.props.email} name="email" className="form-control" id="email" placeholder="Enter your e-mail address"/>
                            </div>
                        </div>
                        <div className="form-row">
                            <div className="form-group col-md-12">
                                <label htmlFor="jobPosition">Job position</label>
                                <select id="jobPosition" name="jobId" className="form-control">
                                    <option value="">Select the job you are applying for</option>
                                    {jobs}
                                </select>
                            </div>
                        </div>
                        <div className="form-row">
                            <div className="form-group col-md-12">
                                <input type="submit" value="Submit" className="btn btn-success"/>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        );
    }
}
export default JobForm