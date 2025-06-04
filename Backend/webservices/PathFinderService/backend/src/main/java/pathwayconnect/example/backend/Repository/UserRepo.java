package pathwayconnect.example.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pathwayconnect.example.backend.Models.UserTable;

@Repository
public interface UserRepo extends JpaRepository<UserTable, Long> {
    public boolean existsByEmailAndPhone(String email, String phone);
}
