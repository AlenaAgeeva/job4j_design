package ru.job4j.srp.report;

import ru.job4j.srp.model.Employee;
import ru.job4j.srp.model.Employees;
import ru.job4j.srp.store.Store;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.StringWriter;
import java.util.function.Predicate;

public class XmlReport implements Report {
    private final Store store;
    private JAXBContext context;
    private Marshaller marshaller;

    public XmlReport(Store store) throws JAXBException {
        this.store = store;
        this.context = JAXBContext.newInstance(Employees.class);
        this.marshaller = context.createMarshaller();
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder stringBuilder = new StringBuilder();
        try (StringWriter writer = new StringWriter()) {
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(new Employees(store.findBy(filter)), writer);
            stringBuilder.append(writer.getBuffer().toString());
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}