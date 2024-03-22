package br.com.james.dtos.rpd;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.james.dtos.paciente.PacienteSlimDTO;
import lombok.Data;

@Data
public class RpdSlimDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	@DateTimeFormat(pattern = "dd/MM/YYYY")
	private Date data;

	private String situacao;

	private String comportamento;

	private PacienteSlimDTO paciente;

	private String pensamento;
}
