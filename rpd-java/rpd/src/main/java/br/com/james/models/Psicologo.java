package br.com.james.models;

import java.io.Serializable;
import java.util.Set;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "psicologo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name="id")
@OnDelete(action = OnDeleteAction.CASCADE) 
public class Psicologo extends Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "psicologo")
	private Set<Paciente> pacientes;

	
}
