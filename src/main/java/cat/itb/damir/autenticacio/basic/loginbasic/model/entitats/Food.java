package cat.itb.damir.autenticacio.basic.loginbasic.model.entitats;


import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@RequiredArgsConstructor
public class Food {
    @Id
    @GeneratedValue
    private Long id;
    private String nom;
    private String descripcio;
    private double preu;
    private int puntuacio;
}
