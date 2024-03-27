package br.com.james.dtos.rpd;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.james.config.converter.StringToFisiologiaConverter;
import br.com.james.config.converter.StringToSentimentoConverter;
import br.com.james.dtos.fisiologia.FisiologiaSlimDTO;
import br.com.james.dtos.humor.HumorSlimDTO;
import br.com.james.dtos.paciente.PacienteSlimDTO;
import br.com.james.dtos.sentimento.SentimentoSlimDTO;
import jakarta.persistence.Convert;
import lombok.Data;

@Data
public class RpdDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date data;

	private String situacao;

	private String comportamento;

	private PacienteSlimDTO paciente;

	private String pensamento;

	private HumorSlimDTO humor;

	@Convert(converter = StringToFisiologiaConverter.class)
	private Set<FisiologiaSlimDTO> fisiologias;

	@Convert(converter = StringToSentimentoConverter.class)
	private Set<SentimentoSlimDTO> sentimentos;

}
