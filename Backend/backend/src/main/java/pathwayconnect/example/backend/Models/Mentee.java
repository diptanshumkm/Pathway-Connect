package pathwayconnect.example.backend.Models;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "mentee_table")
public class Mentee {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserTable user;

    @OneToOne
    @JoinColumn(name = "education_id")
    private Education education;

    @OneToOne
    @JoinColumn(name = "goal_id")
    private Goals goal;

    @OneToOne
    @JoinColumn(name = "mentors_id")
    private MentorTable mentor;

    @ElementCollection
    @CollectionTable(name = "interests_table", joinColumns = @JoinColumn(name = "mentee_id"))
    @Column(name = "interests", nullable = false)
    private List<String> interests;

    @OneToMany
    @JoinColumn(name = "mentee_id")
    private List<AvailabilitySlot> availableSlots;




}
