package com.example.Material.commanApi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class MaterialRequsetDTO {

    private String id;
    private String materialName;
    private int quantity;
    private  String photo;
}
