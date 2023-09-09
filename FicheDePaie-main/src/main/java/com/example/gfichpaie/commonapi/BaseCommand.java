package com.example.gfichpaie.commonapi;

import lombok.Getter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class BaseCommand<T> {
    @TargetAggregateIdentifier
    @Getter private final T id;
    public BaseCommand(T id) {
        this.id = id;
    }

}
