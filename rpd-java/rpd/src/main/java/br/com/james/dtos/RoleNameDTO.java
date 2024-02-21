package br.com.james.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public enum RoleNameDTO {

	ADMIN, PSC, PAC;	
	
	@Override
	public String toString() {
		return this.name();
	}

}
