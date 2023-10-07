package model.presensi;

import java.util.Date;

public class PresensiStaff extends Presensi {
    private int jam;

    public PresensiStaff() { }

    public PresensiStaff(Date tanggal, int status, int jam) {
        super(tanggal, status);
        this.jam = jam;
    }

    public int getJam() {
        return this.jam;
    }

    public void setJam(int jam) {
        this.jam = jam;
    }

    @Override
    public String toString() {
        return super.toString() + "\t jam: " + this.jam;
    }
}
