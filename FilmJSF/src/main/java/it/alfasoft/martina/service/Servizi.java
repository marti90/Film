package it.alfasoft.martina.service;

import java.util.List;

import it.alfasoft.martina.Film;
import it.alfasoft.martina.dao.FilmDAO;

public class Servizi {
	
	FilmDAO fDao = new FilmDAO();
	
	public boolean aggiungiFilm(Film f){
		
		boolean res= fDao.createFilm(f);
		return res;
	}
	
	public boolean cancellaFilm(Film f){
		
		boolean res= fDao.deleteFilm(f);
		return res;
	}
	
	public List<Film> getTuttiFilm(){
		
		return fDao.readFilm();
	}

}
