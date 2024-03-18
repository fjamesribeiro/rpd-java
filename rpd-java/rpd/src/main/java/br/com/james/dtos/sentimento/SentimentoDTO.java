package br.com.james.dtos.sentimento;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import br.com.james.dtos.humor.HumorSlimDTO;
import br.com.james.dtos.rpd.RpdDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SentimentoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String texto;
	
	private Set<RpdDTO> rpds;

	private List<HumorSlimDTO> humores;

}
