package com.example.Material.commanApi.event;

import com.example.Material.commanApi.enums.materialStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MaterialAssingedEvent {
    @Getter
    private String id ;
    @Getter
    private String collaborator;
    @Getter
    private String materialId;
    @Getter
    private String materialName;
    @Getter
    private int quantity;

 @Getter
 private materialStatus status;

    public MaterialAssingedEvent(String id, String materialId, String materialName, int quantity, String collaborator) {
        this.id = id;
        this.materialId = materialId;
        this.materialName = materialName;
        this.quantity = quantity;
        this.collaborator = collaborator;
    }




}
