import React from "react";
import Navbar from "./Navbar";
import axios from 'axios';
import ProfileEmployee from "./profile-components/profile-employee";
import ApplicantProfile from "./profile-components/applicant-profile";
class Profile extends React.Component{
    constructor() {
        super();
    }
    state={
        person: [],
        jobInfo: []
    }
    componentDidMount() {
        const cookiedata = document.cookie;
        if(cookiedata.charAt(cookiedata.length-1)==="a"){
            const url = "http://localhost:8080/applicant/"+cookiedata.substring(5,cookiedata.length-2)
            axios.get(url)
                .then(r =>{
                    this.setState({person:r.data})
                })
        }else if(cookiedata.charAt(cookiedata.length-1)==="e"){
            const url = "http://localhost:8080/employee/"+cookiedata.substring(5,cookiedata.length-1)
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
        return(
            <div>
                <Navbar/>
                <main role="main" className="container">
                    {d.charAt(d.length-1)==="e"?
                        <ProfileEmployee
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
                        <ApplicantProfile
                            name={this.state.person.name}
                            surname={this.state.person.surname}
                            email={this.state.person.email}
                        />
                    }
                </main>
            </div>
        )
    }
}
export default Profile