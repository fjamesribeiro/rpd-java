package br.com.james.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.james.models.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

}
