package com.example.gestionbdg.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseEvent <T> {
@Getter private T id;

}
