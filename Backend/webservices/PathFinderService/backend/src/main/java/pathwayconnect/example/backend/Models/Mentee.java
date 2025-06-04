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

    @OneToMany(mappedBy = "mentee")
    private List<Query> query;

    
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

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }
    
    public Goals getGoal() {
        return goal;
    }
    
    public void setGoal(Goals goal) {
        this.goal = goal;
    }
    
    public MentorTable getMentor() {
        return mentor;
    }

    public void setMentor(MentorTable mentor) {
        this.mentor = mentor;
    }

    public List<String> getInterests() {
        return interests;
    }

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }

    public List<AvailabilitySlot> getAvailableSlots() {
        return availableSlots;
    }

    public void setAvailableSlots(List<AvailabilitySlot> availableSlots) {
        this.availableSlots = availableSlots;
    }

    public List<Query> getQuery(){
        return query;
    }

    public void setQuery(List<Query> query){
        this.query = query;
    }

}
