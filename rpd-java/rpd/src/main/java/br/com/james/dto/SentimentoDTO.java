package br.com.james.dto;

import java.io.Serializable;
import java.util.Set;

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

	private Set<HumorDTO> humores;

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getId().toString();
	}
}
