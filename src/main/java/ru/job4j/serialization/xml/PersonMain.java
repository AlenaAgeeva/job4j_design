package ru.job4j.serialization.xml;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.*;

public class PersonMain {
    public static void main(String[] args) {
        /* JSONObject из json-строки строки */
        JSONObject jsonContact = new JSONObject("{\"phone\":\"11-111\"}");
        /* JSONArray из ArrayList */
        List<String> list = new ArrayList<>();
        list.add("Worker");
        list.add("Married");
        JSONArray jsonStatuses = new JSONArray(list);
        /* JSONObject напрямую методом put */
        final Person person = new Person(false, 30, new Contact("11-111"), "Worker", "Married");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sex", person.isSex());
        jsonObject.put("age", person.getAge());
        jsonObject.put("contact", jsonContact);
        jsonObject.put("statuses", jsonStatuses);
        /* Выведем результат в консоль */
        System.out.println(jsonObject.toString());
        /* Преобразуем объект person в json-строку */
        System.out.println(new JSONObject(person).toString());
    }
}
