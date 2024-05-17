package ru.job4j.srp.report;

import ru.job4j.srp.model.Employee;
import ru.job4j.srp.store.Store;

import java.util.Comparator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class HumanResourceReport implements Report {
    private final Store store;
    private final Comparator<Employee> comparator;

    public HumanResourceReport(Store store, Comparator<Employee> comparator) {
        this.store = store;
        this.comparator = comparator;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;")
                .append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)
                .stream().sorted(comparator)
                .collect(Collectors.toList())) {
            text.append(employee.getName()).append(" ")
                    .append(employee.getSalary())
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
