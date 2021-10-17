package at.htl.entity;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean underProcess;
    private LocalDate dateOfCompletion;

    @ManyToOne
    @Cascade(CascadeType.ALL)
    private FacilityManager facilityManager;

    @ManyToOne
    @Cascade(CascadeType.ALL)
    private Issue issue;

    public Task() {
    }

    public Task(boolean underProcess, LocalDate dateOfCompletion, FacilityManager facilityManager, Issue issue) {
        this.underProcess = underProcess;
        this.dateOfCompletion = dateOfCompletion;
        this.facilityManager = facilityManager;
        this.issue = issue;
    }

    public Long getId() {
        return id;
    }

    public boolean isUnderProcess() {
        return underProcess;
    }

    public void setUnderProcess(boolean underProcess) {
        this.underProcess = underProcess;
    }

    public LocalDate getDateOfCompletion() {
        return dateOfCompletion;
    }

    public FacilityManager getFacilityManager() {
        return facilityManager;
    }

    public void setFacilityManager(FacilityManager facilityManager) {
        this.facilityManager = facilityManager;
    }

    public Issue getIssue() {
        return issue;
    }

    public void setIssue(Issue issue) {
        this.issue = issue;
    }

    public void setDateOfCompletion(LocalDate dateOfCompletion) {
        this.dateOfCompletion = dateOfCompletion;
    }
}
