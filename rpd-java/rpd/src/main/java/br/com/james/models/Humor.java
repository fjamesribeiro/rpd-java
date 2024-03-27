package br.com.james.models;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity(name = "humor")
@Data
public class Humor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "texto", nullable = false)
	private String texto;

	@OneToMany(mappedBy = "humor")
	@JsonBackReference
	private Set<Rpd> rpds;

	@ManyToMany(mappedBy = "humores", fetch = FetchType.EAGER)
	private Set<Sentimento> sentimentos;

}
