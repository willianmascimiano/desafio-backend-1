package com.desafio.primeiro.service;

import com.desafio.primeiro.enums.EUsuarioTipo;
import com.desafio.primeiro.model.Transferencia;
import com.desafio.primeiro.model.Usuario;
import com.desafio.primeiro.enums.ETransferenciaStatus;
import com.desafio.primeiro.enums.ETransferenciaTipo;
import org.springframework.stereotype.Service;

@Service
public class TransferenciaService  {



    public ETransferenciaStatus transferir(ETransferenciaTipo eTransferenciaTipo,
                                            Usuario origem,
                                           Usuario destino,
                                           Float montante) throws Exception {

        // Logista não transfere dinheiro.
        if (eTransferenciaTipo.equals(ETransferenciaTipo.ENVIO) && origem.getTipo_usuario().equals(EUsuarioTipo.LOGISTA)) {
            throw new Exception("Um logista não pode realizar transferência. ");
        }

    if(!new TransferenciaSeguraService().validarTransferencia()){
        throw new Exception("Erro ao validar transferencia.");
    }else if(origem.getSaldo()-montante>=0){

            //Validar se a transação é segura.

            origem.setSaldo(origem.getSaldo()-montante);
            destino.setSaldo(destino.getSaldo()+montante);
            return ETransferenciaStatus.SUCCESS;

        }else{
            throw new Exception("O saldo atual não permite transferência.");
        }

    }

    public ETransferenciaStatus reverterTransacao(Transferencia transferencia) throws Exception{
        return transferir(ETransferenciaTipo.DEVOLUCAO, transferencia.getDestino(), transferencia.getOrigem(), transferencia.getMontante());
    }



}
