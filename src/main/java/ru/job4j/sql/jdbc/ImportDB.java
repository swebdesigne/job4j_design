package ru.job4j.sql.jdbc;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ImportDB {
    private final Properties cfg;
    private final String dump;

    public ImportDB(Properties cfg, String dump) {
        this.cfg = cfg;
        this.dump = dump;
    }

    public List<User> load() throws IOException {
        List<User> users = new ArrayList<>();
        try (BufferedReader bfr = new BufferedReader(new FileReader(dump))) {
            bfr.lines().forEach(user -> {
                    String[] dataUser = user.split(";");
                    validate(dataUser);
                    users.add(new User(dataUser[0], dataUser[1]));
                }
            );
        }
        return users;
    }

    private void validate(String[] arr) {
        if (arr.length != 2) {
            throw new IllegalArgumentException("Length of array must be equals two");
        }
        if (arr[0].isEmpty() || arr[1].isEmpty()) {
            throw new IllegalArgumentException("The element must be not empty");
        }
    }

    public void save(List<User> users) throws ClassNotFoundException, SQLException {
        Class.forName(cfg.getProperty("jdbc.driver"));
        try (Connection cnt = DriverManager.getConnection(
                cfg.getProperty("jdbc.url"),
                cfg.getProperty("jdbc.username"),
                cfg.getProperty("jdbc.password")
        )) {
            for (User user : users) {
                try (PreparedStatement ps = cnt.prepareStatement(
                        "insert into users (name, email) values (?, ?)"
                )) {
                    ps.setString(1, user.name);
                    ps.setString(2, user.email);
                    ps.execute();
                }
            }
        }
    }

    private static class User {
        String name;
        String email;

        public User(String name, String email) {
            this.name = name;
            this.email = email;
        }
    }

    public static void main(String[] args) throws Exception {
        Properties cfg = new Properties();
        try (FileInputStream in = new FileInputStream("src/main/java/ru/job4j/sql/property/spammer.properties")) {
            cfg.load(in);
        }
        ImportDB db = new ImportDB(cfg, "src/main/java/ru/job4j/sql/data/dump.txt");
        db.save(db.load());
    }
}
