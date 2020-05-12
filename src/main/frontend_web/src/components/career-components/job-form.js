import React from "react";

class JobForm extends React.Component{

    render() {
        const jobs = this.props.jobs.map(job => <option value={job.id}>{job.name}</option>);
        return(
            <div className="card mb-3 border-secondary">
                <div className="card-header text-center">
                    <h3>Job Application</h3>
                </div>
                <div className="card-body">
                    <form onSubmit={this.props.handleSubmit}>
                        <div className="form-row">
                            <div className="form-group col-md-6">
                                <label htmlFor="firstName">Name</label>
                                <input type="text" value={this.props.name} onChange={this.props.handleChange} name="name" className="form-control" id="firstName" autoFocus placeholder="Enter first name"/>
                            </div>
                            <div className="form-group col-md-6">
                                <label htmlFor="lastName">Surname</label>
                                <input type="text" value={this.props.surname} onChange={this.props.handleChange} name="surname" className="form-control" id="lastName" placeholder="Enter last name"/>
                            </div>
                        </div>
                        <div className="form-row">
                            <div className="form-group col-md-6">
                                <label htmlFor="email">Email</label>
                                <input type="text" value={this.props.email} onChange={this.props.handleChange} name="email" className="form-control" id="email" placeholder="Enter your e-mail address"/>
                            </div>

                            <div className="form-group col-md-6">
                                <label htmlFor="password">Password</label>
                                <input type="password" value={this.props.password} onChange={this.props.handleChange} name="password" className="form-control" id="password" />
                            </div>
                        </div>
                        <div className="form-row">
                            <div className="form-group col-md-12">
                                <label htmlFor="jobPosition">Job position</label>
                                <select id="jobPosition" name="jobId" className="form-control" onChange={this.props.handleChange}>
                                    <option value="">Select the job you are applying for</option>
                                    {jobs}
                                </select>
                            </div>
                        </div>
                        <div className="form-row">
                            <div className="form-group col-md-12 text-right">
                                <input type="submit" value="Submit" className="btn btn-success mr-1"/>
                                <input type="reset" value="Reset" onClick={this.props.handleReset} className="btn btn-danger"/>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        );
    }
}
export default JobForm