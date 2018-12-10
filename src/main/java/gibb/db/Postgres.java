package gibb.db;

import org.postgresql.ds.PGSimpleDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * User: Daniel Senften <daniel@senften.org>
 * Date: 2018-12-10, 14:58
 */
public class Postgres {

    public static Connection getConnection() throws SQLException {

        PGSimpleDataSource dataSource = new PGSimpleDataSource();

        dataSource.setServerName("localhost");
        dataSource.setDatabaseName("llqatest");
        dataSource.setUser("llqa");
        dataSource.setPassword("postgres");

        return dataSource.getConnection();
    }
}
