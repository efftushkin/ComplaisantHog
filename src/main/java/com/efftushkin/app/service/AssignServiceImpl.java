package com.efftushkin.app.service;

import com.efftushkin.app.model.Task;
import com.efftushkin.app.model.Worker;

public class AssignServiceImpl implements AssignService {
    private TaskService taskService;

    public AssignServiceImpl(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public Task assignTask(Worker worker, Task task) {
        task.setAssignee(worker);
        return taskService.saveTask(task);
    }
}
