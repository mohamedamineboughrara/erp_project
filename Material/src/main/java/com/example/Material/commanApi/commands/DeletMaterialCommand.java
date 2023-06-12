package com.example.Material.commanApi.commands;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@NoArgsConstructor
@AllArgsConstructor

public class DeletMaterialCommand {
    @TargetAggregateIdentifier
    @Getter
    private String id;
    public void setId(String id) {
        this.id = id;
    }
}
