import React from "react";
import Navbar from "./Navbar";
import HomeCard from "./home-components/home-card";
class Home extends React.Component{
    render() {
        return(
            <div>
                <Navbar/>
                <main className="container">
                    <HomeCard img="https://cdn.pixabay.com/photo/2015/02/24/15/41/dog-647528_960_720.jpg" title="Stars" text="Some random stars and wolf image"/>
                    <HomeCard img="https://www.stevens.edu/sites/stevens_edu/files/styles/news_detail/public/shutterstock_1165123768.jpg?itok=haoBDwhQ" title="Numbers" text="Some random numbers in 3D"/>
                </main>
            </div>
        );
    }
}
export default Home