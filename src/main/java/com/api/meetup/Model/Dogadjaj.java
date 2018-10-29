package com.api.meetup.Model;

import org.springframework.stereotype.Component;

@Component
public class Dogadjaj {

    private String id;
    private String naziv;
    private String opis;
    private Grad grad;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }


    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Grad getGrad() {
        return grad;
    }

    public void setGrad(Grad grad) {
        this.grad = grad;
    }

    @Override
    public String toString() {
        return "Dogadjaj{" +
                "Id dogadjaja=" + id +
                ", Naziv='" + naziv + '\'' +
                ", Opis='" + opis + '\'' +
                ", Grad=" + grad +
                '}';
    }
}
