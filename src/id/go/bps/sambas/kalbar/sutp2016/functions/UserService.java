/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package id.go.bps.sambas.kalbar.sutp2016.functions;

import id.go.bps.sambas.kalbar.sutp2016.db.Connections;
import id.go.bps.sambas.kalbar.sutp2016.db.StringQuery;
import id.go.bps.sambas.kalbar.sutp2016.entity.Operator;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author developer
 */
public class UserService {
    //Fungsi yang digunakan untuk login

    public static Properties login(String username, String password) throws Exception {
        Properties prop = null;
        Connections c = new Connections();
        try {
            c.getConnection().setAutoCommit(false);
            PreparedStatement ps = c.getConnection().prepareStatement(StringQuery.LOGIN_OPERATOR);
            ps.setString(1, username);
            ps.setString(2, DigestUtils.md5Hex(password));
            ResultSet rs = ps.executeQuery();
            prop = new Properties();
            if (rs.next()) {
                prop.put("message", "success");
                prop.put("username", username);
                prop.put("nama_user", rs.getString("nama_operator"));
                prop.put("level", rs.getString("kategori_operator"));
            } else {
                prop.put("message", "fail");
            }
            c.getConnection().commit();
        } catch (Exception e) {
            System.err.println("error: " + e.getMessage());
        } finally {
             try {
                c.getConnection().setAutoCommit(true);
                if (c.getConnection() != null) {
                    c.getConnection().close();
                }
            } catch (Exception e) {
                System.err.println("error: " + e.getMessage());
            }
        }
        return prop;
    }


