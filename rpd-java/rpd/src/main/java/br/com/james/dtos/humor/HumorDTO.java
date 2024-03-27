package br.com.james.dtos.humor;

import java.io.Serializable;
import java.util.Set;

import br.com.james.dtos.rpd.RpdDTO;
import br.com.james.dtos.sentimento.SentimentoSlimDTO;
import lombok.Data;

@Data
public class HumorDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String texto;

	private Set<RpdDTO> rpds;

	private Set<SentimentoSlimDTO> sentimentos;
}
