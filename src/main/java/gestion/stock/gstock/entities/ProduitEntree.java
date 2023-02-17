package gestion.stock.gstock.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.*;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProduitEntree {
    @jakarta.persistence.Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Size(min = 4, max = 40)
    @Column(name = "name", nullable = true)
    private String name;
    @Size(min = 1, max = 10)
    @Column(name = "prix", nullable = true)
    private String prix;
    @DecimalMin("2")
    @Column(name = "quantite", nullable = true)
    private int quantite;

}
