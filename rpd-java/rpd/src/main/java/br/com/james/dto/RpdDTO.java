package br.com.james.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.james.models.Humor;
import br.com.james.utils.converter.StringToFisiologiaConverter;
import br.com.james.utils.converter.StringToSentimentoConverter;
import jakarta.persistence.Convert;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RpdDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	@DateTimeFormat(pattern = "dd/MM/YYYY")
	private Date data;

	private String situacao;

	private String comportamento;

	@JsonBackReference
	private PacienteDTO paciente;

	private String pensamento;

	@JsonManagedReference
	private Humor humor;

	@Convert(converter = StringToFisiologiaConverter.class)
	private Set<FisiologiaDTO> fisiologias;

	@Convert(converter = StringToSentimentoConverter.class)
	private Set<SentimentoDTO> sentimentos;

}
