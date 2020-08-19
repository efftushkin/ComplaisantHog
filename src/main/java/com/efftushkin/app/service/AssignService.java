package com.efftushkin.app.service;

import com.efftushkin.app.model.Task;
import com.efftushkin.app.model.Worker;

public interface AssignService {
    Task assignTask(Worker worker, Task task);
}
