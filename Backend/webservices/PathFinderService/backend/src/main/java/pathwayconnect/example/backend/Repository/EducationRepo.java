package pathwayconnect.example.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pathwayconnect.example.backend.Models.Education;

@Repository
public interface EducationRepo extends JpaRepository<Education, Long>{

} 