package com.norg.task.service;

import com.norg.task.dao.TaskDao;
import com.norg.task.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by pavel.krizhanovskiy on 16.08.2016.
 */
@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskDao taskDao;

    public void setTaskDao(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    @Override
    @Transactional
    public void addTask(Task task) {
        taskDao.addTask(task);
    }

    @Override
    @Transactional
    public void updateTask(Task task) {
        taskDao.updateTask(task);
    }

    @Override
    @Transactional
    public void removeTask(Long id) {
        taskDao.removeTask(id);
    }

    @Override
    public Task getTaskById(Long id) {
        return taskDao.getTaskById(id);
    }

    @Override
    public List<Task> listTasks() {
        return taskDao.listTasks();
    }

    @Override
    public List<Task> filteredTasks(String type) {
        return taskDao.filteredTasks(type);
    }

    @Override
    @Transactional
    public void fillTasks() {
        taskDao.fillTasks();
    }
}
