package com.api.meetup.Servisi;

import com.api.meetup.Model.Grad;

import java.util.List;

public interface ServisZaGradove {


    public List<Grad> getSveGradove() throws Exception;
    public Grad nadjiPoId(int id);

}
