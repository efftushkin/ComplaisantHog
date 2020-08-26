package com.efftushkin.app.view;

import com.efftushkin.app.model.Report;
import org.springframework.stereotype.Component;

@Component
public class FormattedConsoleReportView implements ReportView {
    @Override
    public void showReport(Report report) {
        String result = generateView(report);
        System.out.println(result);
    }

    @Override
    public String generateView(Report report) {
        String result = "------------------------------------\n";
        for (Report.ReportEntry reportEntry : report.getEntries()) {
            result += String.format("%s\t%s\t%s\t%s\n",
                    reportEntry.getWorker().getLastName(),
                    reportEntry.getWorker().getFirstName(),
                    reportEntry.getDuration().toHours(),
                    reportEntry.getSalary().doubleValue());
        }
        result += "-----------------------------------";
        return result;
    }
}
