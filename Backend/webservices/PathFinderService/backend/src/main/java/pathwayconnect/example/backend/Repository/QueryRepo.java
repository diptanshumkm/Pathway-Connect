package pathwayconnect.example.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pathwayconnect.example.backend.Models.Query;

@Repository
public interface QueryRepo extends JpaRepository<Long, Query> {
  
} 