package ru.job4j.sql.jdbc;

import ru.job4j.io.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnection {
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Config config = new Config("src/main/java/ru/job4j/sql/property/app.properties");
        config.load();
        Class.forName(config.value("driver_class"));
        return DriverManager.getConnection(
                config.value("url"),
                config.value("username"),
                config.value("password")
        );
    }
}
