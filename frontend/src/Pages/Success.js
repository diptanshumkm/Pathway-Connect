import React from 'react';
import { Link, useLocation } from 'react-router-dom';

export default function Success() {
  
  const location = useLocation();
  const { state } = location;
  
  console.log("Received location.state:", location.state);
  const {loginId, loginPassword} = state || {};
  

  return (
    <div className="flex flex-col items-center justify-center min-h-screen bg-green-50">
      <h1 className="text-3xl font-bold text-green-700 mb-4">🎉 Registered Successfully!</h1>
      <p className="mb-6">Thank you for registering. We’ll be in touch shortly.</p>
      
      <p><strong>Login ID:</strong> {loginId}</p>
      <p><strong>Password:</strong> {loginPassword}</p>

      <Link
        to="/"
        className="bg-green-600 text-white px-4 py-2 rounded hover:bg-green-700 transition"
      >
        Back to Home
      </Link>

    </div>
  );
}