    //Fungsi yang digunakan untuk dapet semua operator
    public static ArrayList<Properties> getOperators() throws Exception {
        ArrayList<Properties> list = new ArrayList<>();
        Connections c = new Connections();
        try {
            c.getConnection().setAutoCommit(false);
            PreparedStatement ps = c.getConnection().prepareStatement(StringQuery.GET_OPERATOR);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Properties prop = new Properties();
                prop.setProperty("tahun", rs.getString("o.tahun"));
                prop.setProperty("subround", rs.getString("o.subround"));
                prop.setProperty("id_prov", rs.getString("o.id_prov"));
                prop.setProperty("nama_prov", rs.getString("w.nama_prov"));
                prop.setProperty("id_kab", rs.getString("o.id_kab"));
                prop.setProperty("nama_kab", rs.getString("w.nama_kab"));
                prop.setProperty("nip", rs.getString("o.nip"));
                prop.setProperty("username", rs.getString("o.username"));
                prop.setProperty("nama_operator", rs.getString("o.nama_operator"));
                prop.setProperty("jabatan", rs.getString("o.jabatan"));
                prop.setProperty("no_telp", rs.getString("o.no_telp"));
                list.add(prop);
            }
            c.getConnection().commit();
        } catch (Exception e) {
            System.err.println("error: " + e.getMessage());
        } finally {
            try {
                c.getConnection().setAutoCommit(true);
                if (c.getConnection() != null) {
                    c.getConnection().close();
                }
            } catch (Exception e) {
                System.err.println("error: " + e.getMessage());
            }
        }
        return list;
    }
    //Fungsi yang digunakan untuk dapet semua operator
    public static ArrayList<Properties> getOperator(int tahun, int subround) throws Exception {
        ArrayList<Properties> list = new ArrayList<>();
        Connections c = new Connections();
        try {
            c.getConnection().setAutoCommit(false);
            PreparedStatement ps = c.getConnection().prepareStatement(StringQuery.GET_OPERATOR_WHERE);
            ps.setInt(1, tahun);
            ps.setInt(2, subround);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Properties prop = new Properties();
                prop.setProperty("tahun", rs.getString("o.tahun"));
                prop.setProperty("subround", rs.getString("o.subround"));
                prop.setProperty("id_prov", rs.getString("o.id_prov"));
                prop.setProperty("nama_prov", rs.getString("w.nama_prov"));
                prop.setProperty("id_kab", rs.getString("o.id_kab"));
                prop.setProperty("nama_kab", rs.getString("w.nama_kab"));
                prop.setProperty("nip", rs.getString("o.nip"));
                prop.setProperty("username", rs.getString("o.username"));
                prop.setProperty("nama_operator", rs.getString("o.nama_operator"));
                prop.setProperty("jabatan", rs.getString("o.jabatan"));
                prop.setProperty("no_telp", rs.getString("o.no_telp"));
                list.add(prop);
            }
            c.getConnection().commit();
        } catch (Exception e) {
            System.err.println("error: " + e.getMessage());
        } finally {
            try {
                c.getConnection().setAutoCommit(true);
                if (c.getConnection() != null) {
                    c.getConnection().close();
                }
            } catch (Exception e) {
                System.err.println("error: " + e.getMessage());
            }
        }
        return list;
    }  
    
    //Fungsi yang digunakan untuk dapet semua operator
    public static Operator getOperator(int tahun, int subround, String username) throws Exception {
        Operator prop = null;
        Connections c = new Connections();
        try {
            c.getConnection().setAutoCommit(false);
            PreparedStatement ps = c.getConnection().prepareStatement(StringQuery.GET_OPERATOR_WHERE_USERNAME);
            ps.setInt(1, tahun);
            ps.setInt(2, subround);
            ps.setString(3, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                prop = new Operator();
                prop.setTahun(rs.getInt("o.tahun"));
                prop.setSubround(rs.getInt("o.subround"));
                prop.setIdProv(rs.getString("o.id_prov"));
                prop.setIdKab(rs.getString("o.id_kab"));
                prop.setNip(rs.getString("o.nip"));
                prop.setUsername(rs.getString("o.username"));
                prop.setNamaOperator(rs.getString("o.nama_operator"));
                prop.setKategoriOperator(rs.getInt("o.kategori_operator"));
                prop.setJabatan(rs.getString("o.jabatan"));
                prop.setNoTelp(rs.getString("o.no_telp"));
                prop.setPassword(rs.getString("o.password"));
            }
            c.getConnection().commit();
        } catch (Exception e) {
            System.err.println("error: " + e.getMessage());
        } finally {
            try {
                c.getConnection().setAutoCommit(true);
                if (c.getConnection() != null) {
                    c.getConnection().close();
                }
            } catch (Exception e) {
                System.err.println("error: " + e.getMessage());
            }
        }
        return prop;
    } 
    
    //Fungsi yang digunakan untuk dapet semua operator
    public static long insertOperator(Operator operator) throws Exception {
        long in = 0;
        Connections c = new Connections();
        try {
            c.getConnection().setAutoCommit(false);
            PreparedStatement ps = c.getConnection().prepareStatement(StringQuery.INSERT_OPERATOR);
            ps.setInt(1, operator.getTahun());
            ps.setInt(2, operator.getSubround());
            ps.setString(3, operator.getIdProv());
            ps.setString(4, operator.getIdKab());
            ps.setString(5, operator.getNip());
            ps.setString(6, operator.getUsername());
            ps.setString(7, operator.getNamaOperator());
            ps.setInt(8, operator.getKategoriOperator());
            ps.setString(9, operator.getJabatan());
            ps.setString(10, operator.getNoTelp());
            ps.setString(11, DigestUtils.md5Hex(operator.getPassword()));
            ps.executeUpdate();
            in = 1;
            c.getConnection().commit();
        } catch (Exception e) {
            System.err.println("error: " + e.getMessage());
        } finally {
            try {
                c.getConnection().setAutoCommit(true);
                if (c.getConnection() != null) {
                    c.getConnection().close();
                }
            } catch (Exception e) {
                System.err.println("error: " + e.getMessage());
            }
        }
        return in;
    } 
    
    
    //Fungsi yang digunakan untuk dapet semua operator
    public static long updateOperator(int tahun,int sr, String idprov, String idkab, String nip, String username, String nama, int kat, String jabatan, String nohp, String pass ) throws Exception {
        long in = 0;
        Connections c = new Connections();
        try {
            c.getConnection().setAutoCommit(false);
            PreparedStatement ps = c.getConnection().prepareStatement(StringQuery.UPDATE_OPERATOR);
            ps.setInt(1, tahun);
            ps.setInt(2, sr);
            ps.setString(3, idprov);
            ps.setString(4, idkab);
            ps.setString(5, nip);
            ps.setString(6, username);
            ps.setString(7, nama);
            ps.setInt(8, kat);
            ps.setString(9, jabatan);
            ps.setString(10, nohp);
            ps.setString(11, DigestUtils.md5Hex(pass));
            ps.setInt(12, tahun);
            ps.setInt(13, sr);
            ps.setString(14, username);
            ps.execute();
            in = 1;
            c.getConnection().commit();
        } catch (Exception e) {
            System.err.println("error: " + e.getMessage());
        } finally {
            try {
                c.getConnection().setAutoCommit(true);
                if (c.getConnection() != null) {
                    c.getConnection().close();
                }
            } catch (Exception e) {
                System.err.println("error: " + e.getMessage());
            }
        }
        return in;
    } 
    
    //Fungsi yang digunakan untuk dapet semua operator
    public static long deleteOperator(int tahun,int subround,String username) throws Exception {
        long in = 0;
        Connections c = new Connections();
        try {
            c.getConnection().setAutoCommit(false);
            PreparedStatement ps = c.getConnection().prepareStatement(StringQuery.DELETE_OPERATOR);
            ps.setInt(1, tahun);
            ps.setInt(2, subround);
            ps.setString(3, username);
            ps.executeUpdate();
            in = 1;
            c.getConnection().commit();
        } catch (Exception e) {
            System.err.println("error: " + e.getMessage());
        } finally {
            try {
                c.getConnection().setAutoCommit(true);
                if (c.getConnection() != null) {
                    c.getConnection().close();
                }
            } catch (Exception e) {
                System.err.println("error: " + e.getMessage());
            }
        }
        return in;
    } 
}
