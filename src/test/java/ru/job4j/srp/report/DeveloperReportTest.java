package ru.job4j.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.srp.formatter.DateTimeParser;
import ru.job4j.srp.formatter.ReportDateTimeParser;
import ru.job4j.srp.model.Employee;
import ru.job4j.srp.store.MemoryStore;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;

class DeveloperReportTest {

    @Test
    void whenGenerated() {
        MemoryStore store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        String path = "src/main/java/ru/job4j/srp/report/report.csv";
        Employee worker1 = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Sergey", now, now, 500);
        Employee worker3 = new Employee("Dennis", now, now, 40);
        store.add(worker1);
        store.add(worker2);
        store.add(worker3);
        Report engine = new DeveloperReport(store, parser, path);
        StringBuilder expected = new StringBuilder()
                .append("Name;Hired;Fired;Salary")
                .append(System.lineSeparator())
                .append(worker1.getName()).append(";")
                .append(parser.parse(worker1.getHired())).append(";")
                .append(parser.parse(worker1.getFired())).append(";")
                .append(worker1.getSalary())
                .append(System.lineSeparator())
                .append(worker2.getName()).append(";")
                .append(parser.parse(worker2.getHired())).append(";")
                .append(parser.parse(worker2.getFired())).append(";")
                .append(worker2.getSalary())
                .append(System.lineSeparator())
                .append(worker3.getName()).append(";")
                .append(parser.parse(worker3.getHired())).append(";")
                .append(parser.parse(worker3.getFired())).append(";")
                .append(worker3.getSalary())
                .append(System.lineSeparator());
        assertThat(engine.generate(employee -> true)).isEqualTo(expected.toString());
    }

    @Test
    void whenErrorFileDoesNotExists() {
        MemoryStore store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        String path = "src/main/java/ru/job4j/srp/report/repor.csv";
        Employee worker1 = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Sergey", now, now, 500);
        Employee worker3 = new Employee("Dennis", now, now, 40);
        store.add(worker1);
        store.add(worker2);
        store.add(worker3);
        Report engine = new DeveloperReport(store, parser, path);
        assertThatThrownBy(() -> engine.generate(employee -> true))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("The file does not exist");
    }

    @Test
    void whenErrorItIsNotAFile() {
        MemoryStore store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        String path = "src/main/java/ru/job4j/srp/report";
        Employee worker1 = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Sergey", now, now, 500);
        Employee worker3 = new Employee("Dennis", now, now, 40);
        store.add(worker1);
        store.add(worker2);
        store.add(worker3);
        Report engine = new DeveloperReport(store, parser, path);
        assertThatThrownBy(() -> engine.generate(employee -> true))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("The file is not a file");
    }
}