import React from "react";
import Home from "./Home";
import {BrowserRouter as Router, Route} from "react-router-dom";
import Career from "./Career";
import Login from "./Login";
import Profile from "./Profile";
import EmployeeProfile from "./profile-components/employee-profile";
import ApplicantProfile from "./profile-components/applicant-profile";
import LogoutSuccess from "./login-components/logout-success";
class App extends React.Component{
    render() {
        return(
            <Router>
                <Route exact path="/" component={Home}/>
                <Route exact path="/career" component={Career}/>
                <Route exact path="/login" component={Login}/>
                <Route exact path="/logout" component={LogoutSuccess}/>
                <Route exact path="/profile" component={Profile}/>
            </Router>
        );
    }
}
export default App;