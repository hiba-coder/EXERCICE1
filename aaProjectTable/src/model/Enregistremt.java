package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Enregistremt {

	int nbdesEnreg;
	String[] enreg = new String[nbdesEnreg];
	
	
	public int getNbdesEnreg() {
		return nbdesEnreg;
	}

	public void setNbdesEnreg(int nbdesEnreg) {
		this.nbdesEnreg = nbdesEnreg;
	}

	public String[] getEnreg() {
		return enreg;
	}

	public void setEnreg(String[] enreg) {
		this.enreg = enreg;
	}

	@Override
	public String toString() {
		return "Enregistremt [enreg=" + Arrays.toString(enreg) + "]";
	}

	
	
}
