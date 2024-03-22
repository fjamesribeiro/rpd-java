package br.com.james.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RoleName {

	ADMIN, PSC, PAC;
	
	@Override
	public String toString() {
		return this.name();
	}

}
