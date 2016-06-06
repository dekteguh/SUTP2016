/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package id.go.bps.sambas.kalbar.sutp2016.db;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author dekteguh
 */
public class DBProperty {
    private static String namaDB;
    private static String host;
    private static String port;
    private static String username;
    private static String password;

    public static String getNamaDB() {
        return namaDB;
    }

    public static void setNamaDB(String namaDB) {
        DBProperty.namaDB = namaDB;
    }

    public static String getHost() {
        return host;
    }

    public static void setHost(String host) {
        DBProperty.host = host;
    }

    public static String getPort() {
        return port;
    }

    public static void setPort(String port) {
        DBProperty.port = port;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        DBProperty.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        DBProperty.password = password;
    }
    
    static
    {
            File file = new File("DbProperty.txt");
            FileReader reader = null;
            BufferedReader bufferedReader = null;
            try {
            reader = new FileReader(file);
            bufferedReader = new BufferedReader(reader);
            host = bufferedReader.readLine();
            port = bufferedReader.readLine();
            username = bufferedReader.readLine();
            password = bufferedReader.readLine();
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Property tidak ditemukan!");
            System.exit(0);
        }
        try {
            bufferedReader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
