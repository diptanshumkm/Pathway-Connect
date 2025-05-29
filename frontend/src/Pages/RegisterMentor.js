import React, { useState } from 'react';
import axios from 'axios';
import Spinner from '../Components/Spinner';
import { useNavigate } from 'react-router-dom';


export default function RegisterMentor() {
  const navigate = useNavigate();

  const options = [
    { label: "Name", name: "name" },
    { label: "Email", name: "email" },
    { label: "Phone", name: "phone" },
    { label: "Education", name: "education" },
    { label: "Years of Experience", name: "yearsOfExperience" },
    { label: "Current Company", name: "currentCompany" },
    { label: "Past Companies", name: "pastCompanies" }
  ];

  const [formData, setFormData] = useState({
    name: "",
    email: "",
    phone: "",
    profilePicture: null,
    education: "",
    yearsOfExperience: "",
    currentCompany: "",
    pastCompanies: ""
  });

  const [preview, setPreview] = useState(null);
  const [loading, setLoading] = useState(false);

  const changeHandler = (event) => {
    const { name, value, type, files } = event.target;
    if (type === "file") {
      setFormData((prevData) => ({
        ...prevData,
        [name]: files[0]
      }));
      setPreview(URL.createObjectURL(files[0]));
    } else {
      setFormData((prevData) => ({
        ...prevData,
        [name]: value
      }));
    }
  };

  function submitHandler(event) {
    event.preventDefault();
    setLoading(true);

    const {
      profilePicture,
      yearsOfExperience,
      pastCompanies,
      ...rest
    } = formData;

    const mentorData = {
      ...rest,
      role: "MENTOR", // hardcoded role
      yearsOfExperience: yearsOfExperience ? parseInt(yearsOfExperience, 10) : 0,
      pastCompanies: pastCompanies
        ? pastCompanies.split(",").map((company) => company.trim())
        : [],
    };
    console.log("Submitting mentor data:", mentorData);

    // -------------------------------------------------------------------------------------------------
    let loginId;
    let loginPassword;
    // Step 1: Submit mentor data
    axios
      .post("http://localhost:8080/users/mentor", mentorData)
      .then((response) => {
        console.log("Backend response:", response.data);
        const mentorId = response.data.id;
        loginId = response.data.logInId;
        loginPassword = response.data.logInPassword;


        if (!mentorId) {
          throw new Error("Mentor ID not returned from backend.");
        }

        // Step 2: Upload image if exists
        if (profilePicture) {
          const imageData = new FormData();
          imageData.append("file", profilePicture);

          return axios.post(
            `http://localhost:8080/users/${mentorId}/upload-image`,
            imageData,
            {
              headers: {
                "Content-Type": "multipart/form-data",
              },
            }
          )

        }

        return Promise.resolve();
      })
      .then(() => {
        navigate("/success", {
          state: {
            loginId,
            loginPassword
          }});
        // alert("Mentor registered successfully!");
      })
      .catch((error) => {
        console.error("Submission Error: ", error);
        alert("Something went wrong. Check the console.");
      })
      .finally(() => {
        setLoading(false);
      });
  }

  return (
    <div className="max-w-2xl mx-auto mt-10 p-6 bg-white rounded-xl shadow-md">
      <h2 className="text-2xl font-bold mb-6 text-blue-600 text-center">Register Mentor</h2>

      {loading && <Spinner />}

      <form onSubmit={submitHandler} className="space-y-4">
        {options.map(({ label, name }) => (
          <div key={name} className="flex flex-col">
            <label htmlFor={name} className="mb-1 font-medium">{label}</label>
            <input
              type="text"
              id={name}
              name={name}
              value={formData[name]}
              onChange={changeHandler}
              className="p-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500"
            />
          </div>
        ))}

        <div className="flex flex-col">
          <label htmlFor="profilePicture" className="mb-1 font-medium">Profile Picture</label>
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
          {loading ? "Submitting..." : "Submit"}
        </button>
      </form>
    </div>
  );
}