package dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import javafx.scene.control.Alert;
import service.AlertService;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Krzysztof on 2017-01-18.
 */

public class ConnectionProvider {

    private static ConnectionProvider connectionProvider;
    private  ComboPooledDataSource connectionPool;

    private ConnectionProvider() {

        try {
            connectionPool = new ComboPooledDataSource();
            connectionPool.setDriverClass("com.mysql.jdbc.Driver");
            connectionPool.setJdbcUrl("jdbc:mysql://localhost:3306/chat_db");
            connectionPool.setUser("root");
            connectionPool.setPassword("root");

            connectionPool.setMinPoolSize(3);
            connectionPool.setMaxPoolSize(20);
            connectionPool.setAcquireIncrement(5);
            connectionPool.setMaxIdleTime(3600);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
            AlertService.showAlert(Alert.AlertType.WARNING, "Database error", "Cannot connect do database");
        }
    }

    public static Connection getConnection() throws PropertyVetoException, SQLException {
       return getInstance().connectionPool.getConnection();
    }

    public static ConnectionProvider getInstance() throws PropertyVetoException {

        if (connectionProvider == null){
            connectionProvider = new ConnectionProvider();
        }
        return connectionProvider;
    }

}
