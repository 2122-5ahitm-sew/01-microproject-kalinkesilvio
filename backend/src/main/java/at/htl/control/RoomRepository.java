package at.htl.control;

import at.htl.entity.Room;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
public class RoomRepository implements PanacheRepository<Room> {

    @Transactional
    public void save(Room room) {
        persist(room);
    }
}
