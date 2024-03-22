package br.com.james.dtos.sentimento;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.james.dtos.humor.HumorSlimDTO;
import br.com.james.dtos.rpd.RpdDTO;
import lombok.Data;

@Data
public class SentimentoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String texto;
	
	@JsonBackReference
	private Set<RpdDTO> rpds;

	private List<HumorSlimDTO> humores;

}
