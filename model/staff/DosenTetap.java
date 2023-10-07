package model.staff;

import java.util.Date;

public class DosenTetap extends Dosen {
    private int salary;

    public DosenTetap() { }

    public DosenTetap(String nama, String alamat, Date tanggalLahir, String tempatLahir, String nomorTelepon, String nik, String departemen, int salary) {
        super(nama, alamat, tanggalLahir, tempatLahir, nomorTelepon, nik, departemen);
        this.salary = salary;
    }

    public int getSalary() {
        return this.salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String toString() {
        return super.toString() + "\r\nsalary: " + this.salary;
    }
}
