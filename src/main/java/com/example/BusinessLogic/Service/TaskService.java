package com.example.BusinessLogic.Service;

import com.example.BusinessLogic.Entity.TaskEntity;
import com.example.BusinessLogic.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepository;

    //get all tasks
    public ArrayList<TaskEntity> getAllTasks(){
        List<TaskEntity> taskServiceList = taskRepository.findAll();
        return new ArrayList<>(taskServiceList);
    }

    //add task
    public TaskEntity addTask(TaskEntity taskEntity){
        return taskRepository.save(taskEntity);
    }

    //update task
    public Optional<TaskEntity> updateTask(Long id, TaskEntity taskEntity){
        Optional<TaskEntity> optionalTaskEntity = taskRepository.findById(id);
        if(optionalTaskEntity.isPresent()){
            if(optionalTaskEntity.get().isCompleted())
                optionalTaskEntity.get().setCompleted(true);
            TaskEntity updatedTask = taskRepository.save(taskEntity);
            return Optional.of(updatedTask);
        }
        return Optional.empty();
    }

    //deleteTask
    public void deletedTask(Long id){
        taskRepository.deleteById(id);
    }

    //find by id
    public Optional<TaskEntity> findById (Long id) {
        return taskRepository.findById(id);
    }


    public long calculateTimeRemaining(TaskEntity task) {
        LocalDate dueDate = task.getDueDate();
        LocalDate currentDate = LocalDate.now();
        if (dueDate.isBefore(currentDate)) {
            return 0; // Il compito è scaduto
        } else {
            return ChronoUnit.DAYS.between(currentDate, dueDate);
        }
    }



}
