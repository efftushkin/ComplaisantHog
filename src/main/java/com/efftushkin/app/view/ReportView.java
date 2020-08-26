package com.efftushkin.app.view;

import com.efftushkin.app.model.Report;

public interface ReportView {
    void showReport(Report report);

    String generateView(Report report);
}
