package org.app.mongodb.controller;

import org.app.mongodb.models.Impiegato;
import org.app.mongodb.services.ImpiegatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class ImpiegatoController {

    @Autowired
    private ImpiegatoRepository impiegatoRepository;

    @ResponseBody
    @RequestMapping("/")
    public String home() {
        String html = "";
        html += "<ul>";
        html += " <li><a href='/testInsert'>Test Insert</a></li>";
        html += " <li><a href='/showAllEmployee'>Show All Employee</a></li>";
        html += " <li><a href='/showFullNameLikeTom'>Show All 'Tom'</a></li>";
        html += " <li><a href='/deleteAllEmployee'>Delete All Employee</a></li>";
        html += "</ul>";
        return html;
    }

    public String aggiungiImpiegato() {
        String html = "";
        html = "<form method=POST action='/insert'>" +
                "<input type='text' name='codice'/>" +
                "<input type='text' name='nome'/>" +
                "<input type='text' name='cognome'/>" +
                "<input type='submit'/>" +
                "</form>";
        return html;
    }

    @ResponseBody
    @GetMapping("/textInsert")
    public String textInsert() {
        Impiegato impiegato = new Impiegato();
        impiegato.setCodice("ABC");
        impiegato.setNome("Pippo");
        impiegato.setCognome("Walt Disney");
        impiegato.setDataDiNascita(new Date());
        this.impiegatoRepository.insert(impiegato);
        return "Inserito: "+impiegato.getCognome();
    }


}
