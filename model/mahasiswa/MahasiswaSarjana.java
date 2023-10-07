package model.mahasiswa;

import java.util.ArrayList;
import java.util.Date;

import model.matakuliah.*;
import model.MatkulAmbil;
import model.Enums;

public class MahasiswaSarjana extends Mahasiswa {
    // private ArrayList<MataKuliah> mataKuliah;
    // private ArrayList<MataKuliahPilihan> mataKuliahPilihan;
    private ArrayList<MatkulAmbil> mataKuliahAmbil;

    public MahasiswaSarjana() { }

    public MahasiswaSarjana(String nama, String alamat, Date tanggalLahir, String tempatLahir, String nomorTelepon, String nim, Enums.Jurusan jurusan) {
        super(nama, alamat, tanggalLahir, tempatLahir,nomorTelepon, nim, jurusan);
        this.mataKuliahAmbil = new ArrayList<MatkulAmbil>();
    }

    public ArrayList<MatkulAmbil> getMataKuliahAmbil() {
        return this.mataKuliahAmbil;
    }

    public void setMataKuliahAmbil(ArrayList<MatkulAmbil> mataKuliahAmbil) {
        this.mataKuliahAmbil = mataKuliahAmbil;
    }

    public void addMatkulAmbil(MataKuliah matkul) {
        mataKuliahAmbil.add(new MatkulAmbil(matkul));
    }

    public void addMatkulAmbil(MataKuliahPilihan matkul) {
        mataKuliahAmbil.add(new MatkulAmbil(matkul));
    }

    public ArrayList<MataKuliah> getMataKuliah() {
        ArrayList<MataKuliah> matkul = new ArrayList<MataKuliah>();
        for (MatkulAmbil x : this.mataKuliahAmbil) {
            if (x.getMataKuliahDiambil() instanceof MataKuliah) {
                matkul.add((MataKuliah) x.getMataKuliahDiambil());
            }
        }
        return matkul;
    }

    public ArrayList<MataKuliahPilihan> getMataKuliahPilihan() {
        ArrayList<MataKuliahPilihan> matkul = new ArrayList<MataKuliahPilihan>();
        for (MatkulAmbil mkAmbil : this.mataKuliahAmbil) {
            if (mkAmbil.getMataKuliahDiambil() instanceof MataKuliahPilihan) {
                matkul.add((MataKuliahPilihan) mkAmbil.getMataKuliahDiambil());
            }
        }
        return matkul;
    }

    public int hapusMataKuliahBerdasarkanKode(String kode) {
        for (MatkulAmbil mkAmbil : this.mataKuliahAmbil) {
            if (((MataKuliah) mkAmbil.getMataKuliahDiambil()).getKode().equals(kode)) {
                this.mataKuliahAmbil.remove(mkAmbil);
                return 0;
            }
            if (((MataKuliahPilihan) mkAmbil.getMataKuliahDiambil()).getKode().equals(kode)) {
                this.mataKuliahAmbil.remove(mkAmbil);
                return 0;
            }
        }

        return -1;
    }

    public String printMataKuliahAmbil() {
        String output = "List matakuliah: ";

        for (int i = 0; i < this.mataKuliahAmbil.size(); i++) {
            output += "\r\n" + this.mataKuliahAmbil.get(i).toString();
        }
        
        return output;
    }

    @Override
    public String toString() {
        return super.toString() + "\r\n" + printMataKuliahAmbil();
    }
}