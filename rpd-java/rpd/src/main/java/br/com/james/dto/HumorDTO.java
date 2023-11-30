package br.com.james.dto;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
public class HumorDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String texto;

	@JsonBackReference
	private RpdDTO rpd;

	private Set<SentimentoDTO> sentimentos;
}
