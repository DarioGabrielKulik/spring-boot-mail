package com.correo.api.controllers;

import com.correo.api.models.Mail;
import com.correo.api.services.MailServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class MailControllers {

    @Autowired
    private MailServices mailServices;

    @PostMapping("/envio")
    public ResponseEntity<?> envio(@RequestBody Mail mail){

        mailServices.sendEmail(mail.getTo(),mail.getSubject(),mail.getText());

        Map<String, String> body = new HashMap<>();
        body.put("Envio", "Confirmado");
        body.put("Espero", "No esperes nada");
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }

}
