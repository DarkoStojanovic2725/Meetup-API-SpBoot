package com.api.meetup.ServisiImpl;

import com.api.meetup.DAO.DaoGradovi;
import com.api.meetup.Model.Grad;
import com.api.meetup.Servisi.ServisZaGradove;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServisZaGradoveImpl implements ServisZaGradove {

    @Autowired
    DaoGradovi repoGradova;


    @Override
    public List<Grad> getSveGradove() throws Exception {
        return repoGradova.getSveGradove();
    }

    @Override
    public Grad nadjiPoId(int id) {
        return repoGradova.nadjiPoId(id);
    }
}
