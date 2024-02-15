package br.com.james.models;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "paciente")
@Getter
@Setter
@NoArgsConstructor
@PrimaryKeyJoinColumn(name="id")
public class Paciente extends Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "psicologo_id") // Chave estrangeira para Psicologo
	private Psicologo psicologo;

}
