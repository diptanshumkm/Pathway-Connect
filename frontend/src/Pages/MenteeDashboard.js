import React from 'react';
import { useLocation } from 'react-router-dom';

export const MenteeDashboard = () => {
  const location = useLocation();
  const { state } = location;

  if (!state) {
    return <div className="flex justify-center items-center h-screen text-xl">Loading...</div>;
  }

  const {
    name,
    email,
    phone,
    profilePic,
    role,
    educationLevel,
    fieldOfStudy,
    institution,
    goalType,
    goal,
    interests
  } = state;

  return (
    <div className="min-h-screen bg-gray-100 flex flex-col items-center p-8">
      <div className="bg-white shadow-lg rounded-2xl p-8 w-full max-w-3xl mt-4">
        <div className="flex flex-col items-center">
          <img
            src={profilePic}
            alt="Profile"
            className="w-32 h-32 rounded-full object-cover mb-4"
          />
          <h1 className="text-2xl font-bold mb-2">{name}</h1>
          <p className="text-gray-500">{role}</p>
        </div>

        <div className="mt-8 space-y-4">
          <div>
            <h2 className="text-lg font-semibold text-gray-700">Contact Information</h2>
            <p><span className="font-semibold">Email:</span> {email}</p>
            <p><span className="font-semibold">Phone:</span> {phone}</p>
          </div>

          <div>
            <h2 className="text-lg font-semibold text-gray-700">Education</h2>
            <p><span className="font-semibold">Level:</span> {educationLevel}</p>
            <p><span className="font-semibold">Field of Study:</span> {fieldOfStudy}</p>
            <p><span className="font-semibold">Institution:</span> {institution}</p>
          </div>

          <div>
            <h2 className="text-lg font-semibold text-gray-700">Goals</h2>
            <p><span className="font-semibold">Type:</span> {goalType}</p>
            <p><span className="font-semibold">Description:</span> {goal}</p>
          </div>

          <div>
            <h2 className="text-lg font-semibold text-gray-700">Interests</h2>
            {interests && interests.length > 0 ? (
              <ul className="list-disc list-inside">
                {interests.map((interest, index) => (
                  <li key={index}>{interest}</li>
                ))}
              </ul>
            ) : (
              <p>No interests listed</p>
            )}
          </div>
        </div>
      </div>
    </div>
  );
};
