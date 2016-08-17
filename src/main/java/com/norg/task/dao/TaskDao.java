package com.norg.task.dao;

import com.norg.task.model.Task;

import java.util.List;

/**
 * Created by pavel.krizhanovskiy on 16.08.2016.
 */
public interface TaskDao {
    void addTask(Task task);
    void updateTask(Task task);
    void removeTask(Long id);
    Task getTaskById(Long id);
    List<Task> listTasks();

    List<Task> filteredTasks(String type);

    void fillTasks();
}
