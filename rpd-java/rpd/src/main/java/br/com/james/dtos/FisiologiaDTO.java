package br.com.james.dtos;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FisiologiaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String texto;

    @JsonBackReference(value = "fisiologia-rpds")
	private Set<RpdDTO> rpds;

	@Override
	public String toString() {
		return this.getId().toString();
	}

}
