package com.efftushkin.app.service;

import com.efftushkin.app.model.Task;
import com.efftushkin.app.model.Worker;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface TaskService {
    Task createTask(String description, LocalDateTime from, LocalDateTime to, BigDecimal price);

    Task saveTask(Task task);

    List<Task> findAllTasks();

    List<Task> findTasksAssignedToWorker(Worker worker);
}
