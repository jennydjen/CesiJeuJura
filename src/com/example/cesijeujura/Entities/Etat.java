package com.example.cesijeujura.Entities;

public enum Etat {
	CREER, A_TRAITER, VALIDATION_BUREAU, DEVIS, ANNULE;
	
	@Override
	public String toString() {
		String result = "";

		switch (this) {
		case CREER:
			result = "Projet";
			break;
		case A_TRAITER:
			result = "A traiter";
			break;
		case VALIDATION_BUREAU:
			result = "Validé par le bureau";
			break;
		case DEVIS:
			result = "Devis";
			break;
		case ANNULE:
			result = "Annulé";
		}

		return result;
	}
}
