package com.norg.mvc;

import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TaskRepository {

    @Transactional
    void save(Task task) throws DataAccessException;

    List findById(Long id) throws  DataAccessException;

    List findAll();
}