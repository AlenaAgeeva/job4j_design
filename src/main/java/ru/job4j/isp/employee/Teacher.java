package ru.job4j.isp.employee;

public class Teacher implements Employee {
    @Override
    public void prepareReport() {
        System.out.println("Teacher can prepare report.");
    }

    @Override
    public void attendMeeting() {
        System.out.println("Teacher can attend meeting.");
    }

    @Override
    public void analyzeCode() {
        try {
            throw new Exception("Teacher cannot analyze code.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void drawChart() {
        System.out.println("Teacher can draw chart.");
    }
}
