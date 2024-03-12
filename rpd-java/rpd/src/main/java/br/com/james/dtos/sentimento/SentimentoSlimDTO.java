package br.com.james.dtos.sentimento;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SentimentoSlimDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String texto;

}
