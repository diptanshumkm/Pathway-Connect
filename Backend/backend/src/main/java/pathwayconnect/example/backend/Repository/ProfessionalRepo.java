package pathwayconnect.example.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pathwayconnect.example.backend.Models.ProfessionalDetail;

@Repository
public interface ProfessionalRepo extends JpaRepository<ProfessionalDetail, Long > {
    
} 