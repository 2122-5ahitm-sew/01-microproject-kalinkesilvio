package at.htl.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Repair {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String typeOfRepair;
    private String description;
    private double fixingTime;

    public Repair() {
    }

    public Repair(Long id, String typeOfRepair, String description, double fixingTime) {
        this.id = id;
        this.typeOfRepair = typeOfRepair;
        this.description = description;
        this.fixingTime = fixingTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeOfRepair() {
        return typeOfRepair;
    }

    public void setTypeOfRepair(String typeOfRepair) {
        this.typeOfRepair = typeOfRepair;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getFixingTime() {
        return fixingTime;
    }

    public void setFixingTime(double fixingTime) {
        this.fixingTime = fixingTime;
    }

    @Override
    public String toString() {
        return String.format("%s (~%s): %s",
                this.typeOfRepair, this.fixingTime, this.description);
    }
}
