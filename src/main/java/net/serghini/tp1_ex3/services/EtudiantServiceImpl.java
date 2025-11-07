package net.serghini.tp1_ex3.services;

import lombok.AllArgsConstructor;

import net.serghini.tp1_ex3.client.FiliereClient;
import net.serghini.tp1_ex3.dtos.FiliereDto;
import net.serghini.tp1_ex3.dtos.RequestEtudiantDto;
import net.serghini.tp1_ex3.dtos.ResponseAllEtudiantsDTO;
import net.serghini.tp1_ex3.dtos.ResponseEtudiantDto;
import net.serghini.tp1_ex3.entities.Etudiant;
import net.serghini.tp1_ex3.mapper.EtudiantMapper;
import net.serghini.tp1_ex3.repository.EtudiantRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class EtudiantServiceImpl implements EtudiantService {
    private EtudiantRepository etudiantRepository;
    private EtudiantMapper etudiantMapper;
    private FiliereClient filiereClient;

    @Override
    public ResponseEtudiantDto addEtudiant(RequestEtudiantDto requestEtudiantDto) {
        Etudiant etudiant1 = etudiantMapper.Dto_to_entity(requestEtudiantDto);
        Etudiant saved = etudiantRepository.save(etudiant1);


        return etudiantMapper.entity_to_Dto(saved);
    }

    @Override
    public ResponseEtudiantDto getEtudiantById(Long id) {

        Etudiant etudiant = etudiantRepository.findById(id).orElseThrow();


        ResponseEtudiantDto response = etudiantMapper.entity_to_Dto(etudiant);


        FiliereDto filiere = filiereClient.getFiliereById(etudiant.getIdFiliere());
        if (filiere != null) {
            response.setFiliere(filiere);
        }else {
            filiere=null;}


        return response;
    }

@Override
public List<ResponseAllEtudiantsDTO> getAllEtudiants() {
    List<Etudiant> allEtu = etudiantRepository.findAll();
    List<ResponseAllEtudiantsDTO> all_etu = new ArrayList<>();
    for (Etudiant e : allEtu) {
        all_etu.add(etudiantMapper.to_Dto(e));

    }


    return all_etu ;
}

@Override
public ResponseEtudiantDto update_etu(Long id,RequestEtudiantDto requestEtudiantDto) {

    Etudiant new_etudiant= etudiantMapper.Dto_to_entity(requestEtudiantDto);
    Etudiant etudiant1 = etudiantRepository.findById(id).orElseThrow();

    if(new_etudiant.getNom()!=null)  etudiant1.setNom(new_etudiant.getNom());
    if(new_etudiant.getPrenom()!=null) etudiant1.setPrenom(new_etudiant.getPrenom());
    if(new_etudiant.getCne()!=null) etudiant1.setCne(new_etudiant.getCne());
    if(new_etudiant.getIdFiliere()!=null)etudiant1.setIdFiliere(new_etudiant.getIdFiliere());



    Etudiant saved_etu = etudiantRepository.save(etudiant1);


    return etudiantMapper.entity_to_Dto(saved_etu);
}

@Override
public void delete_etu(Long id) {

    etudiantRepository.deleteById(id);;
}
}
