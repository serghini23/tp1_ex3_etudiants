package net.serghini.tp1_ex3.repository;

import net.serghini.tp1_ex3.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
}
