import React from "react";
import { GiHamburgerMenu } from "react-icons/gi";
import { DiApple } from "react-icons/di";


function Navbar() {
  console.log("Navbar mounted")
  return (
    <nav className="fixed top-0 left-0 w-full bg-gradient-to-r from-purple-500 to-blue-600 text-white p-4 shadow-md z-50">
      <div className="container mx-auto flex items-center justify-between">
        
        <GiHamburgerMenu className="text-white text-2xl cursor-pointer" />

       
        <h1 className="text-white text-xl font-semibold">Pathway Connect</h1>

      
        <DiApple className="text-white text-2xl cursor-pointer" />
      </div>
    </nav>
  );
}

export default Navbar;
