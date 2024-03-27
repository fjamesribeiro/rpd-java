package br.com.james.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.james.models.Rpd;

@Repository
public interface RpdRepository extends JpaRepository<Rpd, Long> {

	List<Rpd> findByPacienteId(Long id);

}
