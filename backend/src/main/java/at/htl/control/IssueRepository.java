package at.htl.control;

import at.htl.entity.Issue;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
public class IssueRepository implements PanacheRepository<Issue> {

    @Transactional
    public void save(Issue issue) {
        persist(issue);
    }
}
