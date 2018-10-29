package com.api.meetup.DAO;

import com.api.meetup.Model.Dogadjaj;
import com.api.meetup.Model.Grad;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class DaoDogadjaji {


    ArrayList<Dogadjaj> listaDogadjaja = new ArrayList<>();
    HttpURLConnection con;
    URL urlZaApi;
    int responseCode;
    StringBuffer stringVrednost;
    JSONObject jsonObject;
    String input;


    final String kljuc = "a3d7655d75775d2058323e7c7e321c";
    final String url = "https://api.meetup.com";
    final String metod = "/find/upcoming_events";

    String link = url + metod + "?";



    public List<Dogadjaj> getSveDogadjajeUGradu(Grad grad) throws IOException {

        if(!listaDogadjaja.isEmpty()){
            listaDogadjaja.clear();
        }
        final String urlKompletan = link + "key=" + kljuc + "&lon=" + grad.getLon() + "&lat=" + grad.getLat();
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

        JSONArray dogadjaji = jsonObject.getJSONArray("events");
        Iterator<Object> iterator = dogadjaji.iterator();
        while(iterator.hasNext()){
            Dogadjaj dogadjajZaListu = new Dogadjaj();
            JSONObject dogadjaj = (JSONObject) iterator.next();

            dogadjajZaListu.setId(dogadjaj.getString("id"));
            dogadjajZaListu.setNaziv(dogadjaj.getString("name"));
            try {
                String opis = dogadjaj.getString("description");
                opis = opis.replaceAll("\\<.*?\\>", "");
                dogadjajZaListu.setOpis(opis);
            } catch (JSONException e){
                dogadjajZaListu.setOpis("Nema");
            }
            dogadjajZaListu.setGrad(grad);
            listaDogadjaja.add(dogadjajZaListu);
        }

        return listaDogadjaja;
    }
}
