package nrs.tim5.projekat.childrenKonobarController;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PizzaKonobarController {
    public Label lbMargarita;
    public Label lbPepperoni;
    public Label lbVeggie;
    public Label lbChicken;
    public Label lbGarlic;

    public static String cijenaMargarita;
    public static String cijenaPepperoni;
    public static String cijenaVeggie;
    public static String cijenaChicken;
    public static String cijenaGarlic;

    @FXML
    public void initialize() {
        lbMargarita.setText(cijenaMargarita);
        lbPepperoni.setText(cijenaPepperoni);
        lbVeggie.setText(cijenaVeggie);
        lbChicken.setText(cijenaChicken);
        lbGarlic.setText(cijenaGarlic);
    }

    public static String getCijenaMargarita() {
        return cijenaMargarita;
    }

    public static void setCijenaMargarita(String cijenaMargarita) {
        PizzaKonobarController.cijenaMargarita = cijenaMargarita;
    }

    public static String getCijenaPepperoni() {
        return cijenaPepperoni;
    }

    public static void setCijenaPepperoni(String cijenaPepperoni) {
        PizzaKonobarController.cijenaPepperoni = cijenaPepperoni;
    }

    public static String getCijenaVeggie() {
        return cijenaVeggie;
    }

    public static void setCijenaVeggie(String cijenaVeggie) {
        PizzaKonobarController.cijenaVeggie = cijenaVeggie;
    }

    public static String getCijenaChicken() {
        return cijenaChicken;
    }

    public static void setCijenaChicken(String cijenaChicken) {
        PizzaKonobarController.cijenaChicken = cijenaChicken;
    }

    public static String getCijenaGarlic() {
        return cijenaGarlic;
    }

    public static void setCijenaGarlic(String cijenaGarlic) {
        PizzaKonobarController.cijenaGarlic = cijenaGarlic;
    }
}
