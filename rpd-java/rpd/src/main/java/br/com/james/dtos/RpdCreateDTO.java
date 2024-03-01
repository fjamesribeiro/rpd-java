package br.com.james.dtos;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.james.config.converter.StringToFisiologiaConverter;
import br.com.james.config.converter.StringToSentimentoConverter;
import jakarta.persistence.Convert;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RpdCreateDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	@DateTimeFormat(pattern = "dd/MM/YYYY")
	private Date data;

	private String situacao;

	private String comportamento;
	
	@JsonBackReference(value = "1")
	private PacienteDTO paciente;

	private String pensamento;

	@JsonBackReference(value = "2")
	private HumorDTO humor;

	@JsonBackReference(value = "3")
	@Convert(converter = StringToFisiologiaConverter.class)
	private Set<FisiologiaDTO> fisiologias;

	@JsonBackReference(value = "4")
	@Convert(converter = StringToSentimentoConverter.class)
	private Set<SentimentoDTO> sentimentos;

}
