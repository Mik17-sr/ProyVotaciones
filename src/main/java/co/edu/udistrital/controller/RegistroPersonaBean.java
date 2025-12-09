package co.edu.udistrital.controller;

import java.io.Serializable;
import java.util.ArrayList;

import co.edu.udistrital.model.PersonaDTO;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named
@SessionScoped
public class RegistroPersonaBean implements Serializable {
	private PersonaDTO persona = new PersonaDTO();
	private ArrayList<PersonaDTO> listaPersonas = new ArrayList<E>();
	
	public RegistroPersonaBean() {
		super();
	}
	
	public PersonaDTO getPersona() {
		return persona;
	}
	
	public void setPersona(PersonaDTO persona) {
		this.persona = persona;
	}
	
	public void registrarVotante() {
		listaPersonas.add(persona);
		persona = new PersonaDTO();
	}
	
	
}
