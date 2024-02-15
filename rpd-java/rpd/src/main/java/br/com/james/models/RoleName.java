package br.com.james.models;

public enum RoleName {

	ADMIN, PSC, PAC;
	
	
	@Override
	public String toString() {
		return this.name();
	}

}
