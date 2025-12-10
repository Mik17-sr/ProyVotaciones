package co.edu.udistrital.model;

import java.util.Date;

public class PersonaDTO {
	private String nombres;
	private String apellidos;
	private String id;
	private String telefono;
	private String lugarExpedicion;
	private String sexo;
	private Date fechaNacimiento;
	
	public PersonaDTO() {
		super();
	}
	
	public PersonaDTO(String nombres, String apellidos, String id, String telefono, Date fechaNacimiento,
			String lugarExpedicion, String sexo) {
		super();
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.id = id;
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento;
		this.lugarExpedicion = lugarExpedicion;
		this.sexo = sexo;
	}

	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaExpedicion) {
		this.fechaNacimiento = fechaExpedicion;
	}

	public String getLugarExpedicion() {
		return lugarExpedicion;
	}

	public void setLugarExpedicion(String lugarExpedicion) {
		this.lugarExpedicion = lugarExpedicion;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}	
}
