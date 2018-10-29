package com.api.meetup.Model;

public class Grad {

    private String ime;
    private int id;
    private double lon;
    private double lat;



    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    @Override
    public String toString() {
        return "Grad{" +
                "Redni broj(id)=" + id +
                ", Ime='" + ime + '\'' +
                ", longitude=" + lon +
                ", latitude=" + lat +
                '}';
    }
}
