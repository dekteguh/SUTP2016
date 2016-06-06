/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package id.go.bps.sambas.kalbar.sutp2016.db;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dekteguh
 */
public class Connections {

    private Connection koneksi;

    public Connection getConnection() {
        if (koneksi == null) {
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setUrl("jdbc:mysql://" + DBProperty.getHost() + ":" + DBProperty.getPort() + "/ubinan_db");
            dataSource.setUser(DBProperty.getUsername());
            dataSource.setPassword(DBProperty.getPassword());
            try {
                koneksi = dataSource.getConnection();
            } catch (SQLException ex) {
                Logger.getLogger(Connections.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return koneksi;
    }
}
