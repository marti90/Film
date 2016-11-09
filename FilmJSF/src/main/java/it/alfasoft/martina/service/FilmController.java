package it.alfasoft.martina.service;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="c",eager=true)
public class FilmController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Servizi s;
	
	public FilmController(){
		
		setS(new Servizi());
	}

	public Servizi getS() {
		return s;
	}

	public void setS(Servizi s) {
		this.s = s;
	}
	
	

}
