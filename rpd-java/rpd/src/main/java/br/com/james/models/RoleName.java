package br.com.james.models;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public enum RoleName {

	ADMIN, PSC, PAC;
	
	
	@Override
	public String toString() {
		return this.name();
	}

}
