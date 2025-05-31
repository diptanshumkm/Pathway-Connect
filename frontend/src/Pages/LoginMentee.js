import axios from 'axios';
import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

export const LoginMentee = () => {

  const navigate = useNavigate();

  const [formData, setFormData] = useState({
    userId: '',
    password: ''
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData(prevData => ({
      ...prevData,
      [name]: value
    }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log('Form submitted:', formData);

    // Add your login logic here
    axios
      .post("http://localhost:8080/users/login/mentee", formData)
      .then( (response) => {
        console.log(response.data);
        navigate( "/mentor/dashboard", 
          {
            state: response.data
          }
         )

      } )
      .catch( (error) => {
        console.error("Login error:", error);
        alert("Login failed. Please check your credentials.");  
      } )


  };


  const formOptions = [
    { label: 'User ID', name: 'userId', type: 'text', placeholder: 'Enter your user ID' },
    { label: 'Password', name: 'password', type: 'password', placeholder: 'Enter your password' }
  ];

  return (
    <div className='flex justify-center items-center min-h-screen w-full bg-gray-50'>
        <div className='w-96 bg-white h-auto p-8 rounded-lg shadow-md border border-gray-200'>
            <h2 className='text-blue-700 text-2xl font-bold mb-6 text-center'>Mentor Login</h2>
            
            <form onSubmit={handleSubmit}>
                {formOptions.map((option, index) => (
                <div key={index} className='mb-4'>
                    <label className='block text-gray-700 text-sm font-medium mb-2' htmlFor={option.name}>
                    {option.label}
                    </label>
                    <input
                    className='w-full px-3 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500 focus:border-blue-500'
                    id={option.name}
                    name={option.name}
                    type={option.type}
                    placeholder={option.placeholder}
                    value={formData[option.name]}
                    onChange={handleChange}
                    required
                    />
                </div>
                ))}
                
                <button 
                type="submit" 
                className='w-full bg-blue-600 hover:bg-blue-700 text-white font-medium py-2 px-4 rounded-md transition-colors'
                >
                Sign In
                </button>
            </form>
        </div>
    </div>
    
  );
};