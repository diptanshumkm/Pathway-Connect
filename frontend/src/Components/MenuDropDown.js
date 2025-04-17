import React from 'react';
import { Link } from 'react-router-dom';

export const MenuDropDown = ({ onClose }) => {
  const options = [
    { label: "Register as Mentor", path: "/register-mentor" },
    { label: "Register as Mentee", path: "/register-mentee" }
  ];

  return (
    <div className="bg-white text-black w-56 rounded-md shadow-lg z-50">
      <ul className="flex flex-col p-2">
        {options.map((option, index) => (
          <li
            key={index}
            className="py-2 px-4 hover:bg-gray-100 rounded-md transition duration-200"
          >
            <Link to={option.path} onClick={onClose} className="block">
              {option.label}
            </Link>
          </li>
        ))}
      </ul>
    </div>
  );
};
