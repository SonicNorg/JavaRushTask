package com.norg.task.controller;

import com.norg.task.model.Task;
import com.norg.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by pavel.krizhanovskiy on 16.08.2016.
 */
@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listTasks(Model model) {
        model.addAttribute("task", new Task());
        model.addAttribute("tasks", taskService.listTasks());
        return "tasks";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addTask(@ModelAttribute("task") Task task) {
        if (task.getId() == null) {
            taskService.addTask(task);
        } else {
            taskService.updateTask(task);
        }
        return "redirect:/";
    }

    @RequestMapping("/remove/{id}")
    public String removeTask(@PathVariable("id") Long id) {
        taskService.removeTask(id);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public String editTask(@PathVariable("id") Long id, Model model) {
        model.addAttribute("task", taskService.getTaskById(id));
        model.addAttribute("tasks", taskService.listTasks());

        return "tasks";
    }
}
