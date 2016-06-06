/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package id.go.bps.sambas.kalbar.sutp2016.functions;

import id.go.bps.sambas.kalbar.sutp2016.db.Connections;
import id.go.bps.sambas.kalbar.sutp2016.db.StringQuery;
import id.go.bps.sambas.kalbar.sutp2016.entity.DSRT;
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
public class DSRTService {
    public static ArrayList<DSRT> getDSRT(int tahun, int subround, String idProv, String idKab, String nks) throws Exception{
        ArrayList<DSRT> list = new ArrayList<>();
        Connections c = new Connections();
        try{
            c.getConnection().setAutoCommit(false);
            PreparedStatement ps = c.getConnection().prepareStatement(StringQuery.GET_DSRT);
            ps.setInt(1, tahun);
            ps.setInt(2, subround);
            ps.setString(3, idProv);
            ps.setString(4, idKab);
            ps.setString(5, nks);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                DSRT dsrt = new DSRT();
                dsrt.setTahun(rs.getInt("tahun"));
                dsrt.setSubround(rs.getInt("subround"));
                dsrt.setIdProv(rs.getString("id_prov"));
                dsrt.setIdKab(rs.getString("id_kab"));
                dsrt.setNks(rs.getString("nks"));
                dsrt.setPcl(rs.getString("pcl"));
                dsrt.setPml(rs.getString("pml"));
                dsrt.setAR(rs.getDouble("ar"));
                dsrt.setNurtSampel(rs.getInt("nurt_sampel"));
                dsrt.setBF(rs.getString("bf"));
                dsrt.setBS(rs.getString("bs"));
                dsrt.setNurtListing(rs.getInt("nurt_listing"));
                dsrt.setNamaKrt(rs.getString("nama_krt"));
                dsrt.setJenisTanaman(rs.getString("jenis_tanaman"));
                dsrt.setPerkiraanPanen(rs.getInt("perkiraan_panen"));
                dsrt.setJenisSampel(rs.getString("jenis_sampel"));
                dsrt.setRealisasiPanen(rs.getInt("realisasi_panen"));
                dsrt.setBerhasilPanen(rs.getInt("berhasil_panen"));
                dsrt.setAlasanTidakBerhasilPanen(rs.getString("alasan_tidak_berhasil_panen"));
                dsrt.setUbinanBersama(rs.getInt("ubinan_bersama"));
                dsrt.setHasilUbinan(rs.getDouble("hasil_ubinan"));
                dsrt.setUsername(rs.getString("username"));
                list.add(dsrt);
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
    
    public static DSRT getRuta(int tahun, int subround, String idProv, String idKab, String nks, int nurt) throws Exception{
        DSRT dsrt = null;
        Connections c = new Connections();
        try{
            c.getConnection().setAutoCommit(false);
            PreparedStatement ps = c.getConnection().prepareStatement(StringQuery.GET_RUTA);
            ps.setInt(1, tahun);
            ps.setInt(2, subround);
            ps.setString(3, idProv);
            ps.setString(4, idKab);
            ps.setString(5, nks);
            ps.setInt(6, nurt);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                dsrt = new DSRT();
                dsrt.setTahun(rs.getInt("tahun"));
                dsrt.setSubround(rs.getInt("subround"));
                dsrt.setIdProv(rs.getString("id_prov"));
                dsrt.setIdKab(rs.getString("id_kab"));
                dsrt.setNks(rs.getString("nks"));
                dsrt.setPcl(rs.getString("pcl"));
                dsrt.setPml(rs.getString("pml"));
                dsrt.setAR(rs.getDouble("ar"));
                dsrt.setNurtSampel(rs.getInt("nurt_sampel"));
                dsrt.setBF(rs.getString("bf"));
                dsrt.setBS(rs.getString("bs"));
                dsrt.setNurtListing(rs.getInt("nurt_listing"));
                dsrt.setNamaKrt(rs.getString("nama_krt"));
                dsrt.setJenisTanaman(rs.getString("jenis_tanaman"));
                dsrt.setPerkiraanPanen(rs.getInt("perkiraan_panen"));
                dsrt.setJenisSampel(rs.getString("jenis_sampel"));
                dsrt.setRealisasiPanen(rs.getInt("realisasi_panen"));
                dsrt.setBerhasilPanen(rs.getInt("berhasil_panen"));
                dsrt.setAlasanTidakBerhasilPanen(rs.getString("alasan_tidak_berhasil_panen"));
                dsrt.setUbinanBersama(rs.getInt("ubinan_bersama"));
                dsrt.setHasilUbinan(rs.getDouble("hasil_ubinan"));
                dsrt.setUsername(rs.getString("username"));
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
        return dsrt;
    }
    
    public static ArrayList<DSRT> getDSRT() throws Exception{
        ArrayList<DSRT> list = new ArrayList<>();
        Connections c = new Connections();
        try{
            c.getConnection().setAutoCommit(false);
            PreparedStatement ps = c.getConnection().prepareStatement(StringQuery.GET_DSRT_ALL);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                DSRT dsrt = new DSRT();
                dsrt.setTahun(rs.getInt("tahun"));
                dsrt.setSubround(rs.getInt("subround"));
                dsrt.setIdProv(rs.getString("id_prov"));
                dsrt.setIdKab(rs.getString("id_kab"));
                dsrt.setNks(rs.getString("nks"));
                dsrt.setPcl(rs.getString("pcl"));
                dsrt.setPml(rs.getString("pml"));
                dsrt.setAR(rs.getDouble("ar"));
                dsrt.setNurtSampel(rs.getInt("nurt_sampel"));
                dsrt.setBF(rs.getString("bf"));
                dsrt.setBS(rs.getString("bs"));
                dsrt.setNurtListing(rs.getInt("nurt_listing"));
                dsrt.setNamaKrt(rs.getString("nama_krt"));
                dsrt.setJenisTanaman(rs.getString("jenis_tanaman"));
                dsrt.setPerkiraanPanen(rs.getInt("perkiraan_panen"));
                dsrt.setJenisSampel(rs.getString("jenis_sampel"));
                dsrt.setRealisasiPanen(rs.getInt("realisasi_panen"));
                dsrt.setBerhasilPanen(rs.getInt("berhasil_panen"));
                dsrt.setAlasanTidakBerhasilPanen(rs.getString("alasan_tidak_berhasil_panen"));
                dsrt.setUbinanBersama(rs.getInt("ubinan_bersama"));
                dsrt.setHasilUbinan(rs.getDouble("hasil_ubinan"));
                dsrt.setUsername(rs.getString("username"));
                list.add(dsrt);
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
    
    public static long importDSRT(String paths) throws Exception{
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
                DSRT dsrt = new DSRT();
                int i = 0;
                while(cells.hasNext()){
                    HSSFCell cell = (HSSFCell) cells.next();
                    //cell 1, tahun
                    if(cell.getCellType()==HSSFCell.CELL_TYPE_NUMERIC){
                        //tahun
                        if(i==0){
                            dsrt.setTahun((int)Math.round(cell.getNumericCellValue()));
                        }
                        //subround
                        if(i==1){
                            dsrt.setSubround((int)Math.round(cell.getNumericCellValue()));
                        }
                        //nurt sampel
                        if(i==6){
                            dsrt.setNurtSampel((int)Math.round(cell.getNumericCellValue()));
                        }
                        //nurt listing
                        if(i==9){
                            dsrt.setNurtListing((int)Math.round(cell.getNumericCellValue()));
                        }
                        //bulan panen
                        if(i==12){
                            dsrt.setPerkiraanPanen((int)Math.round(cell.getNumericCellValue()));
                        }
                        //ar
                        if(i==5){
                            dsrt.setAR(cell.getNumericCellValue());
                        }
                    }else if(cell.getCellType()==HSSFCell.CELL_TYPE_STRING){
                        //id_prov
                        if(i==2){
                            dsrt.setIdProv(cell.getRichStringCellValue ().getString());
                        }
                        //id_kab
                        if(i==3){
                            dsrt.setIdKab(cell.getRichStringCellValue ().getString());
                        }
                        //nks
                        if(i==4){
                            dsrt.setNks(cell.getRichStringCellValue ().getString());
                        }
                        //bf
                        if(i==7){
                            dsrt.setBF(cell.getRichStringCellValue ().getString());
                        }
                        //bs
                        if(i==8){
                            dsrt.setBS(cell.getRichStringCellValue ().getString());
                        }
                        //nama krt
                        if(i==10){
                            dsrt.setNamaKrt(cell.getRichStringCellValue ().getString());
                        }
                        //jenis tanaman
                        if(i==11){
                            dsrt.setJenisTanaman(cell.getRichStringCellValue ().getString());
                        }
                        //jenis sampel
                        if(i==13){
                            dsrt.setJenisSampel(cell.getRichStringCellValue ().getString());
                        }
                        //pcl
                        if(i==14){
                            dsrt.setPcl(cell.getRichStringCellValue ().getString());
                        }
                        //pml
                        if(i==15){
                            dsrt.setPml(cell.getRichStringCellValue ().getString());
                        }
                    }
                    i++;
                }
                saveDSRT_AWAL(dsrt);
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
    
    private static void saveDSRT_AWAL(DSRT dsrt) throws Exception{
        Connections c = new Connections();
        try{
            c.getConnection().setAutoCommit(false);
            PreparedStatement ps = c.getConnection().prepareStatement(StringQuery.SAVE_DSRT_AWAL);
            ps.setInt(1, dsrt.getTahun());
            ps.setInt(2, dsrt.getSubround());
            ps.setString(3, dsrt.getIdProv());
            ps.setString(4, dsrt.getIdKab());
            ps.setString(5, dsrt.getNks());
            ps.setDouble(6, dsrt.getAR());
            ps.setInt(7, dsrt.getNurtSampel());
            ps.setString(8, dsrt.getBF());
            ps.setString(9, dsrt.getBS());
            ps.setInt(10, dsrt.getNurtListing());
            ps.setString(11, dsrt.getNamaKrt());
            ps.setString(12, dsrt.getJenisTanaman());
            ps.setInt(13, dsrt.getPerkiraanPanen());
            ps.setString(14, dsrt.getJenisSampel());
            ps.setString(15, dsrt.getPcl());
            ps.setString(16, dsrt.getPml());
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
    
    private static void saveDSRT(DSRT dsrt) throws Exception{
        Connections c = new Connections();
        try{
            c.getConnection().setAutoCommit(false);
            PreparedStatement ps = c.getConnection().prepareStatement(StringQuery.SAVE_DSRT);
            ps.setInt(1, dsrt.getTahun());
            ps.setInt(2, dsrt.getSubround());
            ps.setString(3, dsrt.getIdProv());
            ps.setString(4, dsrt.getIdKab());
            ps.setString(5, dsrt.getNks());
            ps.setString(6, dsrt.getPcl());
            ps.setString(7, dsrt.getPml());
            ps.setDouble(8, dsrt.getAR());
            ps.setInt(9, dsrt.getNurtSampel());
            ps.setString(10, dsrt.getBF());
            ps.setString(11, dsrt.getBS());
            ps.setInt(12, dsrt.getNurtListing());
            ps.setString(13, dsrt.getNamaKrt());
            ps.setString(14, dsrt.getJenisTanaman());
            ps.setInt(15, dsrt.getPerkiraanPanen());
            ps.setString(16, dsrt.getJenisSampel());
            ps.setInt(17, dsrt.getRealisasiPanen());
            ps.setInt(18, dsrt.getBerhasilPanen());
            ps.setString(19, dsrt.getAlasanTidakBerhasilPanen());
            ps.setInt(20, dsrt.getUbinanBersama());
            ps.setDouble(21, dsrt.getHasilUbinan());
            ps.setString(22, dsrt.getUsername());
            
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
    
    public static long updateDSRT(DSRT dsrt) throws Exception{
        long in = 0;
        Connections c = new Connections();
        try{
            c.getConnection().setAutoCommit(false);
            PreparedStatement ps = c.getConnection().prepareStatement(StringQuery.UPDATE_DSRT);
            ps.setInt(7, dsrt.getTahun());
            ps.setInt(8, dsrt.getSubround());
            ps.setString(9, dsrt.getIdProv());
            ps.setString(10, dsrt.getIdKab());
            ps.setString(11, dsrt.getNks());
            ps.setInt(12, dsrt.getNurtSampel());
            ps.setInt(1, dsrt.getRealisasiPanen());
            ps.setInt(2, dsrt.getBerhasilPanen());
            ps.setString(3, dsrt.getAlasanTidakBerhasilPanen());
            ps.setInt(4, dsrt.getUbinanBersama());
            ps.setDouble(5, dsrt.getHasilUbinan());
            ps.setString(6, dsrt.getUsername());
            
            ps.executeUpdate();
            
            c.getConnection().commit();
            in  =1;
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
        return in;
    }
    
    public static long deleteDSRT(int tahun,int subround,String idProv, String idKab, String nks, int nurt) throws Exception {
        long in = 0;
        Connections c = new Connections();
        try {
            c.getConnection().setAutoCommit(false);
            PreparedStatement ps = c.getConnection().prepareStatement(StringQuery.DELETE_DSRT);
            ps.setInt(1, tahun);
            ps.setInt(2, subround);
            ps.setString(3, idProv);
            ps.setString(4, idKab);
            ps.setString(5, nks);
            ps.setInt(6, nurt);
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
