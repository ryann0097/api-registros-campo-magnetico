package br.com.desafiopotiguar.DesafioPotiguar.repository;

import br.com.desafiopotiguar.DesafioPotiguar.entity.Registro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroRepository extends JpaRepository<Registro, Integer> {
}
