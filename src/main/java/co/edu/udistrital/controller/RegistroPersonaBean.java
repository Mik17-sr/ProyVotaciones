package co.edu.udistrital.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import co.edu.udistrital.model.ListaVotos;
import co.edu.udistrital.model.PersonaDTO;
import co.edu.udistrital.model.Voto;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

@Named
@SessionScoped
public class RegistroPersonaBean implements Serializable {
	private static final long serialVersionUID = 3383865556109331597L;
	private PersonaDTO persona = new PersonaDTO();
	private ArrayList<PersonaDTO> listaPersonas = new ArrayList<>();
	private boolean registroExitoso = false;
	private ListaVotos listaVotos = new ListaVotos();
	private Date hoy = new Date();
	
	public RegistroPersonaBean() {
		super();
		listaVotos.setListaVotos(new ArrayList<Voto>());
	}
	
	public PersonaDTO getPersona() {
		return persona;
	}
	
	public void setPersona(PersonaDTO persona) {
		this.persona = persona;
	}
	
	public ArrayList<PersonaDTO> getListaPersonas() {
		return listaPersonas;
	}

	public void setListaPersonas(ArrayList<PersonaDTO> listaPersonas) {
		this.listaPersonas = listaPersonas;
	}

	public boolean isRegistroExitoso() {
		return registroExitoso;
	}

	public void setRegistroExitoso(boolean registroExitoso) {
		this.registroExitoso = registroExitoso;
	}

	public ListaVotos getListaVotos() {
		return listaVotos;
	}

	public void setListaVotos(ListaVotos listaVotos) {
		this.listaVotos = listaVotos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Date getHoy() {
		return hoy;
	}

	public void setHoy(Date hoy) {
		this.hoy = hoy;
	}

	public void registrarVotante() {
		for(PersonaDTO p : listaPersonas) {
			if(p.getId().equals(persona.getId())) {
				registroExitoso = false;
				return;
			}
		}
		listaPersonas.add(persona);
		registroExitoso = true;
		FacesMessage msg = new FacesMessage(
                FacesMessage.SEVERITY_INFO,
                "Éxito",
                "Persona registrada correctamente"
        );
        FacesContext.getCurrentInstance().addMessage(null, msg);
        persona = new PersonaDTO();
	}
	
	public boolean haVotado(PersonaDTO p) {
	    for (Voto v : listaVotos.getListaVotos()) {
	        if (v.getPersona().getId().equals(p.getId())) {
	            return true;
	        }
	    }
	    return false;
	}
	
	public Voto obtenerVoto(PersonaDTO persona) {
	    Voto voto = null;
	    for(Voto v : listaVotos.getListaVotos()) {
	    	if(persona.equals(v.getPersona())) {
	    		voto = v;
	    	}
	    }
	    return voto;
	}

}
