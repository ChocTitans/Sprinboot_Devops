package gestion.stock.gstock.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProduitEntree {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Size(min = 4, max = 40)
    @Column(name = "name")
    private String name;
    @Size(min = 1, max = 10)
    @Column(name = "prix")
    private String prix;
    @DecimalMin("2")
    @Column(name = "quantite")
    private int quantite;

}
