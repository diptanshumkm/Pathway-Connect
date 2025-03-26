import React from "react";

function Card({ name, expertise, experience, interest, learningGoal, image, contact }) {
  return (
    <div className="bg-white shadow-md rounded-lg p-6 w-72 text-center hover:shadow-xl transition transform hover:scale-105 duration-300">
      
      {/* Profile Image */}
      <img src={image} alt={name} className="w-24 h-24 mx-auto rounded-full mb-4 border-2 border-gray-300" />
      
      {/* Name */}
      <h3 className="text-xl font-bold text-gray-800">{name}</h3>
      
      {/* Conditional Fields */}
      {expertise && <p className="text-sm text-gray-600 mt-2"><span className="font-semibold text-gray-700">Expertise:</span> {expertise}</p>}
      {experience && <p className="text-sm text-gray-600"><span className="font-semibold text-gray-700">Experience:</span> {experience}</p>}
      {interest && <p className="text-sm text-gray-600"><span className="font-semibold text-gray-700">Interest:</span> {interest}</p>}
      {learningGoal && <p className="text-sm text-gray-600"><span className="font-semibold text-gray-700">Goal:</span> {learningGoal}</p>}

      {/* Contact Button */}
      {contact && (
        <a 
          href={`mailto:${contact}`} 
          className="inline-block mt-4 px-4 py-2 bg-blue-500 text-white rounded-lg text-sm font-semibold hover:bg-blue-600 transition duration-300"
        >
          Contact
        </a>
      )}
    </div>
  );
}

export default Card;
