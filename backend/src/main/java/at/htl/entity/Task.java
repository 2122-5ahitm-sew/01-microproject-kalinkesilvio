package at.htl.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean underProcess;
    private LocalDate dateOfCompletion;

    public Task() {
    }

    public Task(boolean underProcess, LocalDate dateOfCompletion) {
        this.underProcess = underProcess;
        this.dateOfCompletion = dateOfCompletion;
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

    public void setDateOfCompletion(LocalDate dateOfCompletion) {
        this.dateOfCompletion = dateOfCompletion;
    }
}
