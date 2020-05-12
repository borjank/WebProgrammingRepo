import React from "react";
function ApplicationReceived() {
    return(
        <div className="card col-8 mx-auto mt-5 border-success text-center">
            <div className="card-body">
                <h4>We've received your application! Once it is reviewed you will be contacted.<br/>Also you can check the status of your application by logging into your <a href="/profile" className="text-info">profile page</a><br/>using the e-mail address and password you provided.</h4>
            </div>
        </div>
    );
}
export default ApplicationReceived