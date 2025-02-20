package com.example.BusinessLogic.Repository;

import com.example.BusinessLogic.Entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
}
