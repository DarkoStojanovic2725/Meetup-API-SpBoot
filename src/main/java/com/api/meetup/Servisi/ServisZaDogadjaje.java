package com.api.meetup.Servisi;

import com.api.meetup.Model.Dogadjaj;
import com.api.meetup.Model.Grad;

import java.io.IOException;
import java.util.List;

public interface ServisZaDogadjaje {

    public List<Dogadjaj> getSveDogadjajeUGradu(Grad grad) throws IOException;
}
