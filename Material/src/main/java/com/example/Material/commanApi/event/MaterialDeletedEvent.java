package com.example.Material.commanApi.event;

import com.example.Material.commanApi.enums.materialStatus;
import lombok.Getter;

public class MaterialDeletedEvent {
    @Getter
    private materialStatus status;
    @Getter
    private String id;

    public MaterialDeletedEvent(String id) {
      this.id = id;
        this.status= materialStatus.DELETED; }
}
