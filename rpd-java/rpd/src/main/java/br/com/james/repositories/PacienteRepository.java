package br.com.james.repositories;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.james.models.Paciente;
import br.com.james.models.Psicologo;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

	public ArrayList<Optional<Paciente>> findByPsicologo(Psicologo psicologo);

}
