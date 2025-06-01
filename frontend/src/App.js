import React from "react";
import { Route, Routes } from "react-router-dom";
import Home from "./Pages/Home";
import Navbar from "./Components/Navbar";
import RegisterMentor from "./Pages/RegisterMentor";
import RegisterMentee from "./Pages/RegisterMentee";
import { LoginMentor } from "./Pages/LoginMentor";
import { LoginMentee } from "./Pages/LoginMentee";
import { MentorDashboard } from "./Pages/MentorDashboard";
import { MenteeDashboard } from "./Pages/MenteeDashboard";
import Success from "./Pages/Success";


function App() {
  return (
    <div className="flex flex-col min-h-screen bg-[#EAF6FD] overflow-x-hidden">
      {/* Navbar */}
      <Navbar />

      {/* Main Layout */}
      <main className="flex-grow overflow-x-hidden">
        <Routes>
          <Route path="" element={<Home />} />
          <Route path="/register-mentor" element={<RegisterMentor />} />
          <Route path="/register-mentee" element={<RegisterMentee />} />
          <Route path="/success" element={<Success />} />
          <Route path="/mentor/login" element={<LoginMentor />} />
          <Route path="/mentee/login" element={<LoginMentee />} />
          <Route path="/mentor/dashboard" element={<MentorDashboard />} />
          <Route path="/mentee/dashboard" element={<MenteeDashboard />} />
        </Routes>
      </main>
    </div>
  );
}

export default App;
