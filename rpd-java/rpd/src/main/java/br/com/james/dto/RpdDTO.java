package br.com.james.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
public class RpdDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private LocalDate data;

	private String situacao;

	private String comportamento;

	@JsonBackReference
	private PacienteDTO paciente;

	@JsonManagedReference
	private List<PensamentoDTO> pensamentos;

	@JsonManagedReference
	private List<HumorDTO> humores;

	private Set<FisiologiaDTO> fisiologias;

	private Set<SentimentoDTO> sentimentos;

}
