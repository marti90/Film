package it.alfasoft.martina.service;

import it.alfasoft.martina.Film;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ManagedBean(name="c",eager=true)
@SessionScoped
public class FilmController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Servizi s;
	private List<Film> listaFilm;
	
	
	public FilmController(){
		s= new Servizi();
		
	}

	public Servizi getS() {
		return s;
	}

	public void setS(Servizi s) {
		this.s = s;
	}

	public List<Film> getListaFilm() {
		return listaFilm;
	}

	public void setListaFilm(List<Film> listaFilm) {
		this.listaFilm = listaFilm;
	}
	
	public String cancellaFilm(long id_film){
		Film f= s.getFilmConId(id_film);
		s.cancellaFilm(f);
		return "HomeFilm?faces-redirect=true";
	}
	
	public String registraFilm(Film f){
		s.aggiungiFilm(f);
		
		return "HomeFilm";
	}
	
	public void redirect() throws IOException{
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		context.redirect(context.getRequestContextPath() + "/formFilm.xhtml");
	}
	
	public String modificaFilm(long id_film){
		
		Film film = s.getFilmConId(id_film);
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		Map<String,Object> requestMap= context.getRequestMap();
		requestMap.put("f", film);
		
		return "modificaFilm";
				
	}
	
	public String aggiornaFilm(Film f){
		s.modificaFilm(f);
		return "HomeFilm?faces-redirect=true";
	}
	
	public void caricaFilm(){
		setListaFilm(s.getTuttiFilm());
		
	}

}
