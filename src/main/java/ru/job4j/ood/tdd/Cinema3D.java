package ru.job4j.ood.tdd;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Cinema3D implements Cinema {
    private List<Session> sessions;

    public Cinema3D() {
        this.sessions = new ArrayList<>();
    }

    @Override
    public List<Session> find(Predicate<Session> filter) {
        return sessions.stream().filter(filter).collect(Collectors.toList());
    }

    @Override
    public Ticket buy(Account account, int row, int column, Calendar date) {
        if (row <= 0 || column <= 0 || date == null || account == null) {
            throw new IllegalArgumentException("Wrong argument.");
        }
        return new Ticket3D(account, row, column, date);
    }

    @Override
    public void add(Session session) {
        sessions.add(session);
    }

    public List<Session> getSessions() {
        return this.sessions;
    }
}
