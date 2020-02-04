package ourbusinessproject;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class EnterpriseProjectService {

    public void save(Enterprise e) {
        entityManager.persist(e);
        entityManager.flush();
    }

    public void save(Project p) {
        entityManager.persist(p);
        entityManager.flush();
    }


    @PersistenceContext
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Project findProjectById(Long IdProject) {

        Project projet = entityManager.find(Project.class, IdProject);
        return projet;
    }

    public Enterprise findEnterpriseById(Long IdEnterprise) {
        Enterprise entreprise = entityManager.find(Enterprise.class, IdEnterprise);
        return entreprise;
    }
}
