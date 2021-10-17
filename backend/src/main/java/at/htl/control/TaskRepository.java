package at.htl.control;

import at.htl.entity.Task;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
public class TaskRepository implements PanacheRepository<Task> {
    @Transactional
    public void save(Task task) {
        persist(task);
    }
}
