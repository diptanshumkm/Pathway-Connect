package pathwayconnect.example.backend.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "rating_review_table")
public class RatingAndReview {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int rating;

    private String review;
    
    @ManyToOne
    @JoinColumn(name = "mentor_id", nullable = false)
    private MentorTable mentor;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserTable user;

    public RatingAndReview() {}

    public RatingAndReview(int rating, String review, MentorTable mentor, UserTable user) {
        this.rating = rating;
        this.review = review;
        this.mentor = mentor;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        if (rating < 1 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5");
        }
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public MentorTable getMentor() {
        return mentor;
    }

    public void setMentor(MentorTable mentor) {
        this.mentor = mentor;
    }

    public UserTable getUser() {
        return user;
    }

    public void setUser(UserTable user) {
        this.user = user;
    }
}
