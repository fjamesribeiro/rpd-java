package br.com.james.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.james.models.Rpd;
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

	@JsonBackReference
	private List<Rpd> rpds;

	@JsonBackReference
	private Set<SentimentoDTO> sentimentos;
}
