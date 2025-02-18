package it.polito.tdp.libretto.model;

import java.time.LocalDate;

public class TestLibretto {

	public static void main(String[] args) {
		Libretto libretto= new Libretto();
		
		libretto.add(new Voto("Analisi 1", 29, LocalDate.of(2021, 02, 15)));
		libretto.add(new Voto("Fisica 2", 21, LocalDate.of(2022, 06, 10)));
		libretto.add(new Voto("Fisica 3", 22, LocalDate.of(2022, 06, 10)));
		libretto.add(new Voto("Informatica", 25, LocalDate.of(2021, 07, 01)));
		
		libretto.stampaPuntiUguali(25);
		
		System.out.println(libretto.cercaVoto("Analisi 1"));
		System.out.println(libretto.cercaVoto("Analisi 2"));
		
		Voto a1bis= new Voto("Analisi 1", 29, LocalDate.of(2021, 02, 15));
		Voto a1ter= new Voto("Analisi 1", 30, LocalDate.of(2021, 02, 15));
		
		System.out.println(a1bis+" è duplicato: "+ libretto.esisteVotoDuplicato(a1bis));
		System.out.println(a1ter+" è duplicato: "+ libretto.esisteVotoDuplicato(a1ter));

		System.out.println(a1ter+" è duplicato: "+ libretto.esisteVotoConflitto(a1bis));
		try {
			libretto.add(a1bis);
			
		}catch (Exception e) {
			System.out.println("Errore nell'inserimento voto.");
			System.out.println(e.getMessage());

		}
		
		System.out.println("LIBRETTO ORIGINARIO:");
		libretto.stampa();
//		
//		Libretto migliore=libretto.librettoMigliorato();
//		System.out.println("LIBRETTO MIGLIORATO:");
//		migliore.stampa();
//		
//		System.out.println("LIBRETTO ORIGINARIO:");
//		libretto.stampa();
//		
//		libretto.cancellaVotiInferiori(24);
//		System.out.println("LIBRETTO ORIGINARIO MODIFICATO:");
//		libretto.stampa();

		System.out.println("LIBRETTO ORDINE ALFABETICO:");
		libretto.librettoOrdinatoAlfa().stampa();

		System.out.println("LIBRETTO ORDINE PER VOTO:");
		libretto.librettoOrdinatoPerVoto().stampa();
		

	}

}
