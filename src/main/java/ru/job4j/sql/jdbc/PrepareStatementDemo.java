package ru.job4j.sql.jdbc;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PrepareStatementDemo {
    private Connection connection;
    private final Properties properties;

    public PrepareStatementDemo(Properties properties) {
        this.properties = properties;
        initConnection();
    }

    private void createTable(String tableName) {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(String.format(
                    "create table if not exists %s (%s, %s, %s)",
                    tableName,
                    "id serial primary key",
                    "name text",
                    "population int"
            ));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void initConnection() {
        try {
            Class.forName(properties.getProperty("driver_class"));
            connection = DriverManager.getConnection(
                    properties.getProperty("url"),
                    properties.getProperty("username"),
                    properties.getProperty("password")
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insert(City city) {
        boolean result = false;
        try (PreparedStatement statement = connection.prepareStatement(
                "insert into cities(name, population) values (?, ?)"
        )) {
            statement.setString(1, city.getName());
            statement.setInt(2, city.getPopulation());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean update(City city) {
        boolean result = false;
        try (PreparedStatement statement = connection.prepareStatement(
                "update cities set name = ?, population = ? where id = ?"
        )) {
            statement.setString(1, city.getName());
            statement.setInt(2, city.getPopulation());
            statement.setInt(3, city.getId());
            result = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean delete(int id) {
        boolean result = false;
        try (PreparedStatement statement = connection.prepareStatement(
                "delete from cities where id = ?"
        )) {
            statement.setInt(1, id);
            result = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<City> findAll() {
        List<City> cities = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("select * from cities")) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    cities.add(
                            new City(
                                    resultSet.getInt("id"),
                                    resultSet.getString("name"),
                                    resultSet.getInt("population")
                            )
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cities;
    }

    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileReader("src/main/java/ru/job4j/sql/property/idea_db.properties"));
        PrepareStatementDemo statement = new PrepareStatementDemo(properties);
        statement.createTable("cities");

        statement.insert(new City(1, "Moscow", 123000));
        statement.insert(new City(2, "SPB", 100000));
        statement.insert(new City(3, "Dubna", 74000));
        statement.insert(new City(4, "Krasnodar", 94000));

        statement.update(new City(4, "Krasnodar", 194000));
        for (City c : statement.findAll()) {
            System.out.println(
                    String.format("id: %s, nameCity: %s, population: %s", c.getId(), c.getName(), c.getPopulation())
            );
        }
    }
}
