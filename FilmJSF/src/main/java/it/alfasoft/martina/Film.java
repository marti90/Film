package it.alfasoft.martina;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@ManagedBean(name="fil", eager=true)
@SessionScoped
@Entity
public class Film implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id_film;
	
	private String titolo;
	private String dataUscita;
	private String regista;
	private String genere;
	private String codiceFilm;
	
	public Film(){
		
	}

	public Film(String titolo, String dataUscita, String regista, String genere, String codiceFilm) {
		this.titolo = titolo;
		this.dataUscita = dataUscita;
		this.regista = regista;
		this.genere = genere;
		this.codiceFilm = codiceFilm;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getDataUscita() {
		return dataUscita;
	}

	public void setDataUscita(String dataUscita) {
		this.dataUscita = dataUscita;
	}

	public String getRegista() {
		return regista;
	}

	public void setRegista(String regista) {
		this.regista = regista;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	public String getCodiceFilm() {
		return codiceFilm;
	}

	public void setCodiceFilm(String codiceFilm) {
		this.codiceFilm = codiceFilm;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public long getId_film() {
		return id_film;
	}

	public void setId_film(long id_film) {
		this.id_film = id_film;
	}
	
	public void validazioneCodFilm(FacesContext context, 
            UIComponent component,
            Object value) throws ValidatorException{

                      if(value==null){
                      return;
                      }
                      String dato=value.toString();
                      if(!dato.startsWith("movie")){
                                 FacesMessage msg= new FacesMessage("Il Codice Film è SBAGLIATO!");
                                 throw new ValidatorException(msg);
                                 }

           }

}
