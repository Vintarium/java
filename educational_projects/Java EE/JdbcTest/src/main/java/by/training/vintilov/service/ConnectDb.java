package by.training.vintilov.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;

public class ConnectDb {
    private final Logger log = Logger.getLogger(ConnectDb.class.getName());
    private static Connection connection;

    public Connection getConnection() {
        try {
            Class.forName(getPropertyValueForConnection("DB_Driver"));
            connection = DriverManager.getConnection(
                    getPropertyValueForConnection("URL"),
                    getPropertyValueForConnection("USER_NAME"),
                    getPropertyValueForConnection("PASSWORD"));
        } catch (ClassNotFoundException | SQLException e) {
            log.info("Connection not established");
        }
        return connection;
    }

    private String getPropertyValueForConnection(String propertyName) {
        String propertyValue = "";
        Properties properties = new Properties();
        try (FileInputStream inputStream = new FileInputStream("src/main/resources/ConnectDbTest.properties")) {
            properties.load(inputStream);
            propertyValue = properties.getProperty(propertyName);
        } catch (IOException e) {
            log.info("Properties not found");
        }
        return propertyValue;
    }
}

