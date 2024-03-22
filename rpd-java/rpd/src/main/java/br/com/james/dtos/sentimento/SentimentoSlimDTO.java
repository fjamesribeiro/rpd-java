package br.com.james.dtos.sentimento;

import java.io.Serializable;

import lombok.Data;

@Data
public class SentimentoSlimDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String texto;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.id.toString();
	}

}
