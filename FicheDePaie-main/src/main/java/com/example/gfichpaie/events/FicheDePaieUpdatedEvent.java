package com.example.gfichpaie.events;

import com.example.gfichpaie.enums.FicheDePaieStatus;
import lombok.Getter;

import java.util.Date;


public class FicheDePaieUpdatedEvent extends BaseEvent<String>{


    @Getter private final String userName;
    @Getter private final Date date;
    @Getter private final Double salaireBrut;
    @Getter  private final Double impots;
    @Getter  private final String idCollaborator;
    @Getter  private final Double salaireNet;
    @Getter  private final Double chargeSociale;
    @Getter  private final Double prime;
    @Getter  private final Double tjm;
    @Getter  private final FicheDePaieStatus status;

    public FicheDePaieUpdatedEvent(String id, String userName, Date date, Double salaireBrut, Double impots, String idCollaborator, Double salaireNet, Double chargeSociale, Double prime, Double tjm, FicheDePaieStatus status) {
        super(id);
        this.userName = userName;
        this.date = date;
        this.salaireBrut = salaireBrut;
        this.impots = impots;
        this.idCollaborator = idCollaborator;
        this.salaireNet = salaireNet;
        this.chargeSociale = chargeSociale;
        this.prime = prime;
        this.tjm = tjm;
        this.status = status;
    }

}
