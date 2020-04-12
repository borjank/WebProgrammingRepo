import React from "react";
import Navbar from "./Navbar";
import JobForm from "./career-components/job-form";
import JobCard from "./career-components/job-card";
import axios from "axios";
import LoginForm from "./login-components/login-form";
class Career extends React.Component{
    state= {
        availableJobs: [],
        greetingCard: {
            title: "WE ARE HIRING",
            text: "We are looking for highly intelligent individuals. If you think you have got what it takes to join our team, use the form below to apply. Best of luck!"
        },
        name:"",
        surname:"",
        email:"",
        jobId:-1,
        date:""
    };
    componentDidMount() {
        fetch("http://localhost:8080/jobs")
            .then(response=>response.json())
            .then(data=> {
                this.setState({availableJobs:data})
            })
    }
    handleSubmit = (event) =>{
        event.preventDefault();
        const today = new Date();
        const dd = String(today.getDate()).padStart(2, '0');
        const mm = String(today.getMonth() + 1).padStart(2, '0') //January is 0!
        const yyyy = today.getFullYear();

        const now = dd+"."+mm+"."+yyyy;
        this.setState({data:now})
        const data = {
            applicant: {name: this.state.name,
            surname: this.state.surname,
            email: this.state.email,
            password:"default password"},
            jobId: this.state.jobId,
            issuingDate: this.state.date
        }
        const url = "http://localhost:8080/addApplication"


        axios.post(url, data).then(r => {

        })
    }
    handleChange = (event) => {
        const {name,value,checked,type} = event.target
        this.setState({[name]:value})
        console.log([name]+":"+value)
    }
    render() {

        return(
            <div>
                <Navbar/>
                <main className="container">
                    <JobCard info={this.state.greetingCard}/>
                    <JobForm
                        jobs={this.state.availableJobs}
                        handleSubmit={this.handleSubmit}
                        handleChange={this.handleChange}
                        name={this.state.name}
                        surname={this.state.surname}
                        email={this.state.email}
                        jobId={this.state.jobId}
                    />
                </main>
            </div>
        );
    }
}
export default Career