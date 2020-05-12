import React from "react";
import logo from "../img/logo2.png";

class Navbar extends React.Component{
    render() {
        const curr = this.props.current
        const inactiveStyle = "nav-item"
        const activeStyle = "nav-item active"

        return (
            <nav className="navbar navbar-expand-md navbar-dark bg-dark sticky-top mb-2">
                <a href="/"  className="navbar-brand"><img src={logo} height="50" alt=""/></a>
                <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse">
                    <span className="navbar-toggler-icon"/>
                </button>
                <div className="collapse navbar-collapse" id="navbarCollapse">
                    <ul className="navbar-nav mr-auto">
                        <li className={curr === "home" ? activeStyle : inactiveStyle}>
                            <a href="/" className="nav-link">Home</a>
                        </li>
                        <li className={curr === "career" ? activeStyle : inactiveStyle}>
                            <a href="/career" className="nav-link">Career</a>
                        </li>
                        <li className={curr === "profile" ? activeStyle : inactiveStyle}>
                            <a href="/profile" className="nav-link">Profile</a>
                        </li>
                    </ul>
                </div>
            </nav>
    );
    }
}
export default Navbar