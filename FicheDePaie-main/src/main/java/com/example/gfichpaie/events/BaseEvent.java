package com.example.gfichpaie.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseEvent <T> {
@Getter private T id;


}
