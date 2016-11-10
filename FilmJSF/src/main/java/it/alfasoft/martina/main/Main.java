package it.alfasoft.martina.main;

import it.alfasoft.martina.Film;
import it.alfasoft.martina.service.FilmController;

public class Main {

	public static void main(String[] args) {
		
		Film f = new Film("Titanic","2000","James Cameron","Drammatico","movie01");
		
		FilmController fc = new FilmController();
		
		fc.getS().aggiungiFilm(f);
		
        Film f1 = new Film("StarWars","1971","Lucas","Fantasy","movie02");
		
		fc.getS().aggiungiFilm(f1);

	}

}
