package nrs.tim5.projekat.childrenKonobarController;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SendwichKonobarController {
    public Label lbTuna;
    public Label lbChickenSendw;
    public Label lbPepperEgg;
    public Label lbBBQ;
    public Label lbVegeterianSendw;

    public static String cijenaTuna;
    public static String cijenaChickenSendw;
    public static String cijenaPepperEgg;
    public static String cijenaBBQ;
    public static String cijenaVegeterianSendw;

    @FXML
    public void initialize() {
        /*tfTuna.setText(cijenaTuna);
        tfChickenSendw.setText(cijenaChickenSendw);
        tfPepperEgg.setText(cijenaPepperEgg);
        tfBBQ.setText(cijenaBBQ);
        tfVegeterianSendw.setText(cijenaVegeterianSendw);*/
    }

    public static String getCijenaTuna() {
        return cijenaTuna;
    }

    public static void setCijenaTuna(String cijenaTuna) {
        SendwichKonobarController.cijenaTuna = cijenaTuna;
    }

    public static String getCijenaChickenSendw() {
        return cijenaChickenSendw;
    }

    public static void setCijenaChickenSendw(String cijenaChickenSendw) {
        SendwichKonobarController.cijenaChickenSendw = cijenaChickenSendw;
    }

    public static String getCijenaPepperEgg() {
        return cijenaPepperEgg;
    }

    public static void setCijenaPepperEgg(String cijenaPepperEgg) {
        SendwichKonobarController.cijenaPepperEgg = cijenaPepperEgg;
    }

    public static String getCijenaBBQ() {
        return cijenaBBQ;
    }

    public static void setCijenaBBQ(String cijenaBBQ) {
        SendwichKonobarController.cijenaBBQ = cijenaBBQ;
    }

    public static String getCijenaVegeterianSendw() {
        return cijenaVegeterianSendw;
    }

    public static void setCijenaVegeterianSendw(String cijenaVegeterianSendw) {
        SendwichKonobarController.cijenaVegeterianSendw = cijenaVegeterianSendw;
    }
}
