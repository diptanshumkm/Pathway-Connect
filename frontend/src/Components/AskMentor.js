import React from 'react'
// bg-[#EAF6FD] 
export const AskMentor = () => {
  return (
    <div className='flex flex-col justify-center items-center mx-auto overflow-hidden'>

        <div className='w-[1200px] h-full border-x border-[#D3D3D3] pt-[80px]'>
            <div className='ml-12 flex flex-col gap-y-3 items-center justify-center w-[1085px] h-[50px] mt-[80px]'>
                <h1 className="text-[36px] leading-[50px] font-medium tracking-[-0.09em] text-[#272727]">
                    Ask Mentor Anything
                </h1>

                <p className="text-[16px] leading-[24px] font-normal tracking-[-0.011em] text-[#5C5C5C]">
                    Get answers from our mentors in the forum. They're here to help with your questions about your career.
                </p>
            </div>

            {/* input field */}
            <div className="w-full max-w-[900px] mx-auto mt-10 p-6 bg-white rounded-2xl shadow-sm border border-gray-200">
                <h2 className="text-xl font-semibold text-[#1C1C1C] mb-4">Ask your questions here</h2>

                <div className="flex items-center gap-4">
                    <input
                    type="text"
                    placeholder="Our mentors are here to help. Directly submit your questions or doubts to them..."
                    className="flex-grow px-4 py-3 rounded-xl border border-gray-200 text-[#5C5C5C] placeholder-[#A3A3A3] focus:outline-none focus:ring-2 focus:ring-gray-300"
                    />

                    <button className="bg-[#272727] text-white px-6 py-3 rounded-xl shadow-md hover:bg-black transition-all flex items-center gap-2">
                    Ask a question →
                    </button>
                </div>
            </div>
            

        </div>    
            
    </div>
  )
}
