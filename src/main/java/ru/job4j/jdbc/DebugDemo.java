package ru.job4j.jdbc;

import java.io.InputStream;
import java.sql.*;
import java.util.*;

public class DebugDemo {
    private Connection con;
    private Properties properties;

    public DebugDemo(Properties properties) throws Exception {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() throws Exception {
        Class.forName(properties.getProperty("jdbc.driver"));
        String url = properties.getProperty("jdbc.url");
        String login = properties.getProperty("jdbc.username");
        String password = properties.getProperty("jdbc.password");
        con = DriverManager.getConnection(url, login, password);
    }

    public void createTable() {
        try (Statement statement = con.createStatement()) {
            statement.execute(
                    "create table if not exists cities(id serial primary key, name text, population int);"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public City insert(City city) {
        try (PreparedStatement statement = con.prepareStatement(
                "insert into cities(name, population) values (?, ?);",
                Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, city.getName());
            statement.setInt(2, city.getPopulation());
            statement.execute();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    city.setId(generatedKeys.getInt(1));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return city;
    }

    public List<City> findAll() {
        List<City> cities = new ArrayList<>();
        try (PreparedStatement statement = con.prepareStatement("select * from cities;");
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                cities.add(new City(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("population")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cities;
    }

    public static void main(String[] args) throws Exception {
        try (InputStream in = TableEditor.class.getClassLoader()
                .getResourceAsStream("jdbc_app.properties")
        ) {
            Properties properties = new Properties();
            properties.load(in);
            City first = new City("CityOne", 100);
            City second = new City("CityTwo", 200);
            DebugDemo debugDemo = new DebugDemo(properties);
            debugDemo.createTable();
            debugDemo.insert(first);
            debugDemo.insert(second);
            for (City city : debugDemo.findAll()) {
                System.out.println("city = " + city);
            }
        }
    }
}
