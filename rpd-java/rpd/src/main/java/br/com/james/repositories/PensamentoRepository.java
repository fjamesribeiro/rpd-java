package br.com.james.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.james.models.Pensamento;

@Repository
public interface PensamentoRepository extends JpaRepository<Pensamento, Long> {

}