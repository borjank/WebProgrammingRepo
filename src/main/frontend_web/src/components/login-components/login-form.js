import React from "react";
function LoginForm(props) {
    return(
        <div className="card col-8 mx-auto mt-5 border-primary">
            <div className="card-body">
                <form onSubmit={props.handleSubmit}>
                    <label htmlFor="email" className="text-primary">E-mail</label>
                    <input
                    type="text"
                    name="email"
                    value={props.email}
                    placeholder="Enter e-mail address"
                    id="email"
                    onChange={props.handleChange}
                    className="form-control border-primary"
                    autoFocus
                /><br/>
                    <label htmlFor="password" className="text-primary">Password</label>
                    <input
                    type="password"
                    name="password"
                    value={props.password}
                    id="password"
                    onChange={props.handleChange}
                    className="form-control border-primary"
                /><br/>

                    <input type="submit" value="Submit" className="btn btn-primary"/>
                </form>
            </div>
        </div>
    );
}
export default LoginForm