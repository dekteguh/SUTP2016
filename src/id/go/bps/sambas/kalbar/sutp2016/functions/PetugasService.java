/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package id.go.bps.sambas.kalbar.sutp2016.functions;

import id.go.bps.sambas.kalbar.sutp2016.db.Connections;
import id.go.bps.sambas.kalbar.sutp2016.db.StringQuery;
import id.go.bps.sambas.kalbar.sutp2016.entity.Petugas;
import java.io.FileInputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/**
 *
 * @author dekteguh
 */
public class PetugasService {
    public static ArrayList<Petugas> getPetugas(int tahun, int subround, String idProv, String idKab, String nks) throws Exception{
        ArrayList<Petugas> list = new ArrayList<>();
        Connections c = new Connections();
        try{
            c.getConnection().setAutoCommit(false);
            PreparedStatement ps = c.getConnection().prepareStatement(StringQuery.GET_PETUGAS);
            ps.setInt(1, tahun);
            ps.setInt(2, subround);
            ps.setString(3, idProv);
            ps.setString(4, idKab);
            ps.setString(5, nks);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Petugas dsbs = new Petugas();
                dsbs.setTahun(rs.getInt("tahun"));
                dsbs.setSubround(rs.getInt("subround"));
                dsbs.setIdProv(rs.getString("id_prov"));
                dsbs.setIdKab(rs.getString("id_kab"));
                dsbs.setNks(rs.getString("nks"));
                dsbs.setNamaPetugas(rs.getString("nama_pcl"));
                dsbs.setNamaPengawas(rs.getString("nama_pml"));
                list.add(dsbs);
            }
            c.getConnection().commit();
        }catch(Exception ex){
            System.err.println("error: " + ex.getMessage());
        }finally{
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
    
    public static ArrayList<Petugas> getPetugas() throws Exception{
        ArrayList<Petugas> list = new ArrayList<>();
        Connections c = new Connections();
        try{
            c.getConnection().setAutoCommit(false);
            PreparedStatement ps = c.getConnection().prepareStatement(StringQuery.GET_PETUGAS_ALL);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Petugas dsbs = new Petugas();
                dsbs.setTahun(rs.getInt("tahun"));
                dsbs.setSubround(rs.getInt("subround"));
                dsbs.setIdProv(rs.getString("id_prov"));
                dsbs.setIdKab(rs.getString("id_kab"));
                dsbs.setNks(rs.getString("nks"));
                dsbs.setNamaPetugas(rs.getString("nama_pcl"));
                dsbs.setNamaPengawas(rs.getString("nama_pml"));
                list.add(dsbs);
            }
            c.getConnection().commit();
        }catch(Exception ex){
            System.err.println("error: " + ex.getMessage());
        }finally{
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
    
    public static long importPetugas(String paths) throws Exception{
        long in = 0;
        System.out.println(paths);
        FileInputStream stream = null;
        try{
            stream = new FileInputStream(paths);
            POIFSFileSystem fileSystem = new POIFSFileSystem(stream);
            HSSFWorkbook workbook = new HSSFWorkbook(fileSystem);
            HSSFSheet sheet = workbook.getSheetAt(0);
            //baris
            Iterator baris = sheet.rowIterator();
            while(baris.hasNext()){
                HSSFRow row = (HSSFRow) baris.next();
                
                if(row.getRowNum()==0){
                    continue; //just skip the rows if row number is 0 or 1
                }
                System.out.println(row.getRowNum());
                //cell
                Iterator cells = row.cellIterator();
                Petugas dsbs = new Petugas();
                int i = 0;
                while(cells.hasNext()){
                    HSSFCell cell = (HSSFCell) cells.next();
                    //cell 1, tahun
                    if(cell.getCellType()==HSSFCell.CELL_TYPE_NUMERIC){
                        if(i==0){
                            dsbs.setTahun((int)Math.round(cell.getNumericCellValue()));
                        }
                        if(i==1){
                            dsbs.setSubround((int)Math.round(cell.getNumericCellValue()));
                        }
                    }else if(cell.getCellType()==HSSFCell.CELL_TYPE_STRING){
                        if(i==2){
                            dsbs.setIdProv(cell.getRichStringCellValue ().getString());
                        }
                        if(i==3){
                            dsbs.setIdKab(cell.getRichStringCellValue ().getString());
                        }
                        if(i==4){
                            dsbs.setNks(cell.getRichStringCellValue ().getString());
                        }
                        if(i==5){
                            dsbs.setNamaPetugas(cell.getRichStringCellValue ().getString());
                        }
                        if(i==6){
                            dsbs.setNamaPengawas(cell.getRichStringCellValue ().getString());
                        }
                    }
                    i++;
                }
                savePetugas(dsbs);
            }
            in = 1;
            stream.close();
        }catch(Exception ex){
            System.err.println("error: " + ex.getMessage());
        }finally{
            try {
                if (stream != null) {
                   stream.close();
                }
            } catch (Exception e) {
                System.err.println("error: " + e.getMessage());
            }
        }
        return in;
    }
    
    private static void savePetugas(Petugas dsbs) throws Exception{
        Connections c = new Connections();
        try{
            c.getConnection().setAutoCommit(false);
            PreparedStatement ps = c.getConnection().prepareStatement(StringQuery.SAVE_PETUGAS);
            ps.setInt(1, dsbs.getTahun());
            ps.setInt(2, dsbs.getSubround());
            ps.setString(3, dsbs.getIdProv());
            ps.setString(4, dsbs.getIdKab());
            ps.setString(5, dsbs.getNks());
            ps.setString(6, dsbs.getNamaPetugas());
            ps.setString(7, dsbs.getNamaPengawas());
            ps.executeUpdate();
            
            c.getConnection().commit();
        }catch(Exception ex){
            System.err.println("error: " + ex.getMessage());
        }finally{
            try {
                c.getConnection().setAutoCommit(true);
                if (c.getConnection() != null) {
                    c.getConnection().close();
                }
            } catch (Exception e) {
                System.err.println("error: " + e.getMessage());
            }
        }
    }
    
    public static long deletePetugas(int tahun,int subround,String idProv, String idKab, String nks) throws Exception {
        long in = 0;
        Connections c = new Connections();
        try {
            c.getConnection().setAutoCommit(false);
            PreparedStatement ps = c.getConnection().prepareStatement(StringQuery.DELETE_PETUGAS);
            ps.setInt(1, tahun);
            ps.setInt(2, subround);
            ps.setString(3, idProv);
            ps.setString(4, idKab);
            ps.setString(5, nks);
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
    
    public static void downloadTemplate(){
        
    }
}
