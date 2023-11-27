package com.todoapp.controllers;

import com.todoapp.entities.Task;
import com.todoapp.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping
    public ResponseEntity<List<Task>> findAll () {
        List<Task> task = taskService.findAll();
        return ResponseEntity.ok().body(task);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> findTaskById (@PathVariable Long id) {
        Task obj = taskService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Task> insert (@RequestBody Task task, UriComponentsBuilder uriBuilder) {
        task = taskService.insert(task);
        var uri =uriBuilder.path("/tasks/{id}").buildAndExpand(task.getId()).toUri();
        return ResponseEntity.created(uri).body(task);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> update (@PathVariable Long id, @RequestBody Task task) {
        task = taskService.update(id, task);
        return ResponseEntity.ok().body(task);
    }

}
