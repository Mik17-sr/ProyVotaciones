package co.edu.udistrital.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Tarjeton implements Serializable {
	private static final long serialVersionUID = -9110030907811887443L;
	private ArrayList<MotoDTO> motos; 
	
	public Tarjeton() {
		super();
		this.motos = new ArrayList<>();
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
	
	public void cargarMotos() {
	    motos.add(new MotoDTO("Agusta", "Italia", 1, "img/agusta.png"));
	    motos.add(new MotoDTO("Bajaj", "India", 2, "img/bajaj.png"));
	    motos.add(new MotoDTO("BMW", "Alemania", 3, "img/bmw.png"));
	    motos.add(new MotoDTO("CFMoto", "China", 4, "img/cfmoto.png"));
	    motos.add(new MotoDTO("Ducati", "Italia", 5, "img/ducati.png"));
	    motos.add(new MotoDTO("Harley-Davidson", "Estados Unidos", 6, "img/harleydavidson.png"));
	    motos.add(new MotoDTO("Kawasaki", "Japón", 7, "img/kawasaki.png"));
	    motos.add(new MotoDTO("KTM", "Austria", 8, "img/ktm.png"));
	    motos.add(new MotoDTO("Royal Enfield", "India", 9, "img/royalenfield.png"));
	    motos.add(new MotoDTO("Suzuki", "Japón", 10, "img/suzuki.png"));
	    motos.add(new MotoDTO("SYM", "Taiwán", 11, "img/sym.png"));
	    motos.add(new MotoDTO("Triumph", "Reino Unido", 12, "img/triumph.png"));
	    motos.add(new MotoDTO("TVS", "India", 13, "img/tvs.png"));
	    motos.add(new MotoDTO("Voge", "China", 14, "img/voge.png"));
	    motos.add(new MotoDTO("Yamaha", "Japón", 15, "img/yamaha.png"));
	    motos.add(new MotoDTO("Voto en Blanco", "Blanco", 16, "img/votoBlanco.png"));
	}
}
