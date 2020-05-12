import React from "react";
import Navbar from "./Navbar";
import LoginMain from "./login-components/login-main";
class Login extends React.Component{
    state={

    }
    render() {
        return (
            <div>
                <Navbar current="profile"/>
                <LoginMain/>
            </div>
        );
    }
}
export default Login;