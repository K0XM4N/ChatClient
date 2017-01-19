package dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Krzysztof on 2017-01-18.
 */
public class ConnectionProvider {

    private static DataSource dataSource;

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection("root","root");
    }

    public static DataSource getInstance() throws NamingException {

        if (dataSource == null){
            Context initialContext = new InitialContext();
            Context envContext = (Context) initialContext.lookup("java:comp/env");
            dataSource = (DataSource) envContext.lookup("jdbc/chat_db");
        }

        return dataSource;
    }

}
