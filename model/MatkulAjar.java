package model;

import model.matakuliah.MataKuliah;
import model.matakuliah.MataKuliahPilihan;
import model.presensi.PresensiStaff;

import java.util.ArrayList;
import java.util.Date;

public class MatkulAjar {
    private MataKuliah mataKuliahDiajar;
    private MataKuliahPilihan mataKuliahPilihanDiajar;
    private ArrayList<PresensiStaff> listPresensi;

    public MatkulAjar() { }

    public MatkulAjar(MataKuliah mataKuliahDiajar) {
        this.mataKuliahDiajar = mataKuliahDiajar;
        this.listPresensi = new ArrayList<PresensiStaff>();
    }

    public MatkulAjar(MataKuliahPilihan mataKuliahDiajar) {
        this.mataKuliahPilihanDiajar = mataKuliahDiajar;
        this.listPresensi = new ArrayList<PresensiStaff>();
    }

    public Object getMataKuliahDiajar() {
        if (this.mataKuliahDiajar != null) {
            return this.mataKuliahDiajar;
        }
        else if (this.mataKuliahPilihanDiajar != null) {
            return this.mataKuliahPilihanDiajar;
        }
        return null;
    }

    public ArrayList<PresensiStaff> getListPresensi() {
        return this.listPresensi;
    }

    public void setListPresensi(ArrayList<PresensiStaff> listPresensi) {
        this.listPresensi = listPresensi;
    }

    public void tambahKehadiran(Date tanggal, int status, int jam) {
        this.listPresensi.add(new PresensiStaff(tanggal, status, jam));
    }

    public String printListPresensi() {
        String output = "Data presensi";

        int count = 0;
        int hadir = 0;
        String temp = "";
        for (PresensiStaff pres : this.listPresensi) {
            temp += "\r\n" + pres.toString();
            if (pres.getStatus() == Consts.StatusHadir.HADIR) { hadir++; }
            count++;
        }

        output += "\r\nKehadiran: (" + hadir + "/" + count + ")";
        output += temp;
        return output;
    }

    public String toString() {
        String output = "";

        output += "mataKuliahDiajar: " + getMataKuliahDiajar().toString();
        output += "\r\n" + printListPresensi();

        return output;
    }
}
