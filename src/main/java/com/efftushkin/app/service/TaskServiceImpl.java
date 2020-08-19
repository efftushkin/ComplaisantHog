package com.efftushkin.app.service;

import com.efftushkin.app.model.Task;
import com.efftushkin.app.model.Worker;
import com.efftushkin.app.repository.TaskRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class TaskServiceImpl implements TaskService {
    private IdGenerator idGenerator = new IdGeneratorImpl();//must be singleton
    private TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(String description, LocalDateTime from, LocalDateTime to, BigDecimal price) {
        String id = idGenerator.generateId();
        Task task = new Task(id, description, from, to, price);
        saveTask(task);
        return task;
    }

    @Override
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public List<Task> findTasksAssignedToWorker(Worker worker) {
        List<Task> tasks = findAllTasks();
        return tasks
                .stream()
                .filter(task -> task.getAssignee().getId().equals(worker.getId()))
                .collect(Collectors.toList());
    }
}
