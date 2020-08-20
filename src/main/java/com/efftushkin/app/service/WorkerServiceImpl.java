package com.efftushkin.app.service;

import com.efftushkin.app.model.Worker;
import com.efftushkin.app.repository.WorkerRepository;

import java.util.List;
import java.util.Optional;

public class WorkerServiceImpl implements WorkerService {
    private IdGenerator idGenerator;
    private WorkerRepository workerRepository;

    public WorkerServiceImpl(IdGenerator idGenerator, WorkerRepository workerRepository) {
        this.idGenerator = idGenerator;
        this.workerRepository = workerRepository;
    }

    @Override
    public Worker createWorker(String firstName, String lastName) {
        String id = idGenerator.generateId();

        Worker worker = new Worker(id, firstName, lastName);

        workerRepository.save(worker);
        return worker;
    }

    @Override
    public Worker findWorkerByFirstNameAndLastName(String firstName, String lastName) {
        List<Worker> workers = workerRepository.findAll();
        Optional<Worker> worker = workers
                .stream()
                .filter(wor -> wor.getFirstName().equals(firstName)
                        && wor.getLastName().equals(lastName))
                .findFirst();

        return worker.orElse(null);

    }

    @Override
    public List<Worker> findAll() {
        return workerRepository.findAll();
    }
}
