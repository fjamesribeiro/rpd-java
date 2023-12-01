package br.com.james.models;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.james.dto.HumorDTO;
import br.com.james.dto.RpdDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "humor")
@Getter
@Setter
@NoArgsConstructor
public class Humor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "texto", nullable = false)
	private String texto;

	@JsonBackReference
	@ManyToOne()
	@JoinColumn(name = "rpd_id")
	private Rpd rpd;

	@ManyToMany(mappedBy = "humores", fetch = FetchType.EAGER)
	private Set<Sentimento> sentimentos;

}
