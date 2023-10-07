package main;

import model.mahasiswa.*;
import model.Consts;
import model.Enums;
import model.matakuliah.*;
import model.presensi.*;
import model.staff.DosenTetap;
import model.staff.DosenHonorer;
import view.MainMenu;

import java.util.ArrayList;
import java.util.Date;

import controller.Controller;

public class Main {

    public static void main(String[] args) {
        inputDummy();
        new MainMenu();
    }

    public static void inputDummy() {
        Controller controller = new Controller();

        // List MataKuliah & MataKuliahPilihan
        ArrayList<MataKuliah> mataKuliah = new ArrayList<MataKuliah>();
        mataKuliah.add(new MataKuliah("IF-301", 3, "Pemrograman Berorientasi Objek"));
        mataKuliah.add(new MataKuliah("IF-302", 4, "Basis Data"));
        mataKuliah.add(new MataKuliah("IF-303", 3, "Sistem Berkas"));
        mataKuliah.add(new MataKuliah("IF-304", 3, "Strategi Algoritmik"));
        mataKuliah.add(new MataKuliah("IF-305", 3, "Matriks dan Ruang Vektor"));

        ArrayList<MataKuliahPilihan> mataKuliahPilihan = new ArrayList<MataKuliahPilihan>();
        mataKuliahPilihan.add(new MataKuliahPilihan("P1-135", 2, "SAP ERP - Introduction", 10));
        mataKuliahPilihan.add(new MataKuliahPilihan("P2-100", 0, "Leadership and Entrepreneurship", 5));
        mataKuliahPilihan.add(new MataKuliahPilihan("P1-182", 2, "AWS Academy Cloud Foundation", 10));

        // Masukkan ke controller
        controller.insertMataKuliah(mataKuliah);
        controller.insertMataKuliahPilihan(mataKuliahPilihan);

        MahasiswaSarjana mhs1 = new MahasiswaSarjana(
            "Andi", 
            "Jl. Dipatiukur no. 8",
            new Date(1051111111000L),
            "Bandung",
            "08183664970",
            "1122999",
            Enums.Jurusan.Informatika
        );

        controller.insertUser(mhs1);
        controller.insertMataKuliahToMahasiswa(mataKuliah.get(0), mhs1);
        controller.insertMataKuliahToMahasiswa(mataKuliah.get(3), mhs1);
        controller.insertMataKuliahToMahasiswa(mataKuliahPilihan.get(1), mhs1);
        controller.tambahKehadiranMahasiswa(mhs1.getNim(), mataKuliah.get(0).getKode(), new Presensi(new Date(1691758800000L), Consts.StatusHadir.HADIR));
        controller.tambahKehadiranMahasiswa(mhs1.getNim(), mataKuliah.get(0).getKode(), new Presensi(new Date(1692363600000L), Consts.StatusHadir.HADIR));
        controller.tambahKehadiranMahasiswa(mhs1.getNim(), mataKuliah.get(0).getKode(), new Presensi(new Date(1692968400000L), Consts.StatusHadir.ALPHA));
        

        MahasiswaMagister mhs2 = new MahasiswaMagister(
            "Budi",
            "Jln. Jendral Sudirman no. 55",
            new Date(1061119374992L),
            "Jakarta",
            "0853997409224",
            "1118001",
            Enums.Jurusan.Informatika,
            "Dampak AI di Masa Mendatang"
        );

        controller.insertUser(mhs2);
        controller.insertMataKuliahToMahasiswa(mataKuliah.get(1), mhs2);
        controller.insertMataKuliahToMahasiswa(mataKuliah.get(3), mhs2);
        controller.insertMataKuliahToMahasiswa(mataKuliah.get(4), mhs2);
        controller.insertMataKuliahToMahasiswa(mataKuliahPilihan.get(1), mhs2);

        // Makasiswa Doktor
        MahasiswaDoktor mhs3 = new MahasiswaDoktor(
            "Caca",
            "Jln. Ir. H. Juanda no. 124",
            new Date(1061519994992L),
            "Bandung",
            "081733948377",
            "1115042",
            Enums.Jurusan.Informatika,
            "Cara menanam jagung yang baik"
        );
        mhs3.setNilaiSidang(1, 78.3f);
        mhs3.setNilaiSidang(2, 88.0f);

        controller.insertUser(mhs3);

        DosenTetap dosen1 = new DosenTetap(
            "Dedi",
            "Jln. Pagarsih no. 5",
            new Date(103849993886L),
            "Bandung",
            "085982293608",
            "123",
            "Informatika",
            5000000
        );

        controller.insertUser(dosen1);
        controller.insertMataKuliahToDosen(mataKuliah.get(0), dosen1);
        controller.insertMataKuliahToDosen(mataKuliahPilihan.get(0), dosen1);
        controller.tambahKehadiranDosen(dosen1.getNik(), mataKuliahPilihan.get(0).getKode(), new PresensiStaff(new Date(1691758800000L), Consts.StatusHadir.HADIR, 2));
        controller.tambahKehadiranDosen(dosen1.getNik(), mataKuliahPilihan.get(0).getKode(), new PresensiStaff(new Date(1692363600000L), Consts.StatusHadir.ALPHA, 0));
        controller.tambahKehadiranDosen(dosen1.getNik(), mataKuliahPilihan.get(0).getKode(), new PresensiStaff(new Date(1692968400000L), Consts.StatusHadir.ALPHA, 0));

        // DosenHonorer
        DosenHonorer dosen2 = new DosenHonorer(
            "Andi",
            "Jln. Kopo no. 255",
            new Date(233849693886L),
            "Bandung",
            "08168994000",
            "124",
            "Informatika",
            500000
        );

        controller.insertUser(dosen2);
        controller.insertMataKuliahToDosen(mataKuliah.get(2), dosen2);
        controller.insertMataKuliahToDosen(mataKuliahPilihan.get(2), dosen2);
        controller.tambahKehadiranDosen(dosen2.getNik(), mataKuliah.get(2).getKode(), new PresensiStaff(new Date(1692968400000L), Consts.StatusHadir.HADIR, 3));

    }
}