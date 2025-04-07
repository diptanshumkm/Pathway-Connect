package pathwayconnect.example.backend.Models;

import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "professional_table")
public class ProfessionalDetail {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String education;
    private int yearOfExperience;
    private String currentCompany;

    @ElementCollection
    @CollectionTable(name = "past_companies", joinColumns = @JoinColumn(name = "professional_id"))
    @Column(name = "company_name", nullable = false)
    private List<String> pastCompanies;

    @OneToOne(mappedBy = "professionalDetail", cascade = CascadeType.ALL)
    private MentorTable mentor;

    public ProfessionalDetail() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public int getYearOfExperience() {
        return yearOfExperience;
    }

    public void setYearOfExperience(int yearOfExperience) {
        this.yearOfExperience = yearOfExperience;
    }

    public String getCurrentCompany() {
        return currentCompany;
    }

    public void setCurrentCompany(String currentCompany) {
        this.currentCompany = currentCompany;
    }

    public List<String> getPastCompanies() {
        return pastCompanies;
    }

    public void setPastCompanies(List<String> pastCompanies) {
        this.pastCompanies = pastCompanies;
    }

    public MentorTable getMentor() {
        return mentor;
    }

    public void setMentor(MentorTable mentor) {
        this.mentor = mentor;
    }
}
