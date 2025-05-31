package pathwayconnect.example.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pathwayconnect.example.backend.Models.Mentee;
import pathwayconnect.example.backend.Models.UserTable;

@Repository
public interface MenteeRepo extends JpaRepository<Mentee, Long> {
    public Mentee findMenteeByUser(UserTable user);
}
