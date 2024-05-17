package ru.job4j.srp.report;

import ru.job4j.srp.formatter.DateTimeParser;
import ru.job4j.srp.model.Employee;
import ru.job4j.srp.store.Store;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.Calendar;
import java.util.function.Predicate;

public class DeveloperReport implements Report {
    private final Store store;
    private final DateTimeParser<Calendar> dateTimeParser;
    private final String path;


    public DeveloperReport(Store store, DateTimeParser<Calendar> dateTimeParser, String path) {
        this.store = store;
        this.dateTimeParser = dateTimeParser;
        this.path = path;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(validatePath(path).toFile()))) {
            text.append("Name;Hired;Fired;Salary")
                    .append(System.lineSeparator());
            for (Employee employee : store.findBy(filter)) {
                text.append(employee.getName()).append(";")
                        .append(dateTimeParser.parse(employee.getHired())).append(";")
                        .append(dateTimeParser.parse(employee.getFired())).append(";")
                        .append(employee.getSalary())
                        .append(System.lineSeparator());
            }
            writer.println(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text.toString();
    }

    private Path validatePath(String path) {
        Path start = Path.of(path);
        if (!start.toFile().exists()) {
            throw new IllegalArgumentException("The file does not exist");
        }
        if (!start.toFile().isFile()) {
            throw new IllegalArgumentException("The file is not a file");
        }
        return start;
    }
}
