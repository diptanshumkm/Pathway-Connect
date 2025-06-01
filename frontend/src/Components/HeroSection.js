import React from 'react'

export const HeroSection = () => {
  return (
      <div className="flex flex-col justify-center items-center border-x border-[#D3D3D3]">
        {/* upper section */}
        <div className="w-full max-w-[1200px] mx-auto pt-[160px] text-center border-x border-[#D3D3D3]">
          <h1 className="text-[60px] leading-[48px] font-medium tracking-[-3px] text-[#272727]">
            Supercharge your career with
          </h1>
          <h1 className="text-[60px] leading-[72px] font-bold tracking-[-1.36px] text-[#007AFF]">
            Long Term Mentorship
          </h1>
          <h1 className="text-[18px] leading-[24px] font-normal tracking-[-0.2px] text-[#5C5C5C] mt-[20px]">
            Land your dream job, role, and company faster than ever with 1:1 long term mentorship.
          </h1>
        </div>

        {/* lower section */}
        <div className="pt-[48px]  w-full max-w-[1200px] mx-auto border-x border-[#D3D3D3]">
          <div className="flex justify-center items-center gap-x-6 flex-wrap">
            <button className="bg-white w-[142.725px] h-[44px] rounded-[8px] font-medium text-[#000000] border-b-2">
              Book a free trial
            </button>
            <button className="w-[154.05px] h-[44px] rounded-[8px] text-white text-[14px] font-medium bg-[#272727]">
              Find your mentor
            </button>
          </div>
        </div>
      </div>
  
    
  )
}
