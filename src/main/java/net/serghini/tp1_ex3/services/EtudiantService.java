package net.serghini.tp1_ex3.services;



import net.serghini.tp1_ex3.dtos.RequestEtudiantDto;
import net.serghini.tp1_ex3.dtos.ResponseAllEtudiantsDTO;
import net.serghini.tp1_ex3.dtos.ResponseEtudiantDto;

import java.util.List;


public interface EtudiantService {
    public ResponseEtudiantDto addEtudiant(RequestEtudiantDto requestEtudiantDto);
    public ResponseEtudiantDto getEtudiantById(Long id);
    public List<ResponseAllEtudiantsDTO>  getAllEtudiants();
    public ResponseEtudiantDto update_etu(Long id,RequestEtudiantDto requestEtudiantDto);
    public void delete_etu(Long id);


}
