package br.com.james.models;

import java.io.Serializable;
import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "psicologo")
@Getter
@Setter
@PrimaryKeyJoinColumn(name="id")
@OnDelete(action = OnDeleteAction.CASCADE) 
public class Psicologo extends Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "psicologo")
	private List<Paciente> pacientes;

	
}
