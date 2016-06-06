/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package id.go.bps.sambas.kalbar.sutp2016.db;

/**
 *
 * @author dekteguh
 */
public class StringQuery {
    public static final String GET_DSBS = "SELECT * FROM dsbs_ubinan where tahun=? AND subround=? AND id_prov=? AND id_kab=? ORDER BY tahun,subround,id_prov,id_kab,id_kec,id_desa asc";
    public static final String GET_DSBS_ALL = "SELECT * FROM dsbs_ubinan ORDER BY tahun,subround desc";
    public static final String GET_DSRT = "SELECT * FROM dsrt_ubinan where tahun=? AND subround=? AND id_prov=? AND id_kab=? AND nks=? ORDER BY tahun,subround,id_prov,id_kab,nks asc";
    public static final String GET_RUTA = "SELECT * FROM dsrt_ubinan where tahun=? AND subround=? AND id_prov=? AND id_kab=? AND nks=? AND nurt_sampel=?";
    public static final String GET_DSRT_ALL = "SELECT * FROM dsrt_ubinan ORDER BY tahun,subround,id_prov,id_kab,nks ASC";
    public static final String SAVE_DSRT = "INSERT INTO dsrt_ubinan values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    public static final String UPDATE_DSRT = "UPDATE dsrt_ubinan SET realisasi_panen=?, berhasil_panen=?, alasan_tidak_berhasil_panen=?,ubinan_bersama=?,hasil_ubinan=?,username=? WHERE tahun=? AND subround=? AND id_prov=? AND id_kab=? AND nks=? AND nurt_sampel=?";
    public static final String SAVE_DSRT_AWAL = "INSERT INTO dsrt_ubinan(tahun,subround,id_prov,id_kab,nks,ar,nurt_sampel,bf,bs,nurt_listing,nama_krt,jenis_tanaman,perkiraan_panen,jenis_sampel,pcl,pml) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    public static final String DELETE_DSRT = "DELETE FROM dsrt_ubinan WHERE tahun=? AND subround=? AND id_prov=? AND id_kab=? AND nks=? AND nurt_sampel=?";
    public static final String GET_PETUGAS = "SELECT * FROM petugas_ubinan WHERE tahun=? AND subround=? AND id_prov=? AND id_kab=? AND nks=? ORDER BY tahun,subround,id_prov,id_kab,nks";
    public static final String GET_PETUGAS_ALL = "SELECT * FROM petugas_ubinan ORDER BY tahun,subround,id_prov,id_kab,nks";
    public static final String SAVE_PETUGAS = "INSERT INTO petugas_ubinan values(?,?,?,?,?,?,?)";
    public static final String DELETE_DSBS = "DELETE FROM dsbs_ubinan WHERE tahun=? AND subround=? AND id_prov=? AND id_kab=? AND nks=?";
    public static final String DELETE_PETUGAS = "DELETE FROM petugas_ubinan WHERE tahun=? AND subround=? AND id_prov=? AND id_kab=? AND nks=?";
    public static final String SAVE_DSBS = "INSERT INTO dsbs_ubinan values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    
    
