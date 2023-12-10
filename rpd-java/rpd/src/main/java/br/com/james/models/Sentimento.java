package br.com.james.models;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "sentimento")
public class Sentimento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "texto", nullable = false)
	private String texto;

	@ManyToMany(mappedBy = "sentimentos")
	private Set<Rpd> rpds;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "humor_sentimento", joinColumns = @JoinColumn(name = "sentimento_id"), inverseJoinColumns = @JoinColumn(name = "humor_id"))
	private Set<Humor> humores;

}