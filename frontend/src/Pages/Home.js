import React from 'react';
import { mentees, mentors } from '../data';
import Card from '../Components/Cards';

function Home() {
    return (
        <div className="p-6">
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
    );
}

export default Home;
