package br.com.controletreinamento.ControleTreinamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.controletreinamento.ControleTreinamento.model.Empregado;

@Repository
public interface EmpregadoRepository extends JpaRepository<Empregado, Long> {
}
