package dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import javafx.scene.control.Alert;
import service.AlertService;

import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Krzysztof on 2017-01-18.
 */

public class ConnectionProvider {

    private static ConnectionProvider conectionProvider;
    private ComboPooledDataSource connectionPool;

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

    public static Connection getConnection() throws SQLException, PropertyVetoException {
        return getInstance().connectionPool.getConnection();
    }

    public static ConnectionProvider getInstance() throws PropertyVetoException {

        if (conectionProvider == null){
            conectionProvider = new ConnectionProvider();
        }
        return conectionProvider;
    }

}
