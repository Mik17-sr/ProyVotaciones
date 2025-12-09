package co.edu.udistrital.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Tarjeton implements Serializable {
	private static final long serialVersionUID = -9110030907811887443L;
	private ArrayList<MotoDTO> motos; 
	
	public Tarjeton() {
		super();
	}

	public Tarjeton(ArrayList<MotoDTO> motos) {
		super();
		this.motos = motos;
	}

	public ArrayList<MotoDTO> getMotos() {
		return motos;
	}

	public void setMotos(ArrayList<MotoDTO> motos) {
		this.motos = motos;
	}
}
