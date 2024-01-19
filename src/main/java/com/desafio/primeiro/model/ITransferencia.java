package com.desafio.primeiro.model;

import com.desafio.primeiro.enums.ETransferenciaStatus;
import com.desafio.primeiro.enums.ETransferenciaTipo;
import com.desafio.primeiro.model.Usuario;

public interface ITransferencia {
    public ETransferenciaStatus transferir(ETransferenciaTipo tipo, Usuario origem, Usuario destino);
 }
