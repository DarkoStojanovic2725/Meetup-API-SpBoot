package com.api.meetup.Kontroleri;


import com.api.meetup.Model.Grad;
import com.api.meetup.Servisi.ServisZaGradove;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KontrolerGradovi {


    @Autowired
    ServisZaGradove servisZaGradove;

    @GetMapping(value = "meetup/gradovi")
    public ResponseEntity<List<Grad>> get() throws Exception {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "application/json; charset=UTF-8");
        httpHeaders.add("user-agent","Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.106 Safari/537.36 OPR/38.0.2220.41");
        return new ResponseEntity<>(getGradovi(), httpHeaders, HttpStatus.OK);
    }

    public List<Grad> getGradovi() throws Exception {
        return servisZaGradove.getSveGradove();
    }
}
