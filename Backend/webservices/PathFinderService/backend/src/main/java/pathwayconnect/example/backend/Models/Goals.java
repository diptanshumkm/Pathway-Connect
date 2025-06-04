package pathwayconnect.example.backend.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "goals")
public class Goals {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "goal")
    private Mentee mentee;

    @Enumerated(EnumType.STRING)  // Store the enum as a String in DB
    private GoalType goalType;

    private String goal;

    // Default constructor
    public Goals() {}

    // All-args constructor
    public Goals(Long id, Mentee mentee, GoalType goalType, String goal) {
        this.id = id;
        this.mentee = mentee;
        this.goalType = goalType;
        this.goal = goal;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Mentee getMentee() {
        return mentee;
    }

    public void setMentee(Mentee mentee) {
        this.mentee = mentee;
    }

    public GoalType getGoalType() {
        return goalType;
    }

    public void setGoalType(GoalType goalType) {
        this.goalType = goalType;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }
}