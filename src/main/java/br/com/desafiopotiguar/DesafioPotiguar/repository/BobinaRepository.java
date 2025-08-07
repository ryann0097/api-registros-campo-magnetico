package br.com.desafiopotiguar.DesafioPotiguar.repository;

import br.com.desafiopotiguar.DesafioPotiguar.entity.Bobina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BobinaRepository extends JpaRepository<Bobina, Integer> {
}
