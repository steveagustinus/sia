package model;

import java.util.Date;

import model.matakuliah.MataKuliah;
import model.matakuliah.MataKuliahPilihan;
import model.presensi.Presensi;

import java.util.ArrayList;

public class MatkulAmbil {
    private MataKuliah mataKuliahDiambil;
    private MataKuliahPilihan mataKuliahPilihanDiambil;
    private ArrayList<Presensi> listPresensi;
    private float[] nilai;

    public MatkulAmbil() { }

    public MatkulAmbil(MataKuliah mataKuliahDiambil) {
        this.mataKuliahDiambil = mataKuliahDiambil;
        this.listPresensi = new ArrayList<Presensi>();
        this.nilai = new float[] { -1f, -1f, -1f };
    }

    public MatkulAmbil(MataKuliahPilihan mataKuliahDiambil) {
        this.mataKuliahPilihanDiambil = mataKuliahDiambil;
        this.listPresensi = new ArrayList<Presensi>();
        this.nilai = new float[] { -1f, -1f, -1f };
    }

    public Object getMataKuliahDiambil() {
        if (this.mataKuliahDiambil != null) {
            return this.mataKuliahDiambil;
        }
        else if (this.mataKuliahPilihanDiambil != null) {
            return this.mataKuliahPilihanDiambil;
        }
        return null;
    }

    public ArrayList<Presensi> getListPresensi() {
        return this.listPresensi;
    }

    public void setListPresensi(ArrayList<Presensi> listPresensi) {
        this.listPresensi = listPresensi;
    }

    public void tambahKehadiran(Date tanggal, int status) {
        this.listPresensi.add(new Presensi(tanggal, status));
    }

    public String printListPresensi() {
        String output = "Data presensi";

        int count = 0;
        int hadir = 0;
        String temp = "";
        for (Presensi pres : this.listPresensi) {
            temp += "\r\n" + pres.toString();
            if (pres.getStatus() == Consts.StatusHadir.HADIR) { hadir++; }
            count++;
        }

        output += "\r\nKehadiran: (" + hadir + "/" + count + ")";
        output += temp;
        return output;
    }

    public float[] getNilai() {
        return this.nilai;
    }

    public String printNilai() {
        String output = "";

        for (int i = 0; i < this.nilai.length; i++) {
            output += "Nilai " + (i + 1) + ": ";
            if (this.nilai[i] == -1f) {
                 output += "Belum ada";
            } else {
                output += nilai[i];
            }
            
            if (i != this.nilai.length - 1) {
                output += "\r\n";
            }
        }

        return output;
    }

    public void setNilai(float[] nilai) {
        this.nilai = nilai;
    }

    public int setNilai(int nilaiKe, float nilai) {
        if (nilaiKe > this.nilai.length) { return -1; }

        this.nilai[nilaiKe - 1] = nilai;
        return 0;
    }

    public String toString() {
        String output = "";

        output += "mataKuliahDiambil: " + getMataKuliahDiambil().toString();
        output += "\r\n" + printListPresensi();
        output += "\r\n" + printNilai();

        return output;
    }
}
