package com.desafio.primeiro.service;

import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.client.RestTemplate;

/**
 * Validar se a Transferência é Segura.
 * */
public class TransferenciaSeguraService {

    private static String url = "https://run.mocky.io/v3/5794d450-d2e2-4412-8131-73d0293ac1cc";




    public boolean validarTransferencia(){
        RestTemplate restTemplate = new RestTemplate();
        TransferenciaSeguraLayoutAPI api  = restTemplate.getForObject(url, TransferenciaSeguraLayoutAPI.class);
        String status= api != null ? api.getMessage() : "Recusado";
        if(status.equals("Autorizado")){
            return true;
        }
        return false;
    }

    @Getter
    @Setter
    class TransferenciaSeguraLayoutAPI{
        String message;
    }




}
