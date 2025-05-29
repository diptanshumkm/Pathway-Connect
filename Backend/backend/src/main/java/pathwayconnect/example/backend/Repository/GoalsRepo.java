package pathwayconnect.example.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pathwayconnect.example.backend.Models.Goals;

@Repository
public interface GoalsRepo extends JpaRepository<Goals, Long>{
    
}
