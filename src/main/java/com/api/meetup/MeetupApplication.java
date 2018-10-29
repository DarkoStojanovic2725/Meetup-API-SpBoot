package com.api.meetup;

import com.api.meetup.Model.Dogadjaj;
import com.api.meetup.Model.Grad;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@SpringBootApplication
public class MeetupApplication {


    public static void main(String[] args) {
        SpringApplication.run(MeetupApplication.class, args);

        getGradovi();

        while (true){
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String nastaviti = "Nope";
            try {
                getDogadjaji();
            } catch(IOException e) {
                e.printStackTrace();
            }
            System.out.println("Ponovo pretrazi dogadjaje? Y/N");
            try {
                nastaviti = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (nastaviti.equalsIgnoreCase("N")){
                System.exit(0);
                break;
            }

        }

    }

    public static void getGradovi(){
        final String url = "http://localhost:8080/meetup/gradovi";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Grad[]> responseEntity = restTemplate.getForEntity(url, Grad[].class);
        Grad[] gradoviZaStampanje = responseEntity.getBody();

        for (Grad grad: gradoviZaStampanje){
            System.out.println(grad.toString());
        }
    }


    public static void getDogadjaji() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Unesi redni broj grada za koji zelis da vidis dogadjaje");
        String brGrada = bufferedReader.readLine();

        final String url = "http://localhost:8080/meetup/dogadjaji/" + brGrada;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Dogadjaj[]> responseEntity = restTemplate.getForEntity(url, Dogadjaj[].class);
        Dogadjaj dogadjaji[] = responseEntity.getBody();

        for (Dogadjaj dogadjaj: dogadjaji){
            System.out.println(dogadjaj.toString());
        }
    }

}
