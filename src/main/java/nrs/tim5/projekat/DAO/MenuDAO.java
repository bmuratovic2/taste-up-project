package nrs.tim5.projekat.DAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import nrs.tim5.projekat.Stavka;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class MenuDAO {
    private static LoginDAO instance;

    public static LoginDAO getInstance(){
        if (instance==null) instance = new LoginDAO();
        return instance;
    }

    public ObservableList<Stavka> sveStavke(){
        //ako je potreban sleep za prezentacije
        /*try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        ObservableList<Stavka> stavke = FXCollections.observableArrayList();

        try {
            URL url = new URL("http://64.227.119.56:7000/products");
            URLConnection conn = url.openConnection();
            conn.setDoInput(true);
            conn.setDoOutput(true);

            InputStream inputStream = conn.getInputStream();
            String rezultat = "";
            Scanner scanner = new Scanner(inputStream);
            while (scanner.hasNextLine()){
                rezultat += scanner.nextLine() + "\n";
            }
            scanner.close();
            inputStream.close();
            String finalRezultat = rezultat.trim();
            JSONArray jsonArray = new JSONArray(finalRezultat);

            for (Integer i=0; i<jsonArray.length(); i++){
                String ime = jsonArray.getJSONObject(i).getString("name");
                Double cijena = jsonArray.getJSONObject(i).getDouble("price");
                Stavka stavka = new Stavka(i, ime, cijena);
                stavke.add(stavka);
            }
            return stavke;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return stavke;
    }

    public Boolean postaviCijenu(String naziv, String cijena){
        //ako je potreban sleep za prezentacije
        /*try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        if (!daLiJeDouble(cijena)) return false;

        String nazivJela = naziv.toLowerCase(Locale.ROOT);
        String[] splitan = nazivJela.split(" ");
        nazivJela = "";

        for (int i=0; i<splitan.length; i++){
            nazivJela += splitan[i];
            if (i+1<splitan.length) nazivJela += "-";
        }

        try {
            URL url = new URL("http://64.227.119.56:7000/products/" + nazivJela + "/" + cijena);
            HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
            httpCon.setDoOutput(true);
            httpCon.setRequestMethod("PUT");

            InputStream inputStream = httpCon.getInputStream();
            String rezultat = "";
            Scanner scanner = new Scanner(inputStream);
            while (scanner.hasNextLine()){
                rezultat += scanner.nextLine() + "\n";
            }
            scanner.close();
            inputStream.close();
            String finalRezultat = rezultat.trim();

            if (finalRezultat.equals(naziv)) return true;
            else return false;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }

    private boolean daLiJeDouble(String string) {
        try {
            Double.parseDouble(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
