package at.htl.entity;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;

@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String usage;
    private boolean used;
    private int surface;

    @ManyToOne
    @Cascade(CascadeType.ALL)
    private Building building;

    public Room() {
    }

    public Room(Long id, String usage, boolean used, int surface) {
        this.id = id;
        this.usage = usage;
        this.used = used;
        this.surface = surface;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public int getSurface() {
        return surface;
    }

    public void setSurface(int surface) {
        this.surface = surface;
    }

    @Override
    public String toString() {
        return String.format("%s (used: %s), %d", this.usage, this.used, this.surface);
    }
}
