/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package id.go.bps.sambas.kalbar.sutp2016.functions;

import id.go.bps.sambas.kalbar.sutp2016.db.Connections;
import id.go.bps.sambas.kalbar.sutp2016.db.StringQuery;
import id.go.bps.sambas.kalbar.sutp2016.entity.DSBS;
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
public class DSBSService {
    public static ArrayList<DSBS> getDSBS(int tahun, int subround, String idProv, String idKab) throws Exception{
        ArrayList<DSBS> list = new ArrayList<>();
        Connections c = new Connections();
        try{
            c.getConnection().setAutoCommit(false);
            PreparedStatement ps = c.getConnection().prepareStatement(StringQuery.GET_DSBS);
            ps.setInt(1, tahun);
            ps.setInt(2, subround);
            ps.setString(3, idProv);
            ps.setString(4, idKab);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                DSBS dsbs = new DSBS();
                dsbs.setTahun(rs.getInt("tahun"));
                dsbs.setSubround(rs.getInt("subround"));
                dsbs.setIdProv(rs.getString("id_prov"));
                dsbs.setNamaProv(rs.getString("nama_prov"));
                dsbs.setIdKab(rs.getString("id_kab"));
                dsbs.setNamaKab(rs.getString("nama_kab"));
                dsbs.setIdKec(rs.getString("id_kec"));
                dsbs.setNamaKec(rs.getString("nama_kec"));
                dsbs.setIdDesa(rs.getString("id_desa"));
                dsbs.setNamaDesa(rs.getString("nama_desa"));
                dsbs.setSubDesa(rs.getString("sub_desa"));
                dsbs.setNbs(rs.getString("nbs"));
                dsbs.setNks(rs.getString("nks"));
                dsbs.setSls(rs.getString("sls"));
                dsbs.setJenis_ubinan(rs.getInt("jenis_ubinan"));
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
    
    public static ArrayList<DSBS> getDSBS() throws Exception{
        ArrayList<DSBS> list = new ArrayList<>();
        Connections c = new Connections();
        try{
            c.getConnection().setAutoCommit(false);
            PreparedStatement ps = c.getConnection().prepareStatement(StringQuery.GET_DSBS_ALL);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                DSBS dsbs = new DSBS();
                dsbs.setTahun(rs.getInt("tahun"));
                dsbs.setSubround(rs.getInt("subround"));
                dsbs.setIdProv(rs.getString("id_prov"));
                dsbs.setNamaProv(rs.getString("nama_prov"));
                dsbs.setIdKab(rs.getString("id_kab"));
                dsbs.setNamaKab(rs.getString("nama_kab"));
                dsbs.setIdKec(rs.getString("id_kec"));
                dsbs.setNamaKec(rs.getString("nama_kec"));
                dsbs.setIdDesa(rs.getString("id_desa"));
                dsbs.setNamaDesa(rs.getString("nama_desa"));
                dsbs.setSubDesa(rs.getString("sub_desa"));
                dsbs.setNbs(rs.getString("nbs"));
                dsbs.setNks(rs.getString("nks"));
                dsbs.setSls(rs.getString("sls"));
                dsbs.setJenis_ubinan(rs.getInt("jenis_ubinan"));
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
    
    public static long importDSBS(String paths) throws Exception{
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
                DSBS dsbs = new DSBS();
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
                        if(i==14){
                            dsbs.setJenis_ubinan((int)Math.round(cell.getNumericCellValue()));
                        }
                    }else if(cell.getCellType()==HSSFCell.CELL_TYPE_STRING){
                        if(i==2){
                            dsbs.setIdProv(cell.getRichStringCellValue ().getString());
                        }
                        if(i==3){
                            dsbs.setNamaProv(cell.getRichStringCellValue ().getString());
                        }
                        if(i==4){
                            dsbs.setIdKab(cell.getRichStringCellValue ().getString());
                        }
                        if(i==5){
                            dsbs.setNamaKab(cell.getRichStringCellValue ().getString());
                        }
                        if(i==6){
                            dsbs.setIdKec(cell.getRichStringCellValue ().getString());
                        }
                        if(i==7){
                            dsbs.setNamaKec(cell.getRichStringCellValue ().getString());
                        }
                        if(i==8){
                            dsbs.setIdDesa(cell.getRichStringCellValue ().getString());
                        }
                        if(i==9){
                            dsbs.setNamaDesa(cell.getRichStringCellValue ().getString());
                        }
                        if(i==10){
                            dsbs.setSubDesa(cell.getRichStringCellValue ().getString());
                        }
                        if(i==11){
                            dsbs.setNbs(cell.getRichStringCellValue ().getString());
                        }
                        if(i==12){
                            dsbs.setNks(cell.getRichStringCellValue ().getString());
                        }
                        if(i==13){
                            dsbs.setSls(cell.getRichStringCellValue ().getString());
                        }
                    }
                    i++;
                }
                saveDSBS(dsbs);
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
    
    private static void saveDSBS(DSBS dsbs) throws Exception{
        Connections c = new Connections();
        try{
            c.getConnection().setAutoCommit(false);
            PreparedStatement ps = c.getConnection().prepareStatement(StringQuery.SAVE_DSBS);
            ps.setInt(1, dsbs.getTahun());
            ps.setInt(2, dsbs.getSubround());
            ps.setString(3, dsbs.getIdProv());
            ps.setString(4, dsbs.getNamaProv());
            ps.setString(5, dsbs.getIdKab());
            ps.setString(6, dsbs.getNamaKab());
            ps.setString(7, dsbs.getIdKec());
            ps.setString(8, dsbs.getNamaKec());
            ps.setString(9, dsbs.getIdDesa());
            ps.setString(10, dsbs.getNamaDesa());
            ps.setString(11, dsbs.getSubDesa());
            ps.setString(12, dsbs.getNbs());
            ps.setString(13, dsbs.getNks());
            ps.setString(14, dsbs.getSls());
            ps.setInt(15, dsbs.getJenis_ubinan());
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
    
    public static long deleteDSBS(int tahun,int subround,String idProv, String idKab, String nks) throws Exception {
        long in = 0;
        Connections c = new Connections();
        try {
            c.getConnection().setAutoCommit(false);
            PreparedStatement ps = c.getConnection().prepareStatement(StringQuery.DELETE_DSBS);
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
