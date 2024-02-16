package br.com.james.models;

import java.io.Serializable;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "paciente")
@Getter
@Setter
@PrimaryKeyJoinColumn(name="id")
@OnDelete(action = OnDeleteAction.CASCADE) 
public class Paciente extends Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "psicologo_id") // Chave estrangeira para Psicologo
	private Psicologo psicologo;

}
