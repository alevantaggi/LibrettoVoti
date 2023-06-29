package it.polito.tdp.libretto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import it.polito.tdp.libretto.db.VotoDAO;

public class Libretto {
	private List<Voto> voti;

	public Libretto() {
		VotoDAO dao=new VotoDAO();
		this.voti= dao.listVoti();
	}
	
	
/**
 * Aggiungi un nuovo voto al libretto
 * (per ora non fare nessun controllo)
 * @param v Voto da aggiungere
 * @return {@code true} 
 */
	public boolean add(Voto v) {
		if (esisteVotoConflitto(v)|| esisteVotoDuplicato(v)) {
			//System.out.println("Voto errato"); 
			throw new IllegalArgumentException("Voto errato: "+v);
			//return false;
		}
		VotoDAO dao = new VotoDAO();
		dao.createVoto(v);
		
		return voti.add(v);
	}
	
	public void stampa() {
		for (Voto v: voti) {
			System.out.println(v);
		}
	}
	
	@Override
	public String toString() {
		String txt="";
		for(Voto v: this.voti) {
			txt=txt+ v.toString()+"\n";
		}
		return txt;
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

	
	public boolean esisteVotoDuplicato (Voto nuovo) {
		
		for (Voto v: voti) {
			if (v.equalsCorsoPunti(nuovo)) 
				return true;
			}
		return false;
	}
	
	public boolean esisteVotoConflitto (Voto nuovo) {
		
		for (Voto v: voti) {
			if (v.equalsCorso (nuovo)) 
				return true;
			}
		return false;
	}
	/**
	 * Metodo "factory" per creare un nuovo libretto con i voti migliorati
	 * @return
	 */
	public Libretto librettoMigliorato() {
		Libretto migliore= new Libretto();
		migliore.voti= new ArrayList<>(); // Così facendo sono due liste differenti 
		
		for(Voto v: this.voti) {
			
			migliore.voti.add(new Voto(v));
			// oppure migliore.voti.add(v.clone()); 
			// oppure migliore.voti.add(new Voto(v.getCorso(), v.getPunti(), v.getDataEsame())); 
			
			
			
			/* Se avessi fatto: migliore.voti= new ArrayList<>(this.voti); 
			   una volta modificati i voti si sarebbero modificati anche nel libretto originario 
			*/
		}
			
		for(Voto v: migliore.voti) {
			v.setPunti(v.getPunti()+2);
		}
		
		return migliore;
	}
	
	public void cancellaVotiInferiori(int punti) {
		List<Voto> listaDacancellare= new ArrayList<>();
		for(Voto v: this.voti) {
			if(v.getPunti()<punti) {
				listaDacancellare.add(v);
				//voti.remove(v); // Cancella o un indice o l'oggetto stesso usando equals 
			}
		}
		voti.removeAll(listaDacancellare);
		
//		for (Voto vi: listaDacancellare) {
//			this.voti.remove(vi);
//		}
//		
//		
//		for (int i=0; i<this.voti.size();i++) {
//			if(voti.get(i).getPunti()<punti) {
//				this.voti.remove(i);
//			}
//		}
	}
	
	public Libretto librettoOrdinatoAlfa() {
		Libretto ordinato= new Libretto();
		ordinato.voti= new ArrayList<>(this.voti);
		
		Collections.sort(ordinato.voti, new ComparatorePerNome());
		//ordinato.voti.sort(new ComparatorePerNome());
		return ordinato;
	}
	
	public Libretto librettoOrdinatoPerVoto() {
		Libretto ordinato= new Libretto();
		ordinato.voti= new ArrayList<>(this.voti);
		
		ordinato.voti.sort(new Comparator<Voto>() { // Lo posso fare perché l'interfaccia Comparator prescrive un solo metodo al suo interno 

			@Override
			public int compare(Voto voto1, Voto voto2) {
				return - (voto1.getPunti()-voto2.getPunti());
			}
		});
			
		return ordinato;
	}	
}
