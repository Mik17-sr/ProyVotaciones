package co.edu.udistrital.model;

import java.io.Serializable;

public class Voto implements Serializable{
	private static final long serialVersionUID = 7891124043315755756L;
	private int nroTarjeton;
	private MotoDTO motoElegida;
	private PersonaDTO persona;
	
	public Voto() {
		super();
	}
	
	public Voto(int nroTarjeton, MotoDTO motoElegida, PersonaDTO persona) {
		super();
		this.nroTarjeton = nroTarjeton;
		this.motoElegida = motoElegida;
		this.persona = persona;
	}

	public int getNroTarjeton() {
		return nroTarjeton;
	}
	public void setNroTarjeton(int nroTarjeton) {
		this.nroTarjeton = nroTarjeton;
	}
	public MotoDTO getMotoElegida() {
		return motoElegida;
	}
	public void setMotoElegida(MotoDTO motoElegida) {
		this.motoElegida = motoElegida;
	}
	public PersonaDTO getPersona() {
		return persona;
	}
	public void setPersona(PersonaDTO persona) {
		this.persona = persona;
	}
}
