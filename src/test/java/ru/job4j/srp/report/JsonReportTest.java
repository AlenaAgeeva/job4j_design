package ru.job4j.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.srp.formatter.ReportDateTimeParser;
import ru.job4j.srp.model.Employee;
import ru.job4j.srp.store.MemoryStore;

import javax.xml.bind.JAXBException;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.assertj.core.api.Assertions.*;

class JsonReportTest {

    @Test
    void whenAccountantsGeneratedForTwo() throws JAXBException {
        MemoryStore store = new MemoryStore();
        Employee employee = new Employee("John Doe",
                new GregorianCalendar(2023, Calendar.JUNE, 8, 17, 41),
                new GregorianCalendar(2023, Calendar.JUNE, 8, 17, 41),
                5000.0);
        Employee employee1 = new Employee("Jane Smith",
                new GregorianCalendar(2023, Calendar.JUNE, 8, 17, 41),
                new GregorianCalendar(2023, Calendar.JUNE, 8, 17, 41),
                6000.0);
        store.add(employee);
        store.add(employee1);
        Report engine = new JsonReport(store, new ReportDateTimeParser());
        String ex = """
                [
                  {
                    "name": "John Doe",
                    "hired": "08:06:2023 17:41",
                    "fired": "08:06:2023 17:41",
                    "salary": 5000.0
                  },
                  {
                    "name": "Jane Smith",
                    "hired": "08:06:2023 17:41",
                    "fired": "08:06:2023 17:41",
                    "salary": 6000.0
                  }
                ]""";
        assertThat(engine.generate(em -> true)).isEqualTo(ex);
    }
    @Test
    void whenAccountantsGeneratedForThree() throws JAXBException {
        MemoryStore store = new MemoryStore();
        Employee employee = new Employee("John Doe",
                new GregorianCalendar(2023, Calendar.JUNE, 8, 17, 41),
                new GregorianCalendar(2023, Calendar.JUNE, 8, 17, 41),
                5000.0);
        Employee employee1 = new Employee("Jane Smith",
                new GregorianCalendar(2023, Calendar.JUNE, 8, 17, 41),
                new GregorianCalendar(2023, Calendar.JUNE, 8, 17, 41),
                6000.0);
        Employee employee3 = new Employee("Oleg Belov",
                new GregorianCalendar(2020, Calendar.JANUARY, 2, 17, 12),
                new GregorianCalendar(2020, Calendar.APRIL, 12, 17, 41),
                7000.0);
        store.add(employee);
        store.add(employee1);
        store.add(employee3);
        Report engine = new JsonReport(store, new ReportDateTimeParser());
        String ex = """
                [
                  {
                    "name": "John Doe",
                    "hired": "08:06:2023 17:41",
                    "fired": "08:06:2023 17:41",
                    "salary": 5000.0
                  },
                  {
                    "name": "Jane Smith",
                    "hired": "08:06:2023 17:41",
                    "fired": "08:06:2023 17:41",
                    "salary": 6000.0
                  },
                  {
                    "name": "Oleg Belov",
                    "hired": "02:01:2020 17:12",
                    "fired": "12:04:2020 17:41",
                    "salary": 7000.0
                  }
                ]""";
        assertThat(engine.generate(em -> true)).isEqualTo(ex);
    }
}