package model;

import java.util.Date;

public abstract class User {
    private String nama;
    private String alamat;
    private Date tanggalLahir;
    private String tempatLahir;
    private String nomorTelepon;

    public User() { }

    public User(String nama, String alamat, Date tanggalLahir, String tempatLahir, String nomorTelepon) {
        this.nama = nama;
        this.alamat = alamat;
        this.tanggalLahir = tanggalLahir;
        this.tempatLahir = tempatLahir;
        this.nomorTelepon = nomorTelepon;
    }

    public String getNama() {
        return this.nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return this.alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public Date getTanggalLahir() {
        return this.tanggalLahir;
    }

    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getTempatLahir() {
        return this.tempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }

    public String getNomorTelepon() {
        return this.nomorTelepon;
    }

    public void setNomorTelepon(String nomorTelepon) {
        this.nomorTelepon = nomorTelepon;
    }

    public String toString() {
        return "nama: " + this.nama + "\r\nalamat: " + this.alamat + "\r\ntanggalLahir: " + this.tanggalLahir.toString() + "\r\ntempatLahir: " + this.tempatLahir + "\r\nnomorTelepon: " + this.nomorTelepon;
    }
}
