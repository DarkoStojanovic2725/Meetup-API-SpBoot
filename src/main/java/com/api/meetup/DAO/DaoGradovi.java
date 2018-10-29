package com.api.meetup.DAO;

import com.api.meetup.Model.Grad;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Component
public class DaoGradovi {

    ArrayList<Grad> listaGradova = new ArrayList<>();
    HttpURLConnection con;
    URL urlZaApi;
    int responseCode;
    StringBuffer stringVrednost;
    JSONObject jsonObject;
    String input;


    final String kljuc = "a3d7655d75775d2058323e7c7e321c";
    final String url = "https://api.meetup.com";
    final String metod = "/2/cities";
    final String drzava = "country=rs";

    String link = url + metod + "?" + drzava;
    final String urlKompletan = link + "&" + kljuc;

    public List<Grad> getSveGradove() throws Exception {

        if(!listaGradova.isEmpty()){
            listaGradova.clear();
        }
        urlZaApi = new URL(urlKompletan);
        con = (HttpURLConnection) urlZaApi.openConnection();

        con.setRequestMethod("GET");

        responseCode = con.getResponseCode();

        try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            stringVrednost = new StringBuffer();
            while ((input = in.readLine()) != null) {
                stringVrednost.append(input);
            }
        }

        jsonObject = new JSONObject(stringVrednost.toString());

        JSONArray gradovi = jsonObject.getJSONArray("results");
        Iterator<Object> iterator = gradovi.iterator();

        while (iterator.hasNext()) {

            JSONObject grad = (JSONObject) iterator.next();

            Grad cityForList = new Grad();
            cityForList.setId(grad.getInt("ranking"));
            cityForList.setIme(grad.getString("city"));
            cityForList.setLat(grad.getDouble("lat"));
            cityForList.setLon(grad.getDouble("lon"));

            listaGradova.add(cityForList);
        }
        return listaGradova;

    }

    public Grad nadjiPoId(int id) {
        for (Grad grad : listaGradova) {
            if (grad.getId() == id) {
                return grad;
            }
        }
        return null;
    }
}
