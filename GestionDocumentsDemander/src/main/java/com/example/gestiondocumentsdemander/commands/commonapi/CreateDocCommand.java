package com.example.gestiondocumentsdemander.commands.commonapi;

import lombok.Getter;

import java.io.File;
import java.time.LocalDate;

public class CreateDocCommand extends BaseCommand<String> {

    @Getter private String firstName;
    @Getter private String lastName;
    @Getter private String instituteName;
    @Getter private String post;
    @Getter private LocalDate startDate;
    @Getter private LocalDate endDate;
    @Getter private String typeDoc;
    @Getter private String filePath;
    @Getter   private String adress;
    @Getter   private String contractType;
    @Getter   private String salary;
    @Getter   private String supervisorName;
    @Getter   private String workingHours;
    @Getter   private String month;
    @Getter   private String year;
    @Getter   private String details;

    public CreateDocCommand(String id, String firstName, String lastName, String instituteName, String post, LocalDate startDate, LocalDate endDate, String typeDoc, String filePath, String adress, String contractType, String salary, String supervisorName, String workingHours, String month, String year, String details) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.instituteName = instituteName;
        this.post = post;
        this.startDate = startDate;
        this.endDate = endDate;
        this.typeDoc = typeDoc;
        this.filePath = filePath;
        this.adress = adress;
        this.contractType = contractType;
        this.salary = salary;
        this.supervisorName = supervisorName;
        this.workingHours = workingHours;
        this.month = month;
        this.year = year;
        this.details = details;
    }
}
