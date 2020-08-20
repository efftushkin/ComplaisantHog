package com.efftushkin.app;

import com.efftushkin.app.model.Report;
import com.efftushkin.app.model.Task;
import com.efftushkin.app.model.Worker;
import com.efftushkin.app.service.AssignService;
import com.efftushkin.app.service.ReportGenerationService;
import com.efftushkin.app.service.TaskService;
import com.efftushkin.app.service.WorkerService;
import com.efftushkin.app.view.ReportView;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class DemoPreparator implements ApplicationListener<ContextRefreshedEvent> {
    private final WorkerService workerService;
    private final TaskService taskService;
    private final AssignService assignService;
    private final ReportGenerationService reportGenerationService;
    private final ReportView reportView;

    public DemoPreparator(WorkerService workerService, TaskService taskService, AssignService assignService, ReportGenerationService reportGenerationService, ReportView reportView) {
        this.workerService = workerService;
        this.taskService = taskService;
        this.assignService = assignService;
        this.reportGenerationService = reportGenerationService;
        this.reportView = reportView;
    }

    public void prepareDemoData() {
        createTestWorkers(workerService);
        createTestTasks(taskService);
        assignTasks(taskService, workerService, assignService);
        Report report = generateReport(reportGenerationService);
        showReport(report, reportView);
    }

    private Report generateReport(ReportGenerationService reportGenerationService) {
        return reportGenerationService.generateReport();
    }

    private void showReport(Report report, ReportView reportView) {
        reportView.showReport(report);
    }

    private void assignTasks(TaskService taskService, WorkerService workerService, AssignService assignService) {
        List<Task> tasks = taskService.findAllTasks();
        List<Worker> workers = workerService.findAll();
        assignService.assignTask(workers.get(0), tasks.get(0));
        assignService.assignTask(workers.get(0), tasks.get(1));
        assignService.assignTask(workers.get(1), tasks.get(2));
        assignService.assignTask(workers.get(2), tasks.get(3));
    }

    private void createTestWorkers(WorkerService workerService) {
        workerService.createWorker("Lena", "Lenova");
        workerService.createWorker("Ivan", "Ivanov");
        workerService.createWorker("Petr", "Petrov");
        workerService.createWorker("Alla", "Lazy");
    }

    private void createTestTasks(TaskService taskService) {
        taskService.createTask("Clean room",
                LocalDateTime.of(2017, 2, 22, 12, 0),
                LocalDateTime.of(2017, 2, 22, 16, 0),
                BigDecimal.valueOf(100.0));
        taskService.createTask("Cook dish",
                LocalDateTime.of(2017, 2, 10, 8, 0),
                LocalDateTime.of(2017, 2, 10, 15, 0),
                BigDecimal.valueOf(300.0));

        taskService.createTask("Teach piano playing",
                LocalDateTime.of(2017, 2, 22, 8, 0),
                LocalDateTime.of(2017, 2, 22, 9, 0),
                BigDecimal.valueOf(150.0));

        taskService.createTask("Fix bicycle",
                LocalDateTime.of(2017, 2, 19, 8, 0),
                LocalDateTime.of(2017, 2, 19, 18, 0),
                BigDecimal.valueOf(801.0));
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        prepareDemoData();
    }
}
