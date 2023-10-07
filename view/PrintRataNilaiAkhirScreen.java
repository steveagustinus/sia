package view;

import javax.swing.JOptionPane;

import controller.Controller;
import model.Consts;

public class PrintRataNilaiAkhirScreen {
    public PrintRataNilaiAkhirScreen() {
        Controller controller = new Controller();

        String inputKodeMK = JOptionPane.showInputDialog(null, "Masukkan Kode MK");
        if (inputKodeMK == null) { return; }

        float na = controller.getNilaiAkhir(inputKodeMK);
        if (na == Consts.StatusGetNilaiAkhir.KODE_MATAKULIAH_TIDAK_ADA) {
            JOptionPane.showMessageDialog(
                null, 
                "Kode matakuliah tidak ditemukan",
                "Print Rata-rata Nilai Akhir",
                JOptionPane.ERROR_MESSAGE
            );
        } else {
            String message = "Rata-rata nilai akhir matakuliah dengan kode MK: " + inputKodeMK + " adalah " + na;
            JOptionPane.showMessageDialog(
                null,
                message,
                "Print Rata-rata Nilai Akhir",
                JOptionPane.INFORMATION_MESSAGE
            );
        }
    }
}
