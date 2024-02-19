package br.com.james.dtos;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HumorDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String texto;

	@JsonManagedReference(value="2")
	private Set<RpdDTO> rpds;

	@JsonBackReference
	private Set<SentimentoDTO> sentimentos;
}
