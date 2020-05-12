import React from "react";
import Navbar from "./Navbar";
import axios from 'axios';
import EmployeeProfile from "./profile-components/employee-profile";
import ApplicantProfile from "./profile-components/applicant-profile";
class Profile extends React.Component{

    state={
        person: [],
        jobInfo: [],
        applications: []
    }
    componentDidMount() {
        const cookiedata = document.cookie;
        if(cookiedata.charAt(cookiedata.length-1)==="a"){
            const url = "http://localhost:8080/applicant/"+cookiedata.substring(11,cookiedata.length-1)
            axios.get(url)
                .then(r =>{
                    this.setState({person:r.data})
                })
            const apps = "http://localhost:8080/applications/"+cookiedata.substring(11,cookiedata.length-1)
            fetch(apps)
                .then(r => r.json())
                .then(data => {
                    this.setState({applications : data})
                })
        }else if(cookiedata.charAt(cookiedata.length-1)==="e"){
            const url = "http://localhost:8080/employee/"+cookiedata.substring(11,cookiedata.length-1)

            axios.get(url)
                .then(r =>{
                    this.setState({person:r.data})
                    this.setState({jobInfo:this.state.person.position})
                    console.log(r.data)
                })
        }
    }

    render() {
        const d= document.cookie;
        console.log(this.state.applications[0])
        return(
            <div>
                <Navbar current="profile"/>

                <main role="main" className="container">
                    {d.charAt(d.length-1)==="e"?
                        <EmployeeProfile
                            id={this.state.person.id}
                            name={this.state.person.name}
                            surname={this.state.person.surname}
                            address={this.state.person.address}
                            dateOfBirth={this.state.person.dateOfBirth}
                            position={this.state.jobInfo.name}
                            position_code={this.state.jobInfo.code}
                            position_rank={this.state.jobInfo.rank}
                            salary={this.state.person.salary}
                            bankAccountNumber={this.state.person.bankAccountNumber}
                            email={this.state.person.email}
                            ssn={this.state.person.ssn}
                            dateOfContract={this.state.person.dateOfContract}
                        />:
                        d.charAt(d.length-1)==="a"?
                            <ApplicantProfile
                                id={this.state.person.id}
                                name={this.state.person.name}
                                surname={this.state.person.surname}
                                email={this.state.person.email}
                                application = {this.state.applications[0]}
                            />:
                            window.location.replace("/login")

                    }

                </main>
            </div>
        )
    }
}
export default Profile