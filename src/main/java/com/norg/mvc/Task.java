package com.norg.mvc;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

@Transactional
@Entity(name = "tasks")
public class Task {
    @Id
    private Long id;

    @Basic
    private Boolean done;

    @Basic
    private String taskName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String name) {
        this.taskName = name;
    }


}
