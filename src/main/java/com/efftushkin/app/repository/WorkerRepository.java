package com.efftushkin.app.repository;

import com.efftushkin.app.model.Worker;

import java.util.List;

public interface WorkerRepository {
    void save(Worker worker);

    Worker find(String id);

    List<Worker> findAll();

    Worker delete(String id);
}
