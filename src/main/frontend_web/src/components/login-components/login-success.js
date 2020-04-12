import React from "react";
function LoginSuccess() {
    return(
        <div className="card col-8 mx-auto mt-5 border-success text-center">
            <div className="card-body">
                <h4>You're logged in. Continue to your <a href="/profile" className="text-success">profile page</a>.</h4>
            </div>
        </div>
    );
}
export default LoginSuccess