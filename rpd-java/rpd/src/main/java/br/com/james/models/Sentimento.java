package br.com.james.models;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Data
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
	
	@ManyToMany()
	@JoinTable(name = "humor_sentimento", joinColumns = @JoinColumn(name = "sentimento_id"), inverseJoinColumns = @JoinColumn(name = "humor_id"))
	private Set<Humor> humores;

}
