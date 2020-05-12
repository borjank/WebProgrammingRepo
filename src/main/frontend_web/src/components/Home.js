import React from "react";
import Navbar from "./Navbar";
import HomeCard from "./home-components/home-card";
import infoimg from "../img/pngwave.png";
class Home extends React.Component{
    render() {

        return(
            <div>
                <Navbar current="home"/>
                <main className="container">
                    <HomeCard img={infoimg} title="HR-TOOL INFO" text="This is a tool made as a web-programming project. It keeps track of applicants and their applications,
                    employees, jobs and the interviews that can be issued by an employee of higher ranking based on their applications. Some functionalities aren't fully implemented into
                    the frontend part of the website, but will be added in some of the following versions. The frontend part is using ReactJS, the backend is running on Java Spring architecture
                     and the database is PostgreSQL."/>
                </main>
            </div>
        );
    }
}
export default Home