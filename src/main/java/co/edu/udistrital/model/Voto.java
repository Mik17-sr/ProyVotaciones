package co.edu.udistrital.model;

import java.io.Serializable;
import java.util.Date;

public class Voto implements Serializable {
	private static final long serialVersionUID = 7891124043315755756L;
	private int nroTarjeton;
	private MotoDTO motoElegida;
	private PersonaDTO persona;
	private Date fechaVoto;

	public Voto() {
		super();
	}
	
	
	
	public Voto(int nroTarjeton, MotoDTO motoElegida, PersonaDTO persona, Date fechaVoto) {
		super();
		this.nroTarjeton = nroTarjeton;
		this.motoElegida = motoElegida;
		this.persona = persona;
		this.fechaVoto = fechaVoto;
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

	public Date getFechaVoto() {
		return fechaVoto;
	}

	public void setFechaVoto(Date fechaVoto) {
		this.fechaVoto = fechaVoto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
