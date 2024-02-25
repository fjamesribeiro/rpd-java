package br.com.james.dtos;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import br.com.james.config.converter.StringToFisiologiaConverter;
import br.com.james.config.converter.StringToSentimentoConverter;
import jakarta.persistence.Convert;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class RpdDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	@DateTimeFormat(pattern = "dd/MM/YYYY")
	private Date data;

	private String situacao;

	private String comportamento;

	private String pensamento;

	private PacienteDTO paciente;

	private HumorDTO humor;

	@Convert(converter = StringToFisiologiaConverter.class)
	private Set<FisiologiaDTO> fisiologias;

	@Convert(converter = StringToSentimentoConverter.class)
	private Set<SentimentoDTO> sentimentos;

}
