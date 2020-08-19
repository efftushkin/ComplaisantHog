package com.efftushkin.app.view;

import com.efftushkin.app.model.Report;

public class ConsoleReportView implements ReportView {
    @Override
    public void showReport(Report report) {
        System.out.println("--------------------");
        for (Report.ReportEntry reportEntry : report.getEntries()) {
            System.out.println(String.format("%s %s %s",
                    reportEntry.getWorker().getLastName(),
                    reportEntry.getWorker().getFirstName(),
                    reportEntry.getSalary().doubleValue()));
        }
        System.out.println("--------------------");
    }
}
