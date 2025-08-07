package br.com.desafiopotiguar.DesafioPotiguar.repository;

import br.com.desafiopotiguar.DesafioPotiguar.entity.Medicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicaoRepository extends JpaRepository<Medicao, Integer> {
    @Query("SELECT m FROM Medicao m JOIN FETCH m.bobina")
    List<Medicao> findAllWithBobina();
}
