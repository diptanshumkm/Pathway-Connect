import React, { useState } from "react";
import { GiHamburgerMenu } from "react-icons/gi";
import { DiApple } from "react-icons/di";
import { MenuDropDown } from "./MenuDropDown";
import { Link } from "react-router-dom";

function Navbar() {
  const [menuOpen, setMenuOpen] = useState(false);

  const options = [
    "Explore Mentors",
    "AI Mentors",
    "Success Stories"
  ]

  const toggleMenu = () => {
    setMenuOpen(prev => !prev);
  };

  return (
    <div className="w-full overflow-x-hidden">
      <nav className="fixed top-0 left-0 w-full bg-[#EAF6FD] text-black h-[79.2px] font-[InterDisplay,sans-serif] text-[16px] leading-[24px] font-normal tracking-normal z-50 shadow-md">
        <div className="max-w-[1520.8px] mx-auto flex items-center justify-between px-8">
           {/* Logo + Title */}
          <div className="flex gap-x-3 items-center">
            <h1 className="text-xl font-bold tracking-wide">
              <Link to="/">Pathway Connect</Link>
            </h1>
          </div>
          
          {/* Navigation Options */}
          <div className="flex gap-4">
            {options.map((option, index) => (
              <button
                key={index}
                className="w-[130.788px] h-[79.2px] text-black text-[15px] leading-[20px] font-normal tracking-normal font-[InterDisplay,sans-serif] flex items-center justify-center text-center"
              >
                {option}
              </button>
            ))}
          </div>


          {/* Menu bar button and find your mentor button*/}
          <div className="flex gap-x-3 items-center">
            <div className="relative">
              <GiHamburgerMenu
                onClick={toggleMenu}
                className="text-2xl cursor-pointer transition-transform duration-200 hover:scale-110"
              />
              {/* Attach dropdown near hamburger */}
              {menuOpen && (
                <div className="absolute top-10 left-0 z-50">
                  <MenuDropDown onClose={() => setMenuOpen(false)} />
                </div>
              )}
            </div>
               
            <button className="text-white text-[14px] leading-[20px] font-medium tracking-normal bg-[#1F2937] w-[157.55px] h-[36px] rounded-[8px] font-[InterDisplay,sans-serif]">
              Find your mentor
            </button>

          </div>

          
        </div>
      </nav>
    </div>
  );
}

export default Navbar;
