import React from "react";

class Navbar extends React.Component{
    render() {
        return (
            <nav className="navbar navbar-expand-md navbar-dark bg-dark sticky-top mb-2">
                <a href="#" className="navbar-brand">HR TooL</a>
                <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse">
                    <span className="navbar-toggler-icon"/>
                </button>
                <div className="collapse navbar-collapse" id="navbarCollapse">
                    <ul className="navbar-nav mr-auto">
                        <li className="nav-item">
                            <a href="/" className="nav-link">
                                Home
                            </a>
                        </li>
                        <li className="nav-item">
                            <a href="/career" className="nav-link">Career</a>
                        </li>
                        <li className="nav-item">
                            <a href="/login" className="nav-link">Login</a>
                        </li>
                    </ul>
                </div>
            </nav>
    );
    }
}
export default Navbar