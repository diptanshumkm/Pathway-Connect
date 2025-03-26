import React, { useState } from "react";

function RightBar() {
    const [selected, setSelected] = useState(null);

    const options = [
        "AI based resume review",
        "Recorded Courses"
    ];

    return (
        <div className="fixed top-[52px] right-0 h-[calc(100vh-52px)] w-56 bg-gradient-to-b from-gray-900 to-gray-700 shadow-lg p-4 overflow-y-auto">
            <ul>
                {options.map((option, index) => (
                    <li
                        key={index}
                        className={`cursor-pointer p-3 rounded-lg text-white text-sm font-medium 
                        ${selected === index ? "bg-blue-500" : "hover:bg-gray-600"}`}
                        onClick={() => setSelected(index)}
                    >
                        {option}
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default RightBar;
