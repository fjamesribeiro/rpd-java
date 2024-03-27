package br.com.james.models;

import java.io.Serializable;
import java.util.Set;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "paciente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "id")
@OnDelete(action = OnDeleteAction.CASCADE)
public class Paciente extends Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "psicologo_id")
	private Psicologo psicologo;

	@OneToMany(mappedBy = "paciente")
	@OrderBy("id DESC")
	@JsonBackReference
	private Set<Rpd> rpds;

}
