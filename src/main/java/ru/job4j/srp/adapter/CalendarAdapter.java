package ru.job4j.srp.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class CalendarAdapter extends XmlAdapter<String, Calendar> {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd:MM:yyyy HH:mm", Locale.ENGLISH);

    @Override
    public Calendar unmarshal(String s) throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(DATE_FORMAT.parse(s));
        return calendar;
    }

    @Override
    public String marshal(Calendar calendar) {
        return DATE_FORMAT.format(calendar.getTime());
    }
}