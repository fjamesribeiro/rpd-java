package br.com.james.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity(name = "rpd")
@Data
public class Rpd implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "data")
	private LocalDate data;

	@Column(name = "situacao")
	private String situacao;

	@Column(name = "comportamento")
	private String comportamento;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "paciente_id", nullable = false)
	private Paciente paciente;

	@ManyToMany()
	@JoinTable(name = "rpd_fisiologia", joinColumns = @JoinColumn(name = "rpd_id"), inverseJoinColumns = @JoinColumn(name = "fisiologia_id"))
	private Set<Fisiologia> fisiologias;

}
