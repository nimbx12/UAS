package com.example.uas.pesantren;

import java.io.Serializable;

/*
    NIM     : 10122914
    Nama    : Dwi Nurcahyo
    Kelas   : AKB IF-10
 */

public class ModelPesantren implements Serializable {

    String id;
    String nama;
    String nspp;
    String alamat;
    String kyai;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNspp() {
        return nspp;
    }

    public void setNspp(String nspp) {
        this.nspp = nspp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKyai() {
        return kyai;
    }

    public void setKyai(String kyai) {
        this.kyai = kyai;
    }
}

