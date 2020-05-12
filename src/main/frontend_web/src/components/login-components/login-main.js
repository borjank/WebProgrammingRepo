import React from "react";
import {Route, Router} from "react-router-dom";
import Profile from "../Profile";
import LoginForm from "./login-form";
import LoginSuccess from "./login-success";
import axios from 'axios'

class LoginMain extends React.Component{
    state = {
        email: "",
        password: "",
        loggedIn: false,
        id:-1
    }

    handleChange = (event) => {
        const {name,value,checked,type} = event.target
        this.setState({[name]:value})
        console.log([name]+":"+value)
    }
    handleSubmit = (event) =>{
        event.preventDefault();

        const data = {
            email: this.state.email,
            password: this.state.password
        }
        const url = "http://localhost:8080/login"


        axios.post(url, data).then(r => {
            if (r.data.charAt(0)==='1'){
                const id = r.data.substring(2,r.data.length-1);
                this.setState({loggedIn:true})
                this.setState({id:id})
                this.setState({personInfo:r.data.charAt(1)})
                const datacomb = id+r.data.charAt(r.data.length-1)

                let dt = new Date();
                dt = new Date(dt.getTime() + 1000*60*60*24);
                document.cookie = "loginToken="+datacomb+"; expires="+dt.toUTCString()+";";
            }else{
                alert(r.data)
            }
        })
    }

    render() {
        return(
            <main role="main" className="container">
                {this.state.loggedIn?
                    <LoginSuccess/>:
                    <LoginForm
                        handleChange={this.handleChange}
                        handleSubmit={this.handleSubmit}
                        email={this.state.email}
                        password={this.state.password}
                    />
                }
            </main>
        );
    }
}
export default LoginMain