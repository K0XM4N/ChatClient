package dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;

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

    private ConnectionProvider() throws PropertyVetoException {

        connectionPool = new ComboPooledDataSource();
        connectionPool.setDriverClass("com.mysql.jdbc.Driver");
        connectionPool.setJdbcUrl("jdbc:mysql://localhost:3306/chat_db");
        connectionPool.setUser("root");
        connectionPool.setPassword("root");

        connectionPool.setMinPoolSize(3);
        connectionPool.setMaxPoolSize(20);
        connectionPool.setAcquireIncrement(5);
        connectionPool.setMaxIdleTime(3600);
    }

    public Connection getConnection() throws SQLException {
        return connectionPool.getConnection();
    }

    public static ConnectionProvider getInstance() throws PropertyVetoException {

        if (conectionProvider == null){
            conectionProvider = new ConnectionProvider();
        }
        return conectionProvider;
    }

}
