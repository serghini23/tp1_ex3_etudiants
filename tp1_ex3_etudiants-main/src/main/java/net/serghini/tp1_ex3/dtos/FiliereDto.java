package net.serghini.tp1_ex3.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FiliereDto {
    private Long idFiliere;
    private String code;
    private String libelle;
}