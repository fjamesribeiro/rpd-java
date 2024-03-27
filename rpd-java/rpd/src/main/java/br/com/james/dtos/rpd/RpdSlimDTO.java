package br.com.james.dtos.rpd;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.james.dtos.humor.HumorSlimDTO;
import br.com.james.dtos.paciente.PacienteSlimDTO;
import jakarta.persistence.OrderBy;
import lombok.Data;

@Data
public class RpdSlimDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@OrderBy("id DESC")
	private Long id;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date data;

	private String situacao;

	private String comportamento;

	private PacienteSlimDTO paciente;

	private HumorSlimDTO humor;

	private String pensamento;
}
