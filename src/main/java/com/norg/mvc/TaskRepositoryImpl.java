package com.norg.mvc;

import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by pavel.krizhanovskiy on 16.08.2016.
 */
public class TaskRepositoryImpl implements TaskRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    @Override
    public void save(Task task) throws DataAccessException {
        if (task.getId() == null) {
            this.em.persist(task);
        } else {
            this.em.merge(task);
        }
    }

    @Transactional
    @Override
    public List findById(Long id) throws DataAccessException {
        return em.createQuery(
                "SELECT task FROM tasks task WHERE task.id = :id ORDER BY task.taskName")
                .setParameter("id", id)
                .getResultList();
    }

    @Override
    public List findAll() {
        return em.createQuery("SELECT task FROM tasks task ORDER BY task.taskName").getResultList();
    }


}
