package co.edu.udistrital.controller;

import co.edu.udistrital.model.PersonaDTO;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class UsuarioBean {
	private PersonaDTO persona;
	
	public UsuarioBean() {
		super();
	}
	
	public PersonaDTO getPersona() {
		return persona;
	}
	
	public void setPersona(PersonaDTO persona) {
		this.persona = persona;
	}
	
	public void anadirVotante() {
		
	}
}
