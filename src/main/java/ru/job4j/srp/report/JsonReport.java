package ru.job4j.srp.report;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.json.simple.JSONValue;
import ru.job4j.srp.formatter.DateTimeParser;
import ru.job4j.srp.model.Employee;
import ru.job4j.srp.store.Store;

import java.util.*;
import java.util.function.Predicate;

public class JsonReport implements Report {
    private final Store store;
    private final DateTimeParser<Calendar> dateTimeParser;
    private Gson gson;

    public JsonReport(Store store, DateTimeParser dateTimeParser) {
        this.store = store;
        this.dateTimeParser = dateTimeParser;
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        List<JsonElement> list = new ArrayList<>();
        store.findBy(filter).forEach(employee -> {
            Map<Object, Object> obj = new LinkedHashMap<>();
            obj.put("name", employee.getName());
            obj.put("hired", dateTimeParser.parse(employee.getHired()));
            obj.put("fired", dateTimeParser.parse(employee.getFired()));
            obj.put("salary", employee.getSalary());
            list.add(JsonParser.parseString(JSONValue.toJSONString(obj)));
        });
        return gson.toJson(list);
    }
}