import React from 'react';
import { mentees, mentors } from '../data';
import Card from '../Components/Cards';
import LeftBar from '../Components/LeftBar';
import RightBar from '../Components/RightBar';

function Home() {
    return (
        <div className="flex flex-grow h-full">
            {/* Left Sidebar - Hidden on Small Screens */}
            <div className="hidden md:block w-1/4">
                <LeftBar />
            </div>

            {/* Main Content */}
            <div className="flex-grow p-6 overflow-auto">
                {/* Mentors section */}
                <div className="text-center">
                    <h1 className="text-3xl font-bold my-8">Find a Mentor</h1>
                    <div className="flex flex-wrap justify-center gap-8">
                        {mentors.map((mentor) => (
                            <Card {...mentor} key={mentor.id} />
                        ))}
                    </div>
                </div>

                {/* Mentees section */}
                <div className="text-center mt-12">
                    <h1 className="text-3xl font-bold my-8">Our Mentees</h1>
                    <div className="flex flex-wrap justify-center gap-8">
                        {mentees.map((mentee) => (
                            <Card {...mentee} key={mentee.id} />
                        ))}
                    </div>
                </div>
            </div>

            {/* Right Sidebar - Hidden on Small Screens */}
            <div className="hidden lg:block w-1/4">
                <RightBar />
            </div>
        </div>
    );
}

export default Home;
