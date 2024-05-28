package ru.job4j.isp.employee;

public class Developer implements Employee {
    @Override
    public void prepareReport() {
        System.out.println("Developer can prepare report.");
    }

    @Override
    public void attendMeeting() {
        System.out.println("Developer can attend meeting.");
    }

    @Override
    public void analyzeCode() {
        System.out.println("Developer can analyze code.");
    }

    @Override
    public void drawChart() {
        System.out.println("Developer can draw chart.");
    }
}
