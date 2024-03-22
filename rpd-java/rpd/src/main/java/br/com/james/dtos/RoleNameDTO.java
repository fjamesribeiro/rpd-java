package br.com.james.dtos;

import lombok.Getter;

@Getter
public enum RoleNameDTO {

	ADMIN, PSC, PAC;	
	
	@Override
	public String toString() {
		return this.name();
	}

}
