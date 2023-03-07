package it.polito.tdp.libretto.model;
import java.time.LocalDate;

public class Voto {
	private String corso; 
	private int punti;
	private LocalDate dataEsame;
	
	
	public Voto(String corso, int punti, LocalDate dataEsame) {
		this.corso = corso;
		this.punti = punti;
		this.dataEsame = dataEsame;
	}


	public String getCorso() {
		return corso;
	}


	public void setCorso(String corso) {
		this.corso = corso;
	}


	public int getPunti() {
		return punti;
	}


	public void setPunti(int punti) {
		this.punti = punti;
	}


	public LocalDate getDataEsame() {
		return dataEsame;
	}


	public void setDataEsame(LocalDate dataEsame) {
		this.dataEsame = dataEsame;
	}


	@Override
	public String toString() {
		return corso + " (" + punti+") "+ "il "+ dataEsame;
	}


	public boolean equalsCorsoPunti(Voto nuovo) {
		if(nuovo.getCorso().compareTo(corso)==0 && nuovo.getPunti()==punti) {
			return true;
		}
		return false;
	}


	

	
	
}
