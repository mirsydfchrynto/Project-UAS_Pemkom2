package app;

import java.io.Serializable;

public class Item implements Serializable {
    private String nama;
    private String kategori;
    private String tanggalBeli;
    private String kondisi;
    private int jumlah;

    // Constructor
    public Item(String nama, String kategori, String tanggalBeli, String kondisi, int jumlah) {
        this.nama = nama;
        this.kategori = kategori;
        this.tanggalBeli = tanggalBeli;
        this.kondisi = kondisi;
        this.jumlah = jumlah;
    }

    // Getter
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

    public int getJumlah() {
        return jumlah;
    }

    // Setter
    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public void setTanggalBeli(String tanggalBeli) {
        this.tanggalBeli = tanggalBeli;
    }

    public void setKondisi(String kondisi) {
        this.kondisi = kondisi;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }
}
