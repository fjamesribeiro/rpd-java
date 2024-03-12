package br.com.james.models;

import java.io.Serializable;
import java.util.Set;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
@OnDelete(action = OnDeleteAction.CASCADE) 
public class Psicologo extends Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "psicologo")
	private Set<Paciente> pacientes;

	
}
