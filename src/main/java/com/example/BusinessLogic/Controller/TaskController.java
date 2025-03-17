package com.example.BusinessLogic.Controller;

import com.example.BusinessLogic.Entity.TaskEntity;
import com.example.BusinessLogic.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    //CREATE
    @PostMapping("/create")
    public ResponseEntity<TaskEntity> taskCreatiom(@RequestBody TaskEntity taskEntity) {
        TaskEntity taskEntity1 = taskService.addTask(taskEntity);
        return ResponseEntity.ok(taskEntity1);
    }

    @GetMapping("/select-all")
    public ResponseEntity<ArrayList<TaskEntity>> taskList() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @PutMapping("/update")
    public ResponseEntity<TaskEntity> updateTask(@RequestBody TaskEntity taskEntity, @PathVariable Long id) {
        //prendo l'optional e lo imposto con i nuovi valori
        Optional<TaskEntity> taskEntityOptional = taskService.updateTask(id, taskEntity);
        //se optional è presente
        if (taskEntityOptional.isPresent()) {
            //ritorniamo ResponseEntity.ok
            return ResponseEntity.ok(taskEntityOptional.get());
        }//altrimenti se l'oggetto da aggiornare non è presente ritorno not found.build
        return ResponseEntity.notFound().build();
    }

    // Delete by ID
    @DeleteMapping("delete")
    public ResponseEntity<String> deleteTask(@RequestParam Long id) {
        Optional<TaskEntity> taskEntity = taskService.findById(id);
        if (taskEntity.isPresent()) {
            taskService.deletedTask(id);
            return ResponseEntity.ok("Task deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task not found.");
        }
    }


}
