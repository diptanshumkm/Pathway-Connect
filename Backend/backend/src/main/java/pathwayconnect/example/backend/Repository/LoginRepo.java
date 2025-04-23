package pathwayconnect.example.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pathwayconnect.example.backend.Models.LoginCredentials;

@Repository
public interface LoginRepo extends JpaRepository <LoginCredentials, Long> {
    public boolean existsByLoginId(String loginId);

}