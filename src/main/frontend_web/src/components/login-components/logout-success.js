import React from "react";
import axios from "axios";

class LogoutSuccess extends React.Component{
    componentDidMount() {
        document.cookie = "loginToken= ; expires = Thu, 01 Jan 1970 00:00:00 GMT";
    }

    render() {
        return(
            <div className="card col-8 mx-auto mt-5 border-danger text-center">
                <div className="card-body">
                    <h4>You've been logged out. Thank you for using <a href="/" className="text-primary">our website</a>!<br/>Looking forward to seeing you again!</h4>
                </div>
            </div>
        );
    }
}
export default LogoutSuccess