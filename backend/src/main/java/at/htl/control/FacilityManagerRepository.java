package at.htl.control;

import at.htl.entity.Building;
import at.htl.entity.FacilityManager;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class FacilityManagerRepository implements PanacheRepository<FacilityManager> {

    @Transactional
    public void create(FacilityManager facilityManager) {
        persist(facilityManager);
    }

    public List<FacilityManager> getAll() {
        return findAll().stream().collect(Collectors.toList());
    }

    public FacilityManager getFacilityManagerById(Long id) {
        return findById(id);
    }

    @Transactional
    public FacilityManager updateBuilding(FacilityManager facilityManager) {
        FacilityManager facilityManager1 = getFacilityManagerById(facilityManager.getId());
        facilityManager1.setFirstName(facilityManager.getFirstName());
        facilityManager1.setLastName(facilityManager.getLastName());
        facilityManager1.setSalary(facilityManager.getSalary());
        persist(facilityManager1);
        return facilityManager1;
    }

    @Transactional
    public void remove(FacilityManager facilityManager) {
        delete(facilityManager);
    }

}
