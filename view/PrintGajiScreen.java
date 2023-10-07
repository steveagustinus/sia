package view;

import javax.swing.JOptionPane;
import controller.Controller;
import model.staff.*;

public class PrintGajiScreen {
    public PrintGajiScreen() {
        Controller controller = new Controller();
        
        String inputNIK = JOptionPane.showInputDialog(null, "Masukkan NIK");
        if (inputNIK == null) { return; }

        Staff staff = controller.getStaffByNIK(inputNIK);
        if (staff == null) { 
            JOptionPane.showMessageDialog(
                null, 
                "Staff dengan NIK " + inputNIK + " tidak ditemukan!",
                "Print Gaji Staff",
                JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        String message = "";
        message += staff.getNik() + " - " + staff.getNama();
        message += "\r\nTipe: " + staff.getClass().getSimpleName();
        message += "\r\nGaji: " + controller.hitungGajiStaff(staff.getNik());

        JOptionPane.showMessageDialog(
            null,
            message,
            "Print Gaji Staff",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
}
