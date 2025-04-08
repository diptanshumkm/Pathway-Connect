package pathwayconnect.example.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pathwayconnect.example.backend.Models.MentorTable;


@Repository
public interface MentorRepo extends JpaRepository<MentorTable, Long> {

} 
