package nrs.tim5.projekat.childrenAdminController;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class PizzaAdminController {
    public TextField tfMargarita;
    public TextField tfPepperoni;
    public TextField tfVeggie;
    public TextField tfChicken;
    public TextField tfGarlic;

    public static String cijenaMargarita;
    public static String cijenaPepperoni;
    public static String cijenaVeggie;
    public static String cijenaChicken;
    public static String cijenaGarlic;

    @FXML
    public void initialize() {
        tfMargarita.setText(cijenaMargarita);
        tfPepperoni.setText(cijenaPepperoni);
        tfVeggie.setText(cijenaVeggie);
        tfChicken.setText(cijenaChicken);
        tfGarlic.setText(cijenaGarlic);

        tfMargarita.textProperty().addListener((obs, oldIme, newIme) -> {
            cijenaMargarita = tfMargarita.getText();
        });

        tfPepperoni.textProperty().addListener((obs, oldIme, newIme) -> {
            cijenaPepperoni = tfPepperoni.getText();
        });

        tfVeggie.textProperty().addListener((obs, oldIme, newIme) -> {
            cijenaVeggie = tfVeggie.getText();
        });

        tfChicken.textProperty().addListener((obs, oldIme, newIme) -> {
            cijenaChicken = tfChicken.getText();
        });

        tfGarlic.textProperty().addListener((obs, oldIme, newIme) -> {
            cijenaGarlic = tfGarlic.getText();
        });
    }

    public static String getCijenaMargarita() {
        return cijenaMargarita;
    }

    public static void setCijenaMargarita(String cijenaMargarita) {
        PizzaAdminController.cijenaMargarita = cijenaMargarita;
    }

    public static String getCijenaPepperoni() {
        return cijenaPepperoni;
    }

    public static void setCijenaPepperoni(String cijenaPepperoni) {
        PizzaAdminController.cijenaPepperoni = cijenaPepperoni;
    }

    public static String getCijenaVeggie() {
        return cijenaVeggie;
    }

    public static void setCijenaVeggie(String cijenaVeggie) {
        PizzaAdminController.cijenaVeggie = cijenaVeggie;
    }

    public static String getCijenaChicken() {
        return cijenaChicken;
    }

    public static void setCijenaChicken(String cijenaChicken) {
        PizzaAdminController.cijenaChicken = cijenaChicken;
    }

    public static String getCijenaGarlic() {
        return cijenaGarlic;
    }

    public static void setCijenaGarlic(String cijenaGarlic) {
        PizzaAdminController.cijenaGarlic = cijenaGarlic;
    }
}
