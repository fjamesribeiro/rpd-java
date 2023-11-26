package br.com.james.dto;

import java.io.Serializable;
import java.util.List;

import br.com.james.models.Paciente;

public class PsicologoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String firstName;

	private String lastName;

	private String email;

	private List<Paciente> pacientes;

	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
