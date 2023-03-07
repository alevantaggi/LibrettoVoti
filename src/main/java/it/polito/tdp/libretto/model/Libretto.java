package it.polito.tdp.libretto.model;

import java.util.*;

public class Libretto {
	private List<Voto> voti;

	public Libretto() {
	this.voti= new ArrayList<>();
	}
	
	
/**
 * Aggiungi un nuovo voto al libretto
 * (per ora non fare nessun controllo)
 * @param v Voto da aggiungere
 * @return {@code true}
 */
	public boolean add(Voto v) {
		 return voti.add(v);
	}
	
	public void stampa() {
		for (Voto v: voti) {
			System.out.println(v);
		}
	}
	
	public void stampaPuntiUguali(int valore) {
		for (Voto v: voti) {
			if(v.getPunti()==valore) 
				System.out.println(v);			
		}
	}
	
	public Voto cercaVoto(String nomeCorso) {
		
		for (Voto v: voti) {
			if (v.getCorso().compareTo(nomeCorso)==0) {
				return v;
			}
		}
		
		return null;
		//throw new RuntimeException("Voto non trovato"); // Devo riservare le eccezioni per casi di errore 
	}

	
	public boolean esisteVoto (Voto nuovo) {
		
		for (Voto v: voti) {
			if (v.equalsCorsoPunti(nuovo)) 
				return true;
			}
		return false;
	}
	
}
