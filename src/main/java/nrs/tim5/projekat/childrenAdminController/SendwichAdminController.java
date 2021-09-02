package nrs.tim5.projekat.childrenAdminController;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class SendwichAdminController {
    public TextField tfTuna;
    public TextField tfChickenSendw;
    public TextField tfPepperEgg;
    public TextField tfBBQ;
    public TextField tfVegeterianSendw;

    public static String cijenaTuna;
    public static String cijenaChickenSendw;
    public static String cijenaPepperEgg;
    public static String cijenaBBQ;
    public static String cijenaVegeterianSendw;

    @FXML
    public void initialize() {
        tfTuna.setText(cijenaTuna);
        tfChickenSendw.setText(cijenaChickenSendw);
        tfPepperEgg.setText(cijenaPepperEgg);
        tfBBQ.setText(cijenaBBQ);
        tfVegeterianSendw.setText(cijenaVegeterianSendw);

        tfTuna.textProperty().addListener((obs, oldIme, newIme) -> {
            cijenaTuna = tfTuna.getText();
        });

        tfChickenSendw.textProperty().addListener((obs, oldIme, newIme) -> {
            cijenaChickenSendw = tfChickenSendw.getText();
        });

        tfPepperEgg.textProperty().addListener((obs, oldIme, newIme) -> {
            cijenaPepperEgg = tfPepperEgg.getText();
        });

        tfBBQ.textProperty().addListener((obs, oldIme, newIme) -> {
            cijenaBBQ = tfBBQ.getText();
        });

        tfVegeterianSendw.textProperty().addListener((obs, oldIme, newIme) -> {
            cijenaVegeterianSendw = tfVegeterianSendw.getText();
        });
    }

    public static String getCijenaTuna() {
        return cijenaTuna;
    }

    public static void setCijenaTuna(String cijenaTuna) {
        SendwichAdminController.cijenaTuna = cijenaTuna;
    }

    public static String getCijenaChickenSendw() {
        return cijenaChickenSendw;
    }

    public static void setCijenaChickenSendw(String cijenaChickenSendw) {
        SendwichAdminController.cijenaChickenSendw = cijenaChickenSendw;
    }

    public static String getCijenaPepperEgg() {
        return cijenaPepperEgg;
    }

    public static void setCijenaPepperEgg(String cijenaPepperEgg) {
        SendwichAdminController.cijenaPepperEgg = cijenaPepperEgg;
    }

    public static String getCijenaBBQ() {
        return cijenaBBQ;
    }

    public static void setCijenaBBQ(String cijenaBBQ) {
        SendwichAdminController.cijenaBBQ = cijenaBBQ;
    }

    public static String getCijenaVegeterianSendw() {
        return cijenaVegeterianSendw;
    }

    public static void setCijenaVegeterianSendw(String cijenaVegeterianSendw) {
        SendwichAdminController.cijenaVegeterianSendw = cijenaVegeterianSendw;
    }
}
