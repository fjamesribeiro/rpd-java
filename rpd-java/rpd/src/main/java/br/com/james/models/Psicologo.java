package br.com.james.models;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "psicologo")
@Getter
@Setter
@NoArgsConstructor
@PrimaryKeyJoinColumn(name="id")
public class Psicologo extends Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "psicologo")
	private List<Paciente> pacientes;
	
}
