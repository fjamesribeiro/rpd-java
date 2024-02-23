package br.com.james.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "rpd")
@Getter
@Setter
@NoArgsConstructor
public class Rpd implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "data")
	@DateTimeFormat(pattern = "dd/MM/YYYY")
	private Date data;

	@Column(name = "situacao")
	private String situacao;

	@Column(name = "comportamento")
	private String comportamento;

	@JoinColumn(name = "paciente_id", nullable = false)
	private Paciente paciente;

	@Column(name = "pensamento")
	private String pensamento;

	@ManyToOne()
	@JoinColumn(name = "humor_id")
	private Humor humor;

	@ManyToMany(cascade = CascadeType.REFRESH)
	@JoinTable(name = "rpd_fisiologia", joinColumns = @JoinColumn(name = "rpd_id"), inverseJoinColumns = @JoinColumn(name = "fisiologia_id"))
	private Set<Fisiologia> fisiologias;

	@ManyToMany(cascade = CascadeType.REFRESH)
	@JoinTable(name = "rpd_sentimento", joinColumns = @JoinColumn(name = "rpd_id"), inverseJoinColumns = @JoinColumn(name = "sentimento_id"))
	private Set<Sentimento> sentimentos;
}
