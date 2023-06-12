package com.example.Material.commanApi.event;

import com.example.Material.commanApi.enums.materialStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MaterialCreatedEvent {
    @Getter
    private String materialId;
    @Getter
    private String materialName;
    @Getter
    private int quantity;
    @Getter
    private String photo;

 @Getter
 private materialStatus status;

    public MaterialCreatedEvent(String materialId, String materialName, int quantity,String photo, materialStatus status) {
        this.materialId = materialId;
        this.materialName = materialName;
        this.quantity = quantity;
        this.photo = photo;
        this.status = status;

    }




}
