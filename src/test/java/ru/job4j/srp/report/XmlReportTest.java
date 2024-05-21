package ru.job4j.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.srp.model.Employee;
import ru.job4j.srp.store.MemoryStore;

import javax.xml.bind.JAXBException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.assertj.core.api.Assertions.assertThat;

class XmlReportTest {

    @Test
    void whenGeneratedTwo() throws JAXBException {
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
        Report report = new XmlReport(store);
        String expect = """
                <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
                <employees>
                    <employee>
                        <name>John Doe</name>
                        <hired>08:06:2023 17:41</hired>
                        <fired>08:06:2023 17:41</fired>
                        <salary>5000.0</salary>
                    </employee>
                    <employee>
                        <name>Jane Smith</name>
                        <hired>08:06:2023 17:41</hired>
                        <fired>08:06:2023 17:41</fired>
                        <salary>6000.0</salary>
                    </employee>
                </employees>
                """;
        assertThat(report.generate(em -> true)).isEqualTo(expect);
    }

    @Test
    void whenGeneratedThree() throws JAXBException {
        MemoryStore store = new MemoryStore();
        Employee employee1 = new Employee("John Doe",
                new GregorianCalendar(2023, Calendar.JUNE, 8, 17, 41),
                new GregorianCalendar(2023, Calendar.JUNE, 8, 17, 41),
                5000.0);
        Employee employee2 = new Employee("Jane Smith",
                new GregorianCalendar(2023, Calendar.JUNE, 8, 17, 41),
                new GregorianCalendar(2023, Calendar.JUNE, 8, 17, 41),
                6000.0);
        Employee employee3 = new Employee("Oleg Ivanov",
                new GregorianCalendar(2024, Calendar.MAY, 8, 17, 41),
                new GregorianCalendar(2024, Calendar.MAY, 8, 17, 41),
                9000.0);
        store.add(employee1);
        store.add(employee2);
        store.add(employee3);
        Report report = new XmlReport(store);
        String expect = """
                <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
                <employees>
                    <employee>
                        <name>John Doe</name>
                        <hired>08:06:2023 17:41</hired>
                        <fired>08:06:2023 17:41</fired>
                        <salary>5000.0</salary>
                    </employee>
                    <employee>
                        <name>Jane Smith</name>
                        <hired>08:06:2023 17:41</hired>
                        <fired>08:06:2023 17:41</fired>
                        <salary>6000.0</salary>
                    </employee>
                    <employee>
                        <name>Oleg Ivanov</name>
                        <hired>08:05:2024 17:41</hired>
                        <fired>08:05:2024 17:41</fired>
                        <salary>9000.0</salary>
                    </employee>
                </employees>
                """;
        assertThat(report.generate(em -> true)).isEqualTo(expect);
    }
}