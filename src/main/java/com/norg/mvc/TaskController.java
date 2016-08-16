package com.norg.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TaskController {
    @Autowired
    private TaskRepository taskRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listTasks(ModelMap model) {
        model.addAttribute("task", new Task());
        model.addAttribute("tasks", taskRepository.findAll());

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Task task = (Task) context.getBean("Task");
        return "tasks";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addTask(@ModelAttribute("task") Task task, BindingResult result) {
        taskRepository.save(task);
        return "redirect:/";
    }

    @RequestMapping("/delete/{taskId}")
    public String deleteUser(@PathVariable("taskId") Long taskId) {
        taskRepository.delete(taskRepository.findById(taskId));
        return "redirect:/";
    }

    @RequestMapping("/edit/{taskId}")
    public String editUser(@PathVariable("taskId") Long taskId) {
        taskRepository.delete(taskRepository.findById(taskId));
        return "redirect:/";
    }
}
