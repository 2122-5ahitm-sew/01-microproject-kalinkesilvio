package at.htl.entity;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;

@Entity
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String typeOfBuilding;
    private int surface;

    @ManyToOne
    @Cascade(CascadeType.ALL)
    private FacilityManager facilityManager;

    public Building() {
    }

    public Building(Long id, String typeOfBuilding, int surface, FacilityManager facilityManager) {
        this.id = id;
        this.typeOfBuilding = typeOfBuilding;
        this.surface = surface;
        this.facilityManager = facilityManager;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeOfBuilding() {
        return typeOfBuilding;
    }

    public void setTypeOfBuilding(String typeOfBuilding) {
        this.typeOfBuilding = typeOfBuilding;
    }

    public int getSurface() {
        return surface;
    }

    public void setSurface(int surface) {
        this.surface = surface;
    }

    public FacilityManager getFacilityManager() {
        return facilityManager;
    }

    public void setFacilityManager(FacilityManager facilityManager) {
        this.facilityManager = facilityManager;
    }

    @Override
    public String toString() {
        return String.format("%s, %s", this.typeOfBuilding, this.surface);
    }
}
