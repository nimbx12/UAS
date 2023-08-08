package com.example.uas.kabupaten;

import java.io.Serializable;

/*
    NIM     : 10122914
    Nama    : Dwi Nurcahyo
    Kelas   : AKB IF-10
 */

public class ModelKabupaten implements Serializable {

    String id;
    String nama;

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
}
