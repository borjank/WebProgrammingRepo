import React from "react";
class JobFormAlert extends React.Component{
    state={
        text: this.props.text
    }
    render() {
        return(
            <div className="alert alert-info text-center" role="alert">
                <div className="">
                    <h1>{this.props.info.title}</h1>
                </div>
                <div className="justify-content-center">
                    <p style={{"fontSize":"18px"}}>This is a <b>preview</b> of what an application form will look like. This is the form you post on your website or wherever you need it. <br/>At the moment the user clicks the <b>SUBMIT</b> button,
                        the data is verified against our security criteria and stored in our database. <br/>
                        <b> Note:</b> the design is open for modification to suit your needs. <br/>
                    </p>
                </div>
            </div>
        );
    }
}
export default JobFormAlert