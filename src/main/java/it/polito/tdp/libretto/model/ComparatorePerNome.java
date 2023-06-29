package it.polito.tdp.libretto.model;

import java.util.Comparator;

public class ComparatorePerNome implements Comparator<Voto> {

	@Override
	public int compare(Voto voto1, Voto voto2) {
		return voto1.getCorso().compareTo(voto2.getCorso());
	}

}
