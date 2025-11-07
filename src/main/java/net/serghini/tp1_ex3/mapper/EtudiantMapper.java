package net.serghini.tp1_ex3.mapper;


import net.serghini.tp1_ex3.dtos.RequestEtudiantDto;
import net.serghini.tp1_ex3.dtos.ResponseAllEtudiantsDTO;
import net.serghini.tp1_ex3.dtos.ResponseEtudiantDto;
import net.serghini.tp1_ex3.entities.Etudiant;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class EtudiantMapper {


    public Etudiant Dto_to_entity(RequestEtudiantDto requestEtudiantDto) {
        Etudiant etudiant=new Etudiant();
        BeanUtils.copyProperties(requestEtudiantDto, etudiant);

    return etudiant;

    }
    public ResponseEtudiantDto entity_to_Dto(Etudiant etudiant) {
        ResponseEtudiantDto responseEtudiantDto=new ResponseEtudiantDto();
        BeanUtils.copyProperties(etudiant, responseEtudiantDto);
        return responseEtudiantDto;

    }

    public ResponseAllEtudiantsDTO to_Dto(Etudiant etudiant) {
        ResponseAllEtudiantsDTO responseEtudiantDto=new ResponseAllEtudiantsDTO();
        BeanUtils.copyProperties(etudiant, responseEtudiantDto);
        return responseEtudiantDto;

    }


}
