package co.edu.udistrital.controller;

import java.io.Serializable;
import java.util.ArrayList;

import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;

import co.edu.udistrital.model.MotoDTO;
import co.edu.udistrital.model.Tarjeton;
import co.edu.udistrital.model.PersonaDTO;
import co.edu.udistrital.model.Voto;
import co.edu.udistrital.model.ListaVotos;

@Named
@SessionScoped
public class TarjetonController implements Serializable {

    private static final long serialVersionUID = 1L;

    private Tarjeton tarjeton;
    private ArrayList<MotoDTO> listaMotos;

    private String cedulaVotante;         // Cédula del votante
    private MotoDTO motoSeleccionada;      // Tarjetón seleccionado

    private ArrayList<PersonaDTO> listaPersonas; // Lista de personas registradas
    private ListaVotos listaVotos;              // Lista de votos registrados

    @PostConstruct
    public void init() {
        tarjeton = new Tarjeton();
        tarjeton.cargarMotos();
        listaMotos = tarjeton.getMotos();

        listaPersonas = new ArrayList<>();
        listaVotos = new ListaVotos(new ArrayList<>());
    }

    // Getters y setters
    public ArrayList<MotoDTO> getListaMotos() { return listaMotos; }
    public void setListaMotos(ArrayList<MotoDTO> listaMotos) { this.listaMotos = listaMotos; }

    public String getCedulaVotante() { return cedulaVotante; }
    public void setCedulaVotante(String cedulaVotante) { this.cedulaVotante = cedulaVotante; }

    public MotoDTO getMotoSeleccionada() { return motoSeleccionada; }
    public void setMotoSeleccionada(MotoDTO motoSeleccionada) { this.motoSeleccionada = motoSeleccionada; }

    public ArrayList<PersonaDTO> getListaPersonas() { return listaPersonas; }
    public void setListaPersonas(ArrayList<PersonaDTO> listaPersonas) { this.listaPersonas = listaPersonas; }

    public ListaVotos getListaVotos() { return listaVotos; }
    public void setListaVotos(ListaVotos listaVotos) { this.listaVotos = listaVotos; }

    public ArrayList<String> getPaisesDisponibles() {
        ArrayList<String> paises = new ArrayList<>();
        for (MotoDTO moto : listaMotos) {
            if (!paises.contains(moto.getPais())) {
                paises.add(moto.getPais());
            }
        }
        paises.sort(null);
        return paises;
    }

    // Verifica si la cédula ya votó
    public boolean yaVoto() {
        for (Voto v : listaVotos.getListaVotos()) {
            if (v.getPersona().getId().equals(cedulaVotante)) {
                return true;
            }
        }
        return false;
    }

    // Registrar persona si no está registrada
    private PersonaDTO registrarPersona() {
        for (PersonaDTO p : listaPersonas) {
            if (p.getId().equals(cedulaVotante)) {
                return p; // Ya existe
            }
        }
        // Si no existe, crear nueva persona mínima (solo ID)
        PersonaDTO persona = new PersonaDTO();
        persona.setId(cedulaVotante);
        listaPersonas.add(persona);
        return persona;
    }

    // Registrar voto
    public void registrarVoto() {
        if (cedulaVotante == null || cedulaVotante.isEmpty()) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Debe ingresar la cédula."));
            return;
        }

        if (yaVoto()) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Esta cédula ya ha votado."));
            return;
        }

        if (motoSeleccionada == null) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Debe seleccionar un tarjetón."));
            return;
        }

        // Registrar persona (si no existía)
        PersonaDTO persona = registrarPersona();

        // Crear voto y guardarlo
        Voto voto = new Voto();
        voto.setPersona(persona);
        voto.setMotoElegida(motoSeleccionada);
        voto.setNroTarjeton(motoSeleccionada.getTarjeton());

        listaVotos.getListaVotos().add(voto);

        // Mensaje de éxito
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Voto registrado",
                        "Su voto se ha registrado exitosamente para la cédula: " + cedulaVotante));

        // Limpiar campos
        cedulaVotante = null;
        motoSeleccionada = null;
    }
}
