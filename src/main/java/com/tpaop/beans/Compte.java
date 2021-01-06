package com.tpaop.beans;

import org.springframework.stereotype.Component;

@Component
public class Compte implements Icompte {
	private double solde = 3000;

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}
	
	@Override
	public void debiter(double mt) {
		solde -= mt;
	}
	
	@Override
	public void approvisionner(double mt) {
		solde += mt;
	}
}
