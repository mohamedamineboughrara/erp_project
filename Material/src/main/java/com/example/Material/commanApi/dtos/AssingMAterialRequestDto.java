package com.example.Material.commanApi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssingMAterialRequestDto {
    private String id;
    private String materialId;
    private String collaborator;
    private String materialName;
    private int quantity;
}
