package it.alfasoft.martina.utility;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

import it.alfasoft.martina.Film;
import it.alfasoft.martina.service.FilmController;
import it.alfasoft.martina.service.Servizi;
 
@ManagedBean(name="dtEditView")
@SessionScoped
public class EditView implements Serializable {
     
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Film> film;
	List<String> generi = new ArrayList<String>();
	
	private Servizi s;
         
    @ManagedProperty("#{filmController}")
    private FilmController controller;
     
    @PostConstruct
    public void init() {
    	setS(new Servizi());
        film = s.getTuttiFilm();
        generi.add("Drammatico");
		generi.add("Commedia");
		generi.add("Fantasy");
		generi.add("Horror");
    }
 
    public List<Film> getFilm() {
        return film;
    }
    
    public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public FilmController getController() {
		return controller;
	}

	public void setFilm(List<Film> film) {
		this.film = film;
	}

	public List<String> getGeneri() {
        return generi;
    }
	
    public void setGeneri(List<String> generi) {
		this.generi = generi;
	}

	public void setController(FilmController controller) {
        this.controller = controller;
    }
     
    public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Film Edited", ((Film) event.getObject()).getTitolo());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        s.modificaFilm((Film) event.getObject());
    }
     
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", ((Film) event.getObject()).getTitolo());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
         
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

	public Servizi getS() {
		return s;
	}

	public void setS(Servizi s) {
		this.s = s;
	}
    
}