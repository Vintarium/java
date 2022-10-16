package by.training.vintilov.service;

import by.training.vintilov.dao.daoImpl.CustomerService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;

public class ConnectDatabase {
    private static Logger log = Logger.getLogger(ConnectDatabase.class.getName());


    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:h2:mem:Shop;DB_CLOSE_DELAY=-1;INIT=RUNSCRIPT FROM 'classpath:scripts/initDb.sql'",
                    "sa", "");
            log.info("Connection succesfull");
        } catch (SQLException | ClassNotFoundException e) {
            log.info("Connection failed");
        }
        return connection;
    }





}
