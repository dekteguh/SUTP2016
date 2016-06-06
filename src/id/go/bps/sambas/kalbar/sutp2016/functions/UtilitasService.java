/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package id.go.bps.sambas.kalbar.sutp2016.functions;

import id.go.bps.sambas.kalbar.sutp2016.db.Connections;
import id.go.bps.sambas.kalbar.sutp2016.db.StringQuery;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;

/**
 *
 * @author dekteguh
 */
public class UtilitasService {
    public static ArrayList<Properties> getProgress(int option) throws Exception {
        ArrayList<Properties> list = new ArrayList<>();
        Connections c = new Connections();
        try {
            c.getConnection().setAutoCommit(false);
            String[] pecahanlagi = {"d.nks","d.pcl","d.jenis_tanaman"};
            String[] pecahan = {" d.nks as nks "," d.pcl as nama_pcl "," d.jenis_tanaman as jenis_tanaman "};
            
            String query = "SELECT d.tahun as tahun,d.subround as subround,d.id_prov as id_prov, s.nama_prov as nama_prov,d.id_kab as id_kab,s.nama_kab as nama_kab, "+pecahan[option-1]+", count(username)/count(nurt_sampel) as persentase FROM dsrt_ubinan d,dsbs_ubinan s WHERE d.tahun=s.tahun AND d.subround=s.subround AND d.id_prov=s.id_prov AND d.id_kab=s.id_kab AND d.nks=s.nks group by d.tahun,d.subround,d.id_prov,d.id_kab,"+pecahanlagi[option-1];
            PreparedStatement ps = c.getConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Properties prop = new Properties();
                prop.setProperty("tahun", rs.getString("tahun"));
                prop.setProperty("subround", rs.getString("subround"));
                prop.setProperty("id_prov", rs.getString("id_prov"));
                prop.setProperty("nama_prov", rs.getString("nama_prov"));
                prop.setProperty("id_kab", rs.getString("id_kab"));
                prop.setProperty("nama_kab", rs.getString("nama_kab"));
                if(option==1){
                    prop.setProperty("nks", rs.getString("nks"));
                    prop.setProperty("persentase", rs.getString("persentase"));
                }else if(option==2){
                    prop.setProperty("nama_pcl", rs.getString("nama_pcl"));
                    prop.setProperty("persentase", rs.getString("persentase"));
                }else if(option==3){
                    prop.setProperty("jenis_tanaman", rs.getString("jenis_tanaman"));
                    prop.setProperty("persentase", rs.getString("persentase"));
                }
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
    
    public static ArrayList<Properties> getProgressPcl() throws Exception {
        ArrayList<Properties> list = new ArrayList<>();
        Connections c = new Connections();
        try {
            c.getConnection().setAutoCommit(false);
            PreparedStatement ps = c.getConnection().prepareStatement(StringQuery.PROGRESS_PCL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Properties prop = new Properties();
                prop.setProperty("tahun", rs.getString("tahun"));
                prop.setProperty("subround", rs.getString("subround"));
                prop.setProperty("id_prov", rs.getString("id_prov"));
                prop.setProperty("nama_prov", rs.getString("nama_prov"));
                prop.setProperty("id_kab", rs.getString("id_kab"));
                prop.setProperty("nama_kab", rs.getString("nama_kab"));
                prop.setProperty("nama_pcl", rs.getString("nama_pcl"));
                prop.setProperty("jumlah_sampel", rs.getString("jumlah_sampel"));
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
    
    public static ArrayList<Properties> getProgressKomoditi() throws Exception {
        ArrayList<Properties> list = new ArrayList<>();
        Connections c = new Connections();
        try {
            c.getConnection().setAutoCommit(false);
            PreparedStatement ps = c.getConnection().prepareStatement(StringQuery.PROGRESS_PCL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Properties prop = new Properties();
                prop.setProperty("tahun", rs.getString("tahun"));
                prop.setProperty("subround", rs.getString("subround"));
                prop.setProperty("id_prov", rs.getString("id_prov"));
                prop.setProperty("nama_prov", rs.getString("nama_prov"));
                prop.setProperty("id_kab", rs.getString("id_kab"));
                prop.setProperty("nama_kab", rs.getString("nama_kab"));
                prop.setProperty("nama_pcl", rs.getString("nama_pcl"));
                prop.setProperty("jumlah_sampel", rs.getString("jumlah_sampel"));
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
    
    public static ArrayList<String> getNKS() throws Exception {
        ArrayList<String> list = new ArrayList<>();
        Connections c = new Connections();
        try {
            c.getConnection().setAutoCommit(false);
            PreparedStatement ps = c.getConnection().prepareStatement(StringQuery.LIST_NKS);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String nks = rs.getString("nks");
                list.add(nks);
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
    
    public static Properties getWilayah(String id_prov, String id_kab) throws Exception {
        Properties prop = null;
        Connections c = new Connections();
        try {
            c.getConnection().setAutoCommit(false);
            PreparedStatement ps = c.getConnection().prepareStatement(StringQuery.GET_WILAYAH);
            ps.setString(1, id_prov);
            ps.setString(2, id_kab);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                prop = new Properties();
                prop.setProperty("id_prov", rs.getString("id_prov"));
                prop.setProperty("nama_prov", rs.getString("nama_prov"));
                prop.setProperty("id_kab", rs.getString("id_kab"));
                prop.setProperty("nama_kab", rs.getString("nama_kab"));
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
}
