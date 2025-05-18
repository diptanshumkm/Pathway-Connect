package pathwayconnect.example.backend.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "goals_table")
public class UserProfile {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", nullable = false, length = 50)
    private String fullName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "bio", nullable = false, length = 50)
    private String bio;

    
    @Column(name = "bio", nullable = false, length = 50)
    private String phoneNumber;

}