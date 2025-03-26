import React from "react";
import { Route, Routes } from "react-router-dom";
import Home from "./Pages/Home";
import Navbar from "./Components/Navbar";
import LeftBar from "./Components/LeftBar";
import RightBar from "./Components/RightBar";

function App() {
  return (
    <div className="flex flex-col h-screen">
      {/* Navbar */}
      <div>
        <Navbar />

      </div>

      {/* Main Layout */}
      <div className="flex flex-grow">
        {/* Left Sidebar - Hidden on Small Screens */}
        <div className="hidden md:block w-1/4">
          <LeftBar />
        </div>

        {/* Main Content */}
        <div className="flex-grow overflow-auto p-4">
          <Routes>
            <Route path="/" element={<Home />} />
          </Routes>
        </div>

        {/* Right Sidebar - Hidden on Small Screens */}
        <div className="hidden lg:block w-1/4">
          <RightBar />
        </div>
      </div>
    </div>
  );
}

export default App;
