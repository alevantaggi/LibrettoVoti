package it.polito.tdp.libretto.model;

import java.time.LocalDate;

public class TestLibretto {

	public static void main(String[] args) {
		Libretto libretto= new Libretto();
		
		libretto.add(new Voto("Analisi 1", 29, LocalDate.of(2021, 02, 15)));
		libretto.add(new Voto("Fisica 2", 21, LocalDate.of(2022, 06, 10)));
		libretto.add(new Voto("Informatica", 25, LocalDate.of(2021, 07, 01)));
		
		libretto.stampaPuntiUguali(25);
		
		System.out.println(libretto.cercaVoto("Analisi 1"));
		System.out.println(libretto.cercaVoto("Analisi 2"));
		
		Voto a1bis= new Voto("Analisi 1", 29, LocalDate.of(2021, 02, 15));
		Voto a1ter= new Voto("Analisi 1", 30, LocalDate.of(2021, 02, 15));
		
		System.out.println(a1bis+" è duplicato: "+ libretto.esisteVoto(a1bis));
		System.out.println(a1ter+" è duplicato: "+ libretto.esisteVoto(a1ter));

	}

}
