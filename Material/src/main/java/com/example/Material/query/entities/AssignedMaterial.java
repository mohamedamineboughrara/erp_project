package com.example.Material.query.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssignedMaterial {
    @Id
    private String id;

    private String materialName;
    private int quantity;
    private String collaborator;

}
