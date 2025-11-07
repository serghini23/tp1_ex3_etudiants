package net.serghini.tp1_ex3.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ResponseAllEtudiantsDTO {
    private Long idEtudiant;
    private String nom;
    private String prenom;
    private String cne;
    private Long idFiliere;
}