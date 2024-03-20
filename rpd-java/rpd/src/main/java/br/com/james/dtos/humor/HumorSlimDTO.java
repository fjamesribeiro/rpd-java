package br.com.james.dtos.humor;

import java.io.Serializable;

import lombok.Data;

@Data
public class HumorSlimDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String texto;

}
