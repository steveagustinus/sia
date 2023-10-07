package model.presensi;

import java.util.Date;

import model.Consts;

public class Presensi {
    private Date tanggal;
    private int status;

    public Presensi() { }

    public Presensi(Date tanggal, int status) {
        this.tanggal = tanggal;
        this.status = status;
    }
    
    public Date getTanggal() {
        return this.tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String printStatus() {
        switch (this.status) {
            case Consts.StatusHadir.HADIR: return "Hadir";
            case Consts.StatusHadir.ALPHA: return "Alpha";
        }

        return "";
    }

    public String toString() {
        return "tanggal: " + this.tanggal.toString() + "\t status: " + printStatus();
    }
}
