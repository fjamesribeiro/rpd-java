package br.com.james.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.james.models.Fisiologia;

@Repository
public interface FisiologiaRepository extends JpaRepository<Fisiologia, Long> {

}
