package com.norg.task.dao;

import com.norg.task.model.Task;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Random;

/**
 * Created by pavel.krizhanovskiy on 16.08.2016.
 */
@Repository
public class TaskDaoImpl implements TaskDao {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    @Override
    public void addTask(Task task) {
        em.persist(task);
    }

    @Transactional
    @Override
    public void updateTask(Task task) {
        if (task.getId() == null) {
            this.em.persist(task);
        } else {
            this.em.merge(task);
        }
    }

    @Transactional
    @Override
    public void removeTask(Long id) {
        Task task = em.find(Task.class, id);
        if (task != null) {
            em.remove(task);
        }
    }

    @Override
    public Task getTaskById(Long id) {
        return em.find(Task.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Task> listTasks() {
        return em.createQuery(
                "SELECT task FROM tasks task ORDER BY task.taskName")
                .getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Task> filteredTasks(String type) {
        return em.createQuery(
                "SELECT task FROM tasks task WHERE task.done = :done ORDER BY task.taskName")
                .setParameter("done", type.equals("done"))
                .getResultList();
    }

    @Override
    @Transactional
    public void fillTasks() {
        Random random = new Random();
        for (int i=0; i<10; i++) {
            Task task = new Task();
            task.setDone(random.nextBoolean());
            task.setTaskName((random.nextBoolean() ? "Important " : "Useless ") + "deed #" + i);

            addTask(task);
        }
    }
}
