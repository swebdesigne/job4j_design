package ru.job4j.sql.jdbc;

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

    public TableEditor(Properties properties) throws IOException {
        this.properties = properties;
        initConnection();
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

    public void createTable(String tableName) throws Exception {
        execute(String.format(
                "create table if not exists " + tableName + "(%s, %s)",
                "id serial primary key",
                "name varchar(255)"));
    }

    public void dropTable(String tableName) {
        execute(String.format("drop table %s", tableName));
    }

    public void addColumn(String tableName, String columnName, String type) {
        execute(String.format("alter table %s add column %s %s", tableName, columnName, type));
    }

    public void dropColumn(String tableName, String columnName) {
        execute(String.format("alter table %s drop column %s", tableName, columnName));
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) {
        execute(String.format("alter table %s rename column %s to %s", tableName, columnName, newColumnName));
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
        Properties properties = new Properties();
        properties.load(new FileReader("src/main/java/ru/job4j/sql/property/app.properties"));

        TableEditor editor = new TableEditor(properties);

        String tableName = "table_test";

        editor.createTable(tableName);
        System.out.println(editor.getTableScheme(editor.connection, tableName));

        editor.dropTable(tableName);
        System.out.println(editor.getTableScheme(editor.connection, tableName));

        editor.addColumn(tableName, "surname", "varchar(255)");
        System.out.println(editor.getTableScheme(editor.connection, tableName));

        editor.dropColumn(tableName, "surname");
        System.out.println(editor.getTableScheme(editor.connection, tableName));

        editor.renameColumn(tableName, "surname", "surname_1");
        System.out.println(editor.getTableScheme(editor.connection, tableName));
    }
}
