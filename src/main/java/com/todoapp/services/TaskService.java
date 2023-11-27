package com.todoapp.services;

import com.todoapp.entities.Task;
import com.todoapp.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Task findById (Long id) {
        Optional<Task> obj = taskRepository.findById(id);
        return obj.get();
    }

    public Task insert (Task task) {
        return taskRepository.save(task);
    }

    public void delete (Long id) {
        taskRepository.deleteById(id);
    }

    public Task update (Long id, Task task) {
        Task entity = taskRepository.getReferenceById(id);
        updateData(entity, task);
        return taskRepository.save(entity);
    }

    private void updateData(Task entity, Task task) {
        entity.setNome(task.getNome());
        entity.setTaskStatus(task.getTaskStatus());
        entity.setDescricao(task.getDescricao());
        entity.setPriority(task.getPriority());
        entity.setDueDate(task.getDueDate());
    }


}
