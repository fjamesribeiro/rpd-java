package br.com.james.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.james.models.Paciente;
import br.com.james.models.Psicologo;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

	public Set<Paciente> findByPsicologo(Psicologo psicologo);

}
