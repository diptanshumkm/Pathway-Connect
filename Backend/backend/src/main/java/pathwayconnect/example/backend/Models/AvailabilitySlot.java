package pathwayconnect.example.backend.Models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "availability_slot")
public class AvailabilitySlot {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String day;
    private String date;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @ManyToOne
    @JoinColumn(name = "mentor_id")
    private MentorTable mentor;
    
    public AvailabilitySlot() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public MentorTable getMentor() {
        return mentor;
    }

    public void setMentor(MentorTable mentor) {
        this.mentor = mentor;
    }
}
