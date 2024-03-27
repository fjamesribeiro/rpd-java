package br.com.james.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.james.models.Psicologo;

@Repository
public interface PsicologoRepository extends JpaRepository<Psicologo, Long> {
	
	public Optional<Psicologo> findByEmail(String email);

}
