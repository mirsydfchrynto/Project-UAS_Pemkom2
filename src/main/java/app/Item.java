package app;

import java.io.Serializable;

public class Item implements Serializable {
    private String nama;
    private String kategori;
    private String tanggalBeli;
    private String kondisi;

    // constructor
    public Item(String nama, String kategori, String tanggalBeli, String kondisi) {
        this.nama = nama;
        this.kategori = kategori;
        this.tanggalBeli = tanggalBeli;
        this.kondisi = kondisi;
    }

    // getter
    public String getNama() {
        return nama;
    }

    public String getKategori() {
        return kategori;
    }

    public String getTanggalBeli() {
        return tanggalBeli;
    }

    public String getKondisi() {
        return kondisi;
    }
}
