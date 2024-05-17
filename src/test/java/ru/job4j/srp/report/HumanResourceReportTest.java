package ru.job4j.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.srp.currency.Currency;
import ru.job4j.srp.currency.CurrencyConverter;
import ru.job4j.srp.currency.InMemoryCurrencyConverter;
import ru.job4j.srp.formatter.DateTimeParser;
import ru.job4j.srp.formatter.ReportDateTimeParser;
import ru.job4j.srp.model.Employee;
import ru.job4j.srp.store.MemoryStore;

import java.util.Calendar;
import java.util.Comparator;

import static org.assertj.core.api.Assertions.*;

class HumanResourceReportTest {

    @Test
    public void whenOldGeneratedSortedBySalaryDescending() {
        MemoryStore store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Sergey", now, now, 500);
        Employee worker3 = new Employee("Dennis", now, now, 40);
        store.add(worker1);
        store.add(worker2);
        store.add(worker3);
        Report engine = new HumanResourceReport(store,
                (emp1, emp2) -> Double.compare(emp2.getSalary(), emp1.getSalary()));
        StringBuilder expected = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(worker2.getName()).append(" ")
                .append(worker2.getSalary())
                .append(System.lineSeparator())
                .append(worker1.getName()).append(" ")
                .append(worker1.getSalary())
                .append(System.lineSeparator())
                .append(worker3.getName()).append(" ")
                .append(worker3.getSalary())
                .append(System.lineSeparator());
        assertThat(engine.generate(employee -> true)).isEqualTo(expected.toString());
    }
    @Test
    public void whenOldGeneratedSortedBySalaryAscending() {
        MemoryStore store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Sergey", now, now, 500);
        Employee worker3 = new Employee("Dennis", now, now, 40);
        store.add(worker1);
        store.add(worker2);
        store.add(worker3);
        Report engine = new HumanResourceReport(store,
                Comparator.comparingDouble(Employee::getSalary));
        StringBuilder expected = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(worker3.getName()).append(" ")
                .append(worker3.getSalary())
                .append(System.lineSeparator())
                .append(worker1.getName()).append(" ")
                .append(worker1.getSalary())
                .append(System.lineSeparator())
                .append(worker2.getName()).append(" ")
                .append(worker2.getSalary())
                .append(System.lineSeparator());
        assertThat(engine.generate(employee -> true)).isEqualTo(expected.toString());
    }
}