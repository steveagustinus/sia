package view;

import javax.swing.JOptionPane;
import model.Consts;
import controller.Controller;

public class PrintNilaiAkhirScreen {
    public PrintNilaiAkhirScreen() {
        Controller controller = new Controller();

        int progress = 1;
        String inputNIM = "";
        String inputKodeMK = "";

        menu:while (progress != 0) {
            switch (progress) {
                case 1:
                inputNIM = JOptionPane.showInputDialog(null, "Masukkan NIM");
                if (inputNIM == null) { progress--; break; }
                if (!inputNIM.equals("")) { progress++; }
                break;

                case 2:
                inputKodeMK = JOptionPane.showInputDialog(null, "Masukkan Kode MK\r\n*Note: Kosongkan jika mahasiswa sedang menempuh program doktor");
                if (inputKodeMK == null) { progress--; break; } else { progress++; }
                break;

                case 3:
                break menu;
            }
        }

        if (progress != 0) {
            String output = "";
            float nilaiAkhir = controller.getNilaiAkhirMahasiswa(inputNIM, inputKodeMK);
            if (nilaiAkhir == Consts.StatusGetNilaiAkhirMahasiswa.MAHASISWA_TIDAK_DITEMUKAN) {
                output = "Mahasiswa dengan NIM " + inputNIM + " tidak ditemukan!";
            } else if (nilaiAkhir == Consts.StatusGetNilaiAkhirMahasiswa.TIDAK_MENGAMBIL_MATAKULIAH_BERSANGKUTAN) {
                output = "Mahasiswa yang dicari tidak mengambil matakuliah dengan kode MK: " + inputKodeMK;
            } else if (nilaiAkhir == Consts.StatusGetNilaiAkhirMahasiswa.BUKAN_MERUPAKAN_MAHASISWA) {
                output = "NIM yang diinput tidak valid atau bukan merupakan mahasiswa";
            } else {
                if (inputKodeMK.equals("")) {
                    output = "NIM: " + inputNIM + "\r\nNilai Akhir Sidang: " + nilaiAkhir;
                } else {
                    output = "NIM: " + inputNIM + "\r\nKode MK: " + inputKodeMK + "\r\nNilai Akhir: " + nilaiAkhir;
                }
                
                JOptionPane.showMessageDialog(
                    null, 
                    output,
                    "Print Nilai Akhir",
                    JOptionPane.INFORMATION_MESSAGE
                );
                return;
            }

            JOptionPane.showMessageDialog(
                null, 
                output,
                "Print Nilai Akhir",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
