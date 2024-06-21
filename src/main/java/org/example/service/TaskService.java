package org.example.service;


import org.example.entity.Status;
import org.example.entity.Tasks;
import org.example.repository.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TasksRepository tasksRepository;

    public List<Tasks> findAll() {
        return tasksRepository.findAll();
    }

    public List<Tasks> findByStatus(Status status) {
        return tasksRepository.findByStatus(status);
    }

    public Tasks findById(Long id) {
        return tasksRepository.findById(id).get();
    }

    public void delete(Long id){
        tasksRepository.deleteById(id);
    }

    public Tasks save(Tasks tasks) {
        return tasksRepository.save(tasks);
    }


}
