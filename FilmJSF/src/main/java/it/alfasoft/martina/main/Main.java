package it.alfasoft.martina.main;

import it.alfasoft.martina.Film;
import it.alfasoft.martina.service.FilmController;
import it.alfasoft.martina.service.Servizi;

public class Main {

	public static void main(String[] args) {
		
		Film f = new Film("Titanic","2000","James Cameron","Drammatico","movie01");
		Servizi s= new Servizi();
		s.aggiungiFilm(f);
        Film f1 = new Film("StarWars","1971","Lucas","Fantasy","movie02");
		
		s.aggiungiFilm(f1);
	}

}
