package org.burenkov.task_manager.task.repository;

import org.burenkov.task_manager.task.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
