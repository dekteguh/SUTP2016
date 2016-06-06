/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package id.go.bps.sambas.kalbar.sutp2016.entity;

/**
 *
 * @author dekteguh
 */
public class DSBS {
    private Integer tahun;
    private Integer subround;
    private String idProv;
    private String namaProv;
    private String idKab;
    private String namaKab;
    private String idKec;
    private String namaKec;
    private String idDesa;
    private String namaDesa;
    private String subDesa;
    private String nbs;
    private String nks;
    private String sls;
    private Integer jenis_ubinan;

    public DSBS() {
    }

    public DSBS(Integer tahun, Integer subround, String idProv, String namaProv, String idKab, String namaKab, String idKec, String namaKec, String idDesa, String namaDesa, String subDesa, String nbs, String nks, String sls, Integer jenis_ubinan) {
        this.tahun = tahun;
        this.subround = subround;
        this.idProv = idProv;
        this.namaProv = namaProv;
        this.idKab = idKab;
        this.namaKab = namaKab;
        this.idKec = idKec;
        this.namaKec = namaKec;
        this.idDesa = idDesa;
        this.namaDesa = namaDesa;
        this.subDesa = subDesa;
        this.nbs = nbs;
        this.nks = nks;
        this.sls = sls;
        this.jenis_ubinan = jenis_ubinan;
    }

    public Integer getTahun() {
        return tahun;
    }

    public void setTahun(Integer tahun) {
        this.tahun = tahun;
    }

    public Integer getSubround() {
        return subround;
    }

    public void setSubround(Integer subround) {
        this.subround = subround;
    }

    public String getIdProv() {
        return idProv;
    }

    public void setIdProv(String idProv) {
        this.idProv = idProv;
    }

    public String getNamaProv() {
        return namaProv;
    }

    public void setNamaProv(String namaProv) {
        this.namaProv = namaProv;
    }

    public String getIdKab() {
        return idKab;
    }

    public void setIdKab(String idKab) {
        this.idKab = idKab;
    }

    public String getNamaKab() {
        return namaKab;
    }

    public void setNamaKab(String namaKab) {
        this.namaKab = namaKab;
    }

    public String getIdKec() {
        return idKec;
    }

    public void setIdKec(String idKec) {
        this.idKec = idKec;
    }

    public String getNamaKec() {
        return namaKec;
    }

    public void setNamaKec(String namaKec) {
        this.namaKec = namaKec;
    }

    public String getIdDesa() {
        return idDesa;
    }

    public void setIdDesa(String idDesa) {
        this.idDesa = idDesa;
    }

    public String getNamaDesa() {
        return namaDesa;
    }

    public void setNamaDesa(String namaDesa) {
        this.namaDesa = namaDesa;
    }

    public String getSubDesa() {
        return subDesa;
    }

    public void setSubDesa(String subDesa) {
        this.subDesa = subDesa;
    }

    public String getNbs() {
        return nbs;
    }

    public void setNbs(String nbs) {
        this.nbs = nbs;
    }

    public String getNks() {
        return nks;
    }

    public void setNks(String nks) {
        this.nks = nks;
    }

    public String getSls() {
        return sls;
    }

    public void setSls(String sls) {
        this.sls = sls;
    }

    public Integer getJenis_ubinan() {
        return jenis_ubinan;
    }

    public void setJenis_ubinan(Integer jenis_ubinan) {
        this.jenis_ubinan = jenis_ubinan;
    }    
}
