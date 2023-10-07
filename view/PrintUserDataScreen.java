package view;

import javax.swing.JOptionPane;
import java.util.ArrayList;

import controller.Controller;
import model.User;

public class PrintUserDataScreen {
    public PrintUserDataScreen() {
        Controller controller = new Controller();
        // Show name input screen
        String inputNama = JOptionPane.showInputDialog(null, "Masukkan nama");
        if (inputNama == null) { return; } 

        ArrayList<User> listUser = controller.getUserByName(inputNama);
        if (listUser.size() == 0) {
            JOptionPane.showMessageDialog(
                null,
                "Nama " + inputNama + " tidak ditemukan!",
                "Print User Data",
                JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        JOptionPane.showMessageDialog(
            null, 
            controller.printUserData(listUser),
            "Print User Data",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
}
