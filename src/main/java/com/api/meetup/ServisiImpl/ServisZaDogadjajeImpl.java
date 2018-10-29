package com.api.meetup.ServisiImpl;

import com.api.meetup.DAO.DaoDogadjaji;
import com.api.meetup.Model.Dogadjaj;
import com.api.meetup.Model.Grad;
import com.api.meetup.Servisi.ServisZaDogadjaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ServisZaDogadjajeImpl implements ServisZaDogadjaje {

    @Autowired
    DaoDogadjaji daoDogadjaji;

    @Override
    public List<Dogadjaj> getSveDogadjajeUGradu(Grad grad) throws IOException {
        return daoDogadjaji.getSveDogadjajeUGradu(grad);
    }
}
