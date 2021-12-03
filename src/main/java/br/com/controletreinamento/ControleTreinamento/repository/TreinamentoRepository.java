package br.com.controletreinamento.ControleTreinamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.controletreinamento.ControleTreinamento.model.Treinamento;

@Repository
public interface TreinamentoRepository extends JpaRepository<Treinamento, Long> {
}
