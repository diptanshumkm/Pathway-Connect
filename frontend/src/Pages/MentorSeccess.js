import React from 'react';
import { Link } from 'react-router-dom';

export default function MentorSuccess() {
  return (
    <div className="flex flex-col items-center justify-center min-h-screen bg-green-50">
      <h1 className="text-3xl font-bold text-green-700 mb-4">🎉 Mentor Registered Successfully!</h1>
      <p className="mb-6">Thank you for registering. We’ll be in touch shortly.</p>
      <Link
        to="/"
        className="bg-green-600 text-white px-4 py-2 rounded hover:bg-green-700 transition"
      >
        Back to Home
      </Link>
    </div>
  );
}
