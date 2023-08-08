package com.example.uas.network;

/*
    NIM     : 10122914
    Nama    : Dwi Nurcahyo
    Kelas   : AKB IF-10
 */

public class ApiServices {

    public static String BASEURL_PROV = "https://api-pesantren-indonesia.vercel.app/provinsi.json";
    public static String BASEURL_KAB = "https://api-pesantren-indonesia.vercel.app/kabupaten/{id_provinsi}.json";
    public static String BASEURL_PESANTREN = "https://api-pesantren-indonesia.vercel.app/pesantren/{id_kab_kota}.json";
}
