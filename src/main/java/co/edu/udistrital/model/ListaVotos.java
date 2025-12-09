package co.edu.udistrital.model;

import java.util.ArrayList;

public class ListaVotos {
	private ArrayList<Voto> listaVotos;

	public ListaVotos() {
		super();
	}

	public ListaVotos(ArrayList<Voto> listaVotos) {
		super();
		this.listaVotos = listaVotos;
	}
	
	public ArrayList<Voto> getListaVotos() {
		return listaVotos;
	}

	public void setListaVotos(ArrayList<Voto> listaVotos) {
		this.listaVotos = listaVotos;
	}
}
