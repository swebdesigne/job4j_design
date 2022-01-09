package ru.job4j.sql.jdbc;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {
    private Connection connection;
    private final Properties properties;

    public TableEditor(Properties properties) {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() {
        try {
            properties.load(new FileReader("src/main/java/ru/job4j/sql/property/app.properties"));
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

    public void createTable(String tableName) throws Exception {
        execute(String.format(
                "create table if not exists " + tableName + "(%s, %s)",
                "id serial primary key",
                "name varchar(255)"));
        System.out.println(getTableScheme(connection, tableName));
    }

    public void dropTable(String tableName) {
        execute("drop table " + tableName);
    }

    public void addColumn(String tableName, String columnName, String type) {
        execute("alter table " + tableName + " add column " + columnName + " " + type);
    }

    public void dropColumn(String tableName, String columnName) {
        execute("alter table " + tableName + " drop column " + columnName);
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) {
        execute("alter table " + tableName + " rename column " + columnName + " to " + newColumnName);
    }

    private void execute(String query) {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public String getTableScheme(Connection connection, String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "select * from %s limit 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) throws Exception {
        String tableName = "table_test";
        TableEditor editor = new TableEditor(new Properties());

        editor.createTable(tableName);
        editor.dropTable(tableName);
        editor.addColumn(tableName, "surname", "varchar(255)");
        editor.dropColumn(tableName, "surname");
        editor.renameColumn(tableName, "surname", "surname_1");
    }
}
