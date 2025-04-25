package pathwayconnect.example.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pathwayconnect.example.backend.Models.LoginCredentials;
import pathwayconnect.example.backend.Models.UserTable;

@Repository
public interface LoginRepo extends JpaRepository <LoginCredentials, Long> {
    public LoginCredentials findByLoginIdAndLoginPassword(String loginId, String loginPassword);
    public boolean existsByLoginId(String loginId);
    public boolean existsByLoginPassword(String loginPassword);
    public UserTable findUserByLoginId(String loginId);
}