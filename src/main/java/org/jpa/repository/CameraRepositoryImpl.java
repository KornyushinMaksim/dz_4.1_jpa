package org.jpa.repository;

import org.jpa.enums.Processor;
import org.jpa.model.Camera;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class CameraRepositoryImpl implements CameraRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addCamera(Camera camera) {
        entityManager.persist(camera);
    }

    @Override
    public void deleteCamera(Camera camera) {
        entityManager.remove(camera);
    }

    @Override
    public void updateCamera(Camera camera) {
        entityManager.merge(camera);
        entityManager.detach(camera);
    }

    @Override
    public Optional<Camera> getCameraById(UUID id) {
        return Optional.ofNullable(entityManager.find(Camera.class, id));
    }

    @Override
    public List<Camera> getCameraByProcessor(Processor processor) {

        String jpql = "FROM Camera WHERE processor = :processor";

        TypedQuery<Camera> query = entityManager.createQuery(jpql, Camera.class);
        query.setParameter("processor", processor);

        return query.getResultList();
    }

    @Override
    public List<Camera> getAllCamera() {

        String jpql = "FROM Camera";

        TypedQuery<Camera> query = entityManager.createQuery(jpql, Camera.class);

        return query.getResultList();
    }
}
