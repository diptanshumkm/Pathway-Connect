import React, { useState } from "react";
import { GiHamburgerMenu } from "react-icons/gi";
import { DiApple } from "react-icons/di";
import { MenuDropDown } from "./MenuDropDown";
import { Link } from "react-router-dom";

function Navbar() {
  const [menuOpen, setMenuOpen] = useState(false);

  const toggleMenu = () => {
    setMenuOpen(prev => !prev);
  };

  return (
    <div className="relative">
      <nav className="fixed top-0 left-0 w-full bg-gradient-to-r from-purple-600 to-blue-700 text-white px-4 py-3 shadow-lg z-50">
        <div className="container mx-auto flex items-center justify-between">
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

          <h1 className="text-xl font-bold tracking-wide">
            <Link to="/">Pathway Connect</Link>
          </h1>

          <DiApple className="text-2xl cursor-pointer transition-transform duration-200 hover:scale-110" />
        </div>
      </nav>
    </div>
  );
}

export default Navbar;
