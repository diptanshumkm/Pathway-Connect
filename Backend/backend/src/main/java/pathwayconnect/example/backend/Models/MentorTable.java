package pathwayconnect.example.backend.Models;

import jakarta.persistence.*;
import java.util.List;

@Entity 
@Table(name = "mentor_table")
public class MentorTable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")  // Link Mentor to User
    private UserTable user;

    @OneToOne
    @JoinColumn(name = "professional_detail_id")
    private ProfessionalDetail professionalDetail;

    @OneToMany(mappedBy = "mentor", cascade = CascadeType.ALL)
    private List<AvailabilitySlot> availabilitySlots;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserTable getUser() {
        return user;
    }

    public void setUser(UserTable user) {
        this.user = user;
    }

    public ProfessionalDetail getProfessionalDetail() {
        return professionalDetail;
    }

    public void setProfessionalDetail(ProfessionalDetail professionalDetail) {
        this.professionalDetail = professionalDetail;
    }

    public List<AvailabilitySlot> getAvailabilitySlots() {
        return availabilitySlots;
    }

    public void setAvailabilitySlots(List<AvailabilitySlot> availabilitySlots) {
        this.availabilitySlots = availabilitySlots;
    }
}
