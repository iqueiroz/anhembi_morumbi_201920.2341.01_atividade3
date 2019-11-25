package br.anhembi.topicosespeciais.atividade3.dataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnection {

    private Connection _connection;
    
    public Connection getConnection() {
        return this._connection;
    }

    public DatabaseConnection() throws SQLException {
        super();
        this._connection = connect();
    }

    private static Connection connect() throws SQLException {
        DatabaseConfiguration config = new DatabaseConfiguration();
        Connection conn = null;
        String url = config.getConnectionUri();
        conn = DriverManager.getConnection(url, config.getUsername(), config.getPassword());
        return conn;    
    }

    public void destroy() {
        try {
            if(this._connection!=null && !this._connection.isClosed())
            this._connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}