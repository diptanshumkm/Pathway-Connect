import React from 'react';
import { mentees, mentors } from '../data';
import Card from '../Components/Cards';
import LeftBar from '../Components/LeftBar';
import RightBar from '../Components/RightBar';
import { HeroSection } from '../Components/HeroSection';
import { AskMentor } from '../Components/AskMentor';

function Home() {
    return ( 
        
        <div className= " w-full min-h-screen overflow-x-hidden">
            <div className='border-x border-[#D3D3D3]'>
                <HeroSection />
            </div>

            <div>
                <AskMentor />
            </div>

        </div>
        
    );
}

export default Home;
