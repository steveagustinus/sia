package model.staff;

import java.util.ArrayList;
import java.util.Date;

import model.presensi.PresensiStaff;

public class Karyawan extends Staff {
    private int salary;
    private ArrayList<PresensiStaff> presensiStaff;

    public Karyawan() { }

    public Karyawan(String nama, String alamat, Date tanggalLahir, String tempatLahir, String nomorTelepon, String nik, int salary, ArrayList<PresensiStaff> presensiStaff) {
        super(nama, alamat, tanggalLahir, tempatLahir, nomorTelepon, nik);
        this.salary = salary;
        this.presensiStaff = presensiStaff;
    }

    public int getSalary() {
        return this.salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public ArrayList<PresensiStaff> getPresensiStaff() {
        return this.presensiStaff;
    }

    public void setPresensiStaff(ArrayList<PresensiStaff> presensiStaff) {
        this.presensiStaff = presensiStaff;
    }
}