    //PROGRESS
    //public static final String PROGRESS = "SELECT d.tahun as tahun,d.subround as subround,d.id_prov as id_prov, s.nama_prov as nama_prov,d.id_kab as id_kab,s.nama_kab as nama_kab, d.nks as nks, count(berhasil_panen) as berhasil_panen FROM dsrt_ubinan d,dsbs_ubinan s WHERE d.tahun=s.tahun AND d.subround=s.subround AND d.id_prov=s.id_prov AND d.id_kab=s.id_kab AND d.nks=s.nks AND berhasil_panen=1 group by d.tahun,d.subround,d.id_prov,d.id_kab,d.nks";
    public static final String PROGRESS = "SELECT d.tahun as tahun,d.subround as subround,d.id_prov as id_prov, s.nama_prov as nama_prov,d.id_kab as id_kab,s.nama_kab as nama_kab, d.nks as nks, count(username)/count(nurt_sampel) as persentase FROM dsrt_ubinan d,dsbs_ubinan s WHERE d.tahun=s.tahun AND d.subround=s.subround AND d.id_prov=s.id_prov AND d.id_kab=s.id_kab AND d.nks=s.nks group by d.tahun,d.subround,d.id_prov,d.id_kab,d.nks";
    public static final String PROGRESS_ALL = "SELECT d.tahun as tahun,d.subround as subround,d.id_prov as id_prov, s.nama_prov as nama_prov,d.id_kab as id_kab,s.nama_kab as nama_kab, d.nks as nks, count(nurt_sampel) as jumlah_sampel FROM dsrt_ubinan d,dsbs_ubinan s WHERE d.tahun=s.tahun AND d.subround=s.subround AND d.id_prov=s.id_prov AND d.id_kab=s.id_kab AND d.nks=s.nks group by d.tahun,d.subround,d.id_prov,d.id_kab,d.nks";
    public static final String PROGRESS_PCL = "SELECT d.tahun as tahun,d.subround as subround,d.id_prov as id_prov, s.nama_prov as nama_prov,d.id_kab as id_kab,s.nama_kab as nama_kab,count(username)/count(nurt_sampel) as persentase,d.pcl as nama_pcl FROM dsrt_ubinan d,dsbs_ubinan s WHERE d.tahun=s.tahun AND d.subround=s.subround AND d.id_prov=s.id_prov AND d.id_kab=s.id_kab AND d.nks=s.nks group by d.tahun,d.subround,d.id_prov,d.id_kab,d.pcl";
    public static final String PROGRESS_KOMODITI = "SELECT d.tahun as tahun,d.subround as subround,d.id_prov as id_prov, s.nama_prov as nama_prov,d.id_kab as id_kab,s.nama_kab as nama_kab,count(username)/count(nurt_sampel) as persentase,d.jenis_tanaman as jenis_tanaman FROM dsrt_ubinan d,dsbs_ubinan s WHERE d.tahun=s.tahun AND d.subround=s.subround AND d.id_prov=s.id_prov AND d.id_kab=s.id_kab AND d.nks=s.nks group by d.tahun,d.subround,d.id_prov,d.id_kab,d.jenis_tanaman";
    
    public static final String LIST_NKS = "SELECT nks from dsbs_ubinan";
    //LOGIN OPERATOR
    public static final String LOGIN_OPERATOR = "SELECT * FROM operator_ubinan WHERE username=? and password=?";
    public static final String GET_OPERATOR = "SELECT * FROM operator_ubinan o, wilayah w WHERE o.id_prov=w.id_prov AND o.id_kab=w.id_kab";
    public static final String GET_OPERATOR_WHERE = "SELECT * FROM operator_ubinan o, wilayah w WHERE o.tahun=? AND o.subround=? AND o.id_prov=w.id_prov AND o.id_kab=w.id_kab";
    public static final String GET_OPERATOR_WHERE_USERNAME = "SELECT * FROM operator_ubinan o, wilayah w WHERE o.tahun=? AND o.subround=? AND o.username=? AND o.id_prov=w.id_prov AND o.id_kab=w.id_kab";

    public static final String INSERT_OPERATOR = "INSERT INTO operator_ubinan VALUES(?,?,?,?,?,?,?,?,?,?,?)";
    public static final String UPDATE_OPERATOR = "UPDATE operator_ubinan SET tahun=?,subround=?,id_prov=?,id_kab=?,nip=?,username=?,nama_operator=?,kategori_operator=?,jabatan=?,no_telp=?,password=? WHERE tahun=? AND subround=? AND username=?";
    public static final String DELETE_OPERATOR = "DELETE FROM operator_ubinan WHERE tahun=? AND subround=? AND username=?";
    
    public static final String GET_WILAYAH = "SELECT * FROM wilayah WHERE id_prov=? AND id_kab=?";
}
