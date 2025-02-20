package com.example.BusinessLogic.Service;

import com.example.BusinessLogic.Entity.TaskEntity;
import com.example.BusinessLogic.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        TaskEntity taskEntity1 = taskRepository.save(taskEntity);
        return taskEntity1;
    }

    //update task
    public Optional<TaskEntity> updateTask(Long id, TaskEntity taskEntity){
        Optional<TaskEntity> optionalTaskEntity = taskRepository.findById(id);
        if(optionalTaskEntity.isPresent()){
            TaskEntity taskEntity2 = optionalTaskEntity.get();
            taskEntity2.setDate(taskEntity.getDate());
            taskEntity2.setDescription(taskEntity.getDescription());
            taskEntity2.setTitle(taskEntity.getTitle());
            taskEntity2.setCompleted(boolean t);
            TaskEntity updatedTask = taskRepository.save(taskEntity);
            return Optional.of(updatedTask);
        }
        return Optional.empty();
    }

    //deleteTask
    public String deletedTask(Long id){
        taskRepository.deleteById(id);
        return "Task con id=  " + id + "è stato cancellato";
    }
}
