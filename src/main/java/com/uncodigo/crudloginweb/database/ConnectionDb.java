package com.uncodigo.crudloginweb.database;

import com.uncodigo.crudloginweb.database.DatabaseInterfaces.IEnvProvider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDb implements IEnvProvider {
    private static ConnectionDb instance;
    private Connection connection;

    private ConnectionDb() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://" + HOST_DB + ":" + PORT_DB + "/" + NAME_DB, USER_DB, PASS_DB);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static ConnectionDb getInstance() {
        if (instance == null) {
            instance = new ConnectionDb();
        }
        return instance;
    }

    // Get the connection singleton
    public Connection getConnection() {
        return connection;
    }

}
