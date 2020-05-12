import React from "react";
import Navbar from "./Navbar";
import JobForm from "./career-components/job-form";
import JobFormAlert from "./career-components/job-form-alert";
import axios from "axios";
import ApplicationReceived from "./career-components/application-received";
class Career extends React.Component{
    state= {
        availableJobs: [],
        greetingCard: {
            title: "Brief description"
        },
        name:"",
        surname:"",
        email:"",
        jobId:-1,
        password:"",
        success:0
    };
    componentDidMount() {
        fetch("http://localhost:8080/jobs")
            .then(response=>response.json())
            .then(data=> {
                data.shift();
                this.setState({availableJobs:data})
            })
    }
    handleChange = (event) => {
        const {name,value,checked,type} = event.target
        this.setState({[name]:value})
        console.log([name]+":"+value)
    }
    handleSubmit = (event) =>{
        event.preventDefault();

        const applicantData = {
            name: this.state.name,
            surname: this.state.surname,
            email: this.state.email,
            password:this.state.password
        }

        const applicantUrl = "http://localhost:8080/addApplicant"

        const today = new Date();
        const dd = String(today.getDate()).padStart(2, '0');
        const mm = String(today.getMonth() + 1).padStart(2, '0') //January is 0!
        const yyyy = today.getFullYear();
        const now = dd+"."+mm+"."+yyyy;

        let dt = new Date();
        dt = new Date(dt.getTime() + 1000*60);
        axios.post(applicantUrl, applicantData)
            .then(r=>{
                const applicationData = {
                    id: '"'+r.data+'"',
                    job_id: '"'+this.state.jobId+'"',
                    issuingDate: now
                }
                const applicationUrl = "http://localhost:8080/addApplication"
                axios.post(applicationUrl, applicationData)
                    .then(r=>{
                        if(r.data==="APPLICATION REGISTERED."){
                            this.setState({success:1})
                        }
                    })
            });

    }
    handleReset = () =>{
        this.setState({
            name:"",
            surname:"",
            email:"",
            jobId:-1,
            password:""
        })
    }

    render() {
        return(
            <div>
                <Navbar current="career"/>
                {this.state.success===0?
                    <main className="container">
                        <JobFormAlert info={this.state.greetingCard}/>
                        <JobForm
                            jobs={this.state.availableJobs}
                            handleSubmit={this.handleSubmit}
                            handleChange={this.handleChange}
                            handleReset={this.handleReset}
                            name={this.state.name}
                            surname={this.state.surname}
                            email={this.state.email}
                            jobId={this.state.jobId}
                            password={this.state.password}
                        />
                    </main>:
                    <ApplicationReceived/>
                }

            </div>
        );
    }
}
export default Career