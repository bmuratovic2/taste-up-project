package nrs.tim5.projekat;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import jdk.jshell.execution.Util;
import nrs.tim5.projekat.DAO.MenuDAO;
import nrs.tim5.projekat.childrenAdminController.*;
import nrs.tim5.projekat.childrenKonobarController.*;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class KonobarController {
    @FXML
    public BorderPane mainPane;
    @FXML
    public BorderPane pica;
    public Circle prviId;
    public Rectangle drugiId;
    public Circle treciId;
    public Circle cetvrtiId;
    public Circle petiId;
    public Circle sestiId;
    public Circle sedmiId;
    public Rectangle osmiId;
    public Circle devetiId;
    public ToggleButton tog1;
    public ToggleButton tog2;
    public Button btnSingOut;;
    public TabPane tabPane;
    public ListView lvNarudba;
    public Label chickenCijena;
    public Label doubleCijena;
    public Label regularCijena;
    public Label cheeseCijena;

    private Integer selektovan = 0;
    public MenuDAO menuDao;
    public ObservableList<Stavka> stavke = FXCollections.observableArrayList();

    private ResourceBundle bundle = ResourceBundle.getBundle("Prijevod");

    @FXML
    public void initialize() {
        if (stavke.size() == 0) {
            menuDao = new MenuDAO();
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            new Thread(() -> {
                Platform.runLater(() -> {
                    if (Locale.getDefault().getCountry().equals("BA") && Locale.getDefault().getLanguage().equals("bs")) {
                        alert1.setTitle("Informationi prozor");
                        alert1.setHeaderText("Trenutno je učitavanje podataka sa servera u toku.");
                        alert1.setContentText("Molim vas sačekajte.");
                    } else if (Locale.getDefault().getCountry().equals("US") && Locale.getDefault().getLanguage().equals("en")){
                        alert1.setTitle("Information Dialog");
                        alert1.setHeaderText("Getting data from server in process.");
                        alert1.setContentText("Please wait.");
                    }

                    alert1.initStyle(StageStyle.UNDECORATED);
                    alert1.getDialogPane().lookupButton(ButtonType.OK).setVisible(false);
                    alert1.show();
                });
                stavke = menuDao.sveStavke();
                for (int i=0; i<stavke.size(); i++) {
                    if (stavke.get(i).getNaziv().equals("Cheese Burger")) {
                        Double cijena = stavke.get(i).getCijena();
                        BurgerKonobarController.setCijenaCheeseBurger(cijena.toString());
                    }
                    else if (stavke.get(i).getNaziv().equals("Chicken Burger")) {
                        Double cijena = stavke.get(i).getCijena();
                        BurgerKonobarController.setCijenaChickenBurger(cijena.toString());
                    }
                    else if (stavke.get(i).getNaziv().equals("Double Burger")) {
                        Double cijena = stavke.get(i).getCijena();
                        BurgerKonobarController.setCijenaDoubleBurger(cijena.toString());
                    }
                    else if (stavke.get(i).getNaziv().equals("Regular Burger")) {
                        Double cijena = stavke.get(i).getCijena();
                        BurgerKonobarController.setCijenaRegularBurger(cijena.toString());
                    }
                    else if (stavke.get(i).getNaziv().equals("Coca Cola")) {
                        Double cijena = stavke.get(i).getCijena();
                        ColdDrinksKonobarController.setCijenaCocaCola(cijena.toString());
                    }
                    else if (stavke.get(i).getNaziv().equals("Sprite")) {
                        Double cijena = stavke.get(i).getCijena();
                        ColdDrinksKonobarController.setCijenaSprite(cijena.toString());
                    }
                    else if (stavke.get(i).getNaziv().equals("Apple Juice")) {
                        Double cijena = stavke.get(i).getCijena();
                        ColdDrinksKonobarController.setCijenaAppleJuice(cijena.toString());
                    }
                    else if (stavke.get(i).getNaziv().equals("Dvojni C")) {
                        Double cijena = stavke.get(i).getCijena();
                        ColdDrinksKonobarController.setCijenaDvojniC(cijena.toString());
                    }
                    else if (stavke.get(i).getNaziv().equals("Watter")) {
                        Double cijena = stavke.get(i).getCijena();
                        ColdDrinksKonobarController.setCijenaWatter(cijena.toString());
                    }
                    else if (stavke.get(i).getNaziv().equals("Espresso")) {
                        Double cijena = stavke.get(i).getCijena();
                        HotDrinksKonobarController.setCijenaEspresso(cijena.toString());
                    }
                    else if (stavke.get(i).getNaziv().equals("Late")) {
                        Double cijena = stavke.get(i).getCijena();
                        HotDrinksKonobarController.setCijenaLate(cijena.toString());
                    }
                    else if (stavke.get(i).getNaziv().equals("Macchiato")) {
                        Double cijena = stavke.get(i).getCijena();
                        HotDrinksKonobarController.setCijenaMacchiato(cijena.toString());
                    }
                    else if (stavke.get(i).getNaziv().equals("Hot Chocolate")) {
                        Double cijena = stavke.get(i).getCijena();
                        HotDrinksKonobarController.setCijenaHotCh(cijena.toString());
                    }
                    else if (stavke.get(i).getNaziv().equals("Tea")) {
                        Double cijena = stavke.get(i).getCijena();
                        HotDrinksKonobarController.setCijenaTea(cijena.toString());
                    }
                    else if (stavke.get(i).getNaziv().equals("Classic Margarita")) {
                        Double cijena = stavke.get(i).getCijena();
                        PizzaKonobarController.setCijenaMargarita(cijena.toString());
                    }
                    else if (stavke.get(i).getNaziv().equals("Pepperoni")) {
                        Double cijena = stavke.get(i).getCijena();
                        PizzaKonobarController.setCijenaPepperoni(cijena.toString());
                    }
                    else if (stavke.get(i).getNaziv().equals("The Veggie One")) {
                        Double cijena = stavke.get(i).getCijena();
                        PizzaKonobarController.setCijenaVeggie(cijena.toString());
                    }
                    else if (stavke.get(i).getNaziv().equals("Garlic Pizza Bread")) {
                        Double cijena = stavke.get(i).getCijena();
                        PizzaKonobarController.setCijenaGarlic(cijena.toString());
                    }
                    else if (stavke.get(i).getNaziv().equals("Chicken Pizza")) {
                        Double cijena = stavke.get(i).getCijena();
                        PizzaKonobarController.setCijenaChicken(cijena.toString());
                    }
                    else if (stavke.get(i).getNaziv().equals("Tuna & Salad")) {
                        Double cijena = stavke.get(i).getCijena();
                        SendwichKonobarController.setCijenaTuna(cijena.toString());
                    }
                    else if (stavke.get(i).getNaziv().equals("Chicken Sandwich")) {
                        Double cijena = stavke.get(i).getCijena();
                        SendwichKonobarController.setCijenaChickenSendw(cijena.toString());
                    }
                    else if (stavke.get(i).getNaziv().equals("Pepper & Eggs")) {
                        Double cijena = stavke.get(i).getCijena();
                        SendwichKonobarController.setCijenaPepperEgg(cijena.toString());
                    }
                    else if (stavke.get(i).getNaziv().equals("BBQ & Cheese")) {
                        Double cijena = stavke.get(i).getCijena();
                        SendwichKonobarController.setCijenaBBQ(cijena.toString());
                    }
                    else if (stavke.get(i).getNaziv().equals("Vegeterian")) {
                        Double cijena = stavke.get(i).getCijena();
                        SendwichKonobarController.setCijenaVegeterianSendw(cijena.toString());
                    }



                }
                Platform.runLater(() -> {
                    alert1.close();
                    Parent root2 = null;
                    try {
                        root2=FXMLLoader.load(getClass().getResource("/fxml/burgeri.fxml"), bundle);
                    } catch (Exception e) {
                    }
                    mainPane.setCenter(root2);
                });
            }).start();
        }
    }


    public void krajAction(ActionEvent actionEvent) throws IOException {
        Stage thisStage = (Stage) btnSingOut.getScene().getWindow();
        thisStage.close();

        ResourceBundle bundle = ResourceBundle.getBundle("Prijevod");
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"), bundle);
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Ugostiteljski objekat");
        primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public void vratiBoju(Integer s){
        if (s == 1){
            prviId.setFill(Color.valueOf("#cc6600"));
        } else if (s == 2){
            drugiId.setFill(Color.valueOf("cc6600"));
        } else if (s == 3){
            treciId.setFill(Color.valueOf("cc6600"));
        } else if (s == 4){
            cetvrtiId.setFill(Color.valueOf("cc6600"));
        } else if (s == 5){
            petiId.setFill(Color.valueOf("cc6600"));
        } else if (s == 6){
            sestiId.setFill(Color.valueOf("cc6600"));
        } else if (s == 7){
            sedmiId.setFill(Color.valueOf("cc6600"));
        } else if (s == 8){
            osmiId.setFill(Color.valueOf("cc6600"));
        } else if (s == 9){
            devetiId.setFill(Color.valueOf("cc6600"));
        }
    }

    public void prviAction(MouseEvent mouseEvent) {
        vratiBoju(selektovan);
        selektovan = 1;
        prviId.setFill(Color.valueOf("F93F25"));
    }

    public void petiAction(MouseEvent mouseEvent) {
        vratiBoju(selektovan);
        selektovan = 5;
        petiId.setFill(Color.valueOf("F93F25"));
    }

    public void cetvrtiAction(MouseEvent mouseEvent) {
        vratiBoju(selektovan);
        selektovan = 4;
        cetvrtiId.setFill(Color.valueOf("F93F25"));
    }

    public void devetiAction(MouseEvent mouseEvent) {
        vratiBoju(selektovan);
        selektovan = 9;
        devetiId.setFill(Color.valueOf("F93F25"));
    }

    public void sedmiAction(MouseEvent mouseEvent) {
        vratiBoju(selektovan);
        selektovan = 7;
        sedmiId.setFill(Color.valueOf("F93F25"));
    }

    public void sestiAction(MouseEvent mouseEvent) {
        vratiBoju(selektovan);
        selektovan = 6;
        sestiId.setFill(Color.valueOf("F93F25"));
    }

    public void treciAction(MouseEvent mouseEvent) {
        vratiBoju(selektovan);
        selektovan = 3;
        treciId.setFill(Color.valueOf("F93F25"));
    }

    public void drugiAction(MouseEvent mouseEvent) {
        vratiBoju(selektovan);
        selektovan = 2;
        drugiId.setFill(Color.valueOf("F93F25"));
    }

    public void osmiAction(MouseEvent mouseEvent) {
        vratiBoju(selektovan);
        selektovan = 8;
        osmiId.setFill(Color.valueOf("F93F25"));
    }


    public void tab2(Event event) {
        Parent root = null;
        try {
            root=FXMLLoader.load(getClass().getResource("/fxml/burgeri.fxml"), bundle);
        } catch (Exception e) {
        }
        mainPane.setCenter(root);
    }

    public void burgeriAction(ActionEvent actionEvent) throws IOException {
        Parent root = null;
        try {
            root=FXMLLoader.load(getClass().getResource("/fxml/burgeri.fxml"), bundle);
        } catch (Exception e) {
        }
        mainPane.setCenter(root);

           /* mainPane.getChildren().clear();
            root = FXMLLoader.load(getClass().getResource("/fxml/burgeri.fxml"));
            mainPane.getChildren().setAll(root.getChildren());*/

    }

    public void sendwichAction(ActionEvent actionEvent) {
        Parent root = null;
        try {
            root=FXMLLoader.load(getClass().getResource("/fxml/sendwich.fxml"), bundle);
        } catch (Exception e) {
        }
        mainPane.setCenter(root);
    }

    public void pizzaAction(ActionEvent actionEvent) {
        Parent root = null;
        try {
            root=FXMLLoader.load(getClass().getResource("/fxml/pizza.fxml"), bundle);
        } catch (Exception e) {
        }
        mainPane.setCenter(root);
    }

    public void coldAction(ActionEvent actionEvent) {
        Parent root = null;
        try {
            root=FXMLLoader.load(getClass().getResource("/fxml/coldDrinks.fxml"), bundle);
        } catch (Exception e) {
        }
        tog1.setSelected(true);
        tog2.setSelected(false);
        pica.setCenter(root);
    }

    public void drinksAction(ActionEvent actionEvent) {
        Parent root = null;
        try {
            root=FXMLLoader.load(getClass().getResource("/fxml/drinks.fxml"), bundle);
        } catch (Exception e) {
        }
        mainPane.setCenter(root);
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


    public void saveAction(ActionEvent actionEvent) {

    }
}
