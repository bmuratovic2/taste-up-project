package nrs.tim5.projekat.childrenKonobarController;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.BorderPane;

import java.util.ResourceBundle;

public class DrinkKonobarController {
    public ToggleButton tog1;
    public ToggleButton tog2;
    public BorderPane pica;

    private ResourceBundle bundle = ResourceBundle.getBundle("Prijevod");

    public void coldAction(ActionEvent actionEvent) {
        Parent root = null;
        try {
            root= FXMLLoader.load(getClass().getResource("/fxml/coldDrinks.fxml"), bundle);
        } catch (Exception e) {
        }
        tog1.setSelected(true);
        tog2.setSelected(false);
        pica.setCenter(root);
    }

    public void hotAction(ActionEvent actionEvent) {
        Parent root = null;
        try {
            root=FXMLLoader.load(getClass().getResource("/fxml/hotDrinks.fxml"), bundle);
        } catch (Exception e) {
        }
        tog2.setSelected(true);
        tog1.setSelected(false);
        pica.setCenter(root);
    }
}
