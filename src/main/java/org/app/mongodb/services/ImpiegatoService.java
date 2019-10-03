package org.app.mongodb.services;

import org.app.mongodb.dtos.ImpiegatoDTO;
import org.app.mongodb.models.Impiegato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.sql.Date;
import java.time.ZoneId;

@Service
public class ImpiegatoService {

    @Autowired
    private ImpiegatoRepository impiegatoRepository;

    public Impiegato save(@ModelAttribute ImpiegatoDTO impiegatoDTO) {
        Impiegato impiegato = new Impiegato();
        impiegato.setNome(impiegatoDTO.getNome());
        impiegato.setCognome(impiegatoDTO.getCognome());
        impiegato.setDataDiNascita(Date.from(impiegatoDTO.getDataDiNascita().atStartOfDay(ZoneId.of("Europe/Rome")).toInstant()));
        impiegato.setCodice(impiegatoDTO.getCodice());
        impiegatoRepository.insert(impiegato);
        return impiegato;
    }

}
