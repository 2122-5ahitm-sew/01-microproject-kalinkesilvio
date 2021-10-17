package at.htl.control;

import at.htl.entity.Building;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class BuildingRepository implements PanacheRepository<Building> {

    @Transactional
    public void save(Building building) {
        persist(building);
    }

    public List<Building> getAll() {
        return findAll().stream().collect(Collectors.toList());
    }

    public Building getBuildingById(Long id) {
        return findById(id);
    }

    @Transactional
    public Building updateBuilding(Building newBuilding) {
        Building building1 = getBuildingById(newBuilding.getId());
        building1.setTypeOfBuilding(newBuilding.getTypeOfBuilding());
        building1.setFacilityManager(newBuilding.getFacilityManager());
        building1.setSurface(newBuilding.getSurface());
        persist(building1);
        return building1;
    }

    @Transactional
    public void remove(Building building) {
        delete(building);
    }
}
