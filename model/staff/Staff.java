package model.staff;

import java.util.Date;

import model.User;

public abstract class Staff extends User {
    private String nik;

    public Staff() { }
    public Staff(String nama, String alamat, Date tanggalLahir, String tempatLahir, String nomorTelepon, String nik) {
        super(nama, alamat, tanggalLahir, tempatLahir, nomorTelepon);
        this.nik = nik;
    }

    public String getNik() {
        return this.nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    @Override
    public String toString() {
        return super.toString() + "\r\nnik: " + this.nik;
    }
}
