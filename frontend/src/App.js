import React from "react";
import { Route, Routes } from "react-router-dom";
import Home from "./Pages/Home";
import Navbar from "./Components/Navbar";
import RegisterMentor from "./Pages/RegisterMentor";
import RegisterMentee from "./Pages/RegisterMentee";
import MentorSuccess from "./Pages/MentorSeccess";


function App() {
  return (
    <div className="flex flex-col h-screen">

      {/* Navbar */}
      <div>
        <Navbar />
      </div>


      {/* Main Layout */}
      <div className="flex flex-grow">
     
        <div className="flex-grow overflow-auto p-4">
          <Routes>
            <Route path="" element={<Home />} />
            <Route path="/register-mentor" element={<RegisterMentor />} ></Route>
            <Route path="/register-mentee" element={<RegisterMentee />} ></Route>
            <Route path="/mentor/success" element={<MentorSuccess />} />
          </Routes>
        </div>
      </div>
    </div>
  );
}

export default App;
