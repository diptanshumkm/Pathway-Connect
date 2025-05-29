import React, { useState } from 'react';
import axios from 'axios';
import Spinner from '../Components/Spinner';
import { useNavigate } from 'react-router-dom';

export default function RegisterMentee() {
  const navigate = useNavigate();

  const [formData, setFormData] = useState({
    name: '',
    email: '',
    phone: '',
    educationLevel: '',
    fieldOfStudy: '',
    institution: '',
    goalType: '',
    goal: '',
    interests: '',
    profilePicture: null,
  });

  const [loading, setLoading] = useState(false);
  const [preview, setPreview] = useState(null);

  const options = [
    { label: 'Name', name: 'name' },
    { label: 'Email', name: 'email' },
    { label: 'Phone', name: 'phone' },
    { label: 'Education Level', name: 'educationLevel' },
    { label: 'Field of Study', name: 'fieldOfStudy' },
    { label: 'Name of Institution', name: 'institution' },
    { label: 'Goal Type', name: 'goalType' },
    { label: 'Goal', name: 'goal' },
    { label: 'Interests (comma separated)', name: 'interests' }
  ];

  const changeHandler = (e) => {
    const { name, value, files } = e.target;

    if (name === 'profilePicture') {
      const file = files[0];
      if (file) {
        setFormData((prev) => ({ ...prev, profilePicture: file }));
        const reader = new FileReader();
        reader.onloadend = () => {
          setPreview(reader.result);
        };
        reader.readAsDataURL(file);
      }
    } else {
      setFormData((prev) => ({ ...prev, [name]: value }));
    }
  };

  const submitHandler = (event) => {
    event.preventDefault();
    setLoading(true);

    const {
      profilePicture,
      interests,
      ...rest
    } = formData;

    const menteeData = {
      ...rest,
      role: 'MENTEE',
      interests: interests
        ? interests.split(',').map((item) => item.trim())
        : [],
    };

    console.log('Submitting mentee data:', menteeData);

    let loginId;
    let loginPassword;
    let menteeId;

    axios
      .post('http://localhost:8080/users/mentee', menteeData)
      .then((response) => {
        console.log('Backend response:', response.data);
        menteeId = response.data.id;
        loginId = response.data.logInId;
        loginPassword = response.data.logInPassword;

        if (!menteeId) {
          throw new Error('Mentee ID not returned from backend.');
        }

        if (profilePicture) {
          const imageData = new FormData();
          imageData.append('file', profilePicture);

          return axios.post(
            `http://localhost:8080/users/${menteeId}/upload-image`,
            imageData,
            {
              headers: {
                'Content-Type': 'multipart/form-data',
              },
            }
          );
        }

        return Promise.resolve();
      })
      .then(() => {
        navigate('/success', {
          state: {
            loginId,
            loginPassword,
          },
        });
      })
      .catch((error) => {
        console.error('Submission Error:', error);
        alert('Something went wrong. Check the console.');
      })
      .finally(() => {
        setLoading(false);
      });
  };

  return (
    <div className="max-w-2xl mx-auto mt-10 p-6 bg-white rounded-xl shadow-md">
      <h2 className="text-2xl font-bold mb-6 text-blue-600 text-center">Register Mentee</h2>

      {loading && <Spinner />}

      <form onSubmit={submitHandler} className="space-y-4">
        {options.map(({ label, name }) => (
          <div key={name} className="flex flex-col">
            <label htmlFor={name} className="mb-1 font-medium">
              {label}
            </label>

            {name === 'educationLevel' ? (
              <select
                id={name}
                name={name}
                value={formData[name]}
                onChange={changeHandler}
                className="p-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500"
              >
                <option value="">Select Education Level</option>
                <option value="UNDERGRAD">Undergraduate</option>
                <option value="POSTGRAD">Postgraduate</option>
              </select>
            ) : name === 'goalType' ? (
              <select
                id={name}
                name={name}
                value={formData[name]}
                onChange={changeHandler}
                className="p-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500"
              >
                <option value="">Select Goal Type</option>
                <option value="SHORT_TERM">Short Term</option>
                <option value="LONG_TERM">Long Term</option>
              </select>
            ) : (
              <input
                type="text"
                id={name}
                name={name}
                value={formData[name]}
                onChange={changeHandler}
                className="p-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500"
              />
            )}
          </div>
        ))}

        <div className="flex flex-col">
          <label htmlFor="profilePicture" className="mb-1 font-medium">
            Profile Picture
          </label>
          <input
            type="file"
            name="profilePicture"
            id="profilePicture"
            accept="image/*"
            onChange={changeHandler}
            className="p-2 border border-gray-300 rounded-md"
          />
          {preview && (
            <img
              src={preview}
              alt="Preview"
              className="mt-2 w-32 h-32 object-cover rounded-full border"
            />
          )}
        </div>

        <button
          type="submit"
          className="w-full bg-blue-600 text-white py-2 rounded hover:bg-blue-700 transition"
          disabled={loading}
        >
          {loading ? 'Submitting...' : 'Submit'}
        </button>
      </form>
    </div>
  );
}
