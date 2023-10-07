package model.mahasiswa;

import model.Enums;
import model.User;

import java.util.Date;

public abstract class Mahasiswa extends User {
    private String nim;
    private Enums.Jurusan jurusan;

    public Mahasiswa() { }

    public Mahasiswa(String nama, String alamat, Date tanggalLahir, String tempatLahir, String nomorTelepon, String nim, Enums.Jurusan jurusan) {
        super(nama, alamat, tanggalLahir, tempatLahir, nomorTelepon);
        this.nim = nim;
        this.jurusan = jurusan;
    }

    public String getNim() {
        return this.nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getJurusan() {
        switch(this.jurusan) {
            case Informatika: return "Informatika";
            case Sistem_Informasi: return "Sistem Informasi";
            case Teknik_Industri: return "Teknik Industri";
            case Desain_Komunikasi_Visual: return "Desain Komunikasi Visual";
            case Akuntansi: return "Akuntansi";
            case Online_Business: return "Online Bussiness";
            case Manajemen: return "Manajemen";
        }

        return null;
    }

    public void setJurusan(Enums.Jurusan jurusan) {
        this.jurusan = jurusan;
    }

    @Override
    public String toString() {
        return super.toString() + "\r\nnim: " + this.nim + "\r\njurusan: " + getJurusan();
    }
}
