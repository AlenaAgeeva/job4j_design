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

import static org.assertj.core.api.Assertions.*;

class AccountantReportTest {

    @Test
    public void whenGeneratedWithCurrencyConversationRubToUsd() {
        MemoryStore store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        store.add(worker);
        CurrencyConverter converter = new InMemoryCurrencyConverter();
        Report engine = new AccountantReport(store, parser, converter, Currency.RUB, Currency.USD);
        StringBuilder expected = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(" ")
                .append(parser.parse(worker.getHired())).append(" ")
                .append(parser.parse(worker.getFired())).append(" ")
                .append(converter.convert(Currency.RUB, worker.getSalary(), Currency.USD))
                .append(System.lineSeparator());
        assertThat(engine.generate(employee -> true)).isEqualTo(expected.toString());
    }
    @Test
    public void whenGeneratedWithCurrencyConversationEurToRub() {
        MemoryStore store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 5000);
        Employee worker2 = new Employee("Egor", now, now, 750);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        store.add(worker1);
        store.add(worker2);
        CurrencyConverter converter = new InMemoryCurrencyConverter();
        Report engine = new AccountantReport(store, parser, converter, Currency.EUR, Currency.RUB);
        StringBuilder expected = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker1.getName()).append(" ")
                .append(parser.parse(worker1.getHired())).append(" ")
                .append(parser.parse(worker1.getFired())).append(" ")
                .append(converter.convert(Currency.EUR, worker1.getSalary(), Currency.RUB))
                .append(System.lineSeparator())
                .append(worker2.getName()).append(" ")
                .append(parser.parse(worker2.getHired())).append(" ")
                .append(parser.parse(worker2.getFired())).append(" ")
                .append(converter.convert(Currency.EUR, worker2.getSalary(), Currency.RUB))
                .append(System.lineSeparator());
        assertThat(engine.generate(employee -> true)).isEqualTo(expected.toString());
    }
}