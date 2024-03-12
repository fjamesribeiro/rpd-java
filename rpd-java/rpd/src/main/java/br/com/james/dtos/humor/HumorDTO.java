package br.com.james.dtos.humor;

import java.io.Serializable;
import java.util.Set;

import br.com.james.dtos.rpd.RpdGetDTO;
import br.com.james.dtos.sentimento.SentimentoSlimDTO;
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

	private Set<RpdGetDTO> rpds;

	private Set<SentimentoSlimDTO> sentimentos;
}
