package com.example.BusinessLogic.Controller;

import com.example.BusinessLogic.Entity.TaskEntity;
import com.example.BusinessLogic.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    //CREATE
    @PostMapping("/create-Task")
    public ResponseEntity<TaskEntity> taskCreatiom(@RequestBody TaskEntity taskEntity) {
        TaskEntity taskEntity1 = taskService.addTask(taskEntity);
        return ResponseEntity.ok(taskEntity1);
    }
}
