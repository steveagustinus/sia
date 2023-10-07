package view;

import javax.swing.JOptionPane;

import controller.Controller;
import model.mahasiswa.*;
import model.MatkulAmbil;
import model.matakuliah.*;

public class PrintMatakuliahAmbilMahasiswaScreen {
    public PrintMatakuliahAmbilMahasiswaScreen() {
        Controller controller = new Controller();

        String inputNIM = JOptionPane.showInputDialog(null, "Masukkan NIM");
        if (inputNIM == null) { return; }

        Mahasiswa mhs = controller.getMahasiswaByNIM(inputNIM);
        if (mhs == null) {
            JOptionPane.showMessageDialog(
                null,
                "Mahasiswa dengan NIM " + inputNIM + " tidak ditemukan!",
                "Print Matakuliah Ambil Mahasiswa",
                JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        if (!(mhs instanceof MahasiswaSarjana)) {
            JOptionPane.showMessageDialog(
                null,
                "Mahasiswa dengan NIM " + inputNIM + " tidak memiliki list presensi",
                "Print Matakuliah Ambil Mahasiswa",
                JOptionPane.ERROR_MESSAGE
            );
            return;
        }
        
        String message = mhs.getNim() + " - " + mhs.getNama();
        for (MatkulAmbil mkAmbil : ((MahasiswaSarjana) mhs).getMataKuliahAmbil()) {
            Object mk = mkAmbil.getMataKuliahDiambil();

            if (mk instanceof MataKuliah) {
                message += "\r\n\r\nMatakuliah: " + ((MataKuliah)mk).getNama();
            } else if (mk instanceof MataKuliahPilihan) {
                message += "\r\n\r\nMatakuliah: " + ((MataKuliahPilihan)mk).getNama();
            }
            message += "\r\n" + mkAmbil.printListPresensi();
        }

        JOptionPane.showMessageDialog(
            null,
            message,
            "Print Matakuliah Mahasiswa",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
}
