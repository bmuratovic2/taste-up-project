package nrs.tim5.projekat;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableArray;

public class Stavka {
    private SimpleIntegerProperty id, kolicina;
    private SimpleStringProperty naziv;
    private SimpleDoubleProperty cijena;

    public Stavka(){

    }

    public Stavka(SimpleIntegerProperty id, SimpleStringProperty naziv, SimpleDoubleProperty cijena){
        this.id = id;
        this.naziv = naziv;
        this.cijena = cijena;
        kolicina = new SimpleIntegerProperty(0);
    }

    public Stavka(Integer id, String naziv, Double cijena){
        this.id = new SimpleIntegerProperty(id);
        this.naziv = new SimpleStringProperty(naziv);
        this.cijena = new SimpleDoubleProperty(cijena);
        kolicina = new SimpleIntegerProperty(0);
    }

    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public int getKolicina() {
        return kolicina.get();
    }

    public SimpleIntegerProperty kolicinaProperty() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina.set(kolicina);
    }

    public String getNaziv() {
        return naziv.get();
    }

    public SimpleStringProperty nazivProperty() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv.set(naziv);
    }

    public double getCijena() {
        return cijena.get();
    }

    public SimpleDoubleProperty cijenaProperty() {
        return cijena;
    }

    public void setCijena(double cijena) {
        this.cijena.set(cijena);
    }
}
