package com.efftushkin.app.view;

import com.efftushkin.app.model.Report;

public class ConsoleReportView implements ReportView {
    @Override
    public void showReport(Report report) {
        System.out.println(generateView(report));
    }

    @Override
    public String generateView(Report report) {
        String result = "";
        for (Report.ReportEntry reportEntry : report.getEntries()) {
            result += reportEntry.getWorker().getLastName() + "\n";
        }
        return result;
    }
}
