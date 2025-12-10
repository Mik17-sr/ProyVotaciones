package co.edu.udistrital.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;

import co.edu.udistrital.model.MotoDTO;
import co.edu.udistrital.model.Tarjeton;
import co.edu.udistrital.model.PersonaDTO;
import co.edu.udistrital.model.Voto;
import co.edu.udistrital.model.ListaVotos;

@Named
@SessionScoped
public class TarjetonController implements Serializable {
	private static final long serialVersionUID = 3012172844893472191L;

	@Inject
    private RegistroPersonaBean registroPersonaBean;

    private Tarjeton tarjeton;
    private ArrayList<MotoDTO> listaMotos;
    private Integer tarjetonSeleccionado;
    private String cedulaVotante;
    private boolean mostrarTarjetones = false;
    private PersonaDTO personaActual;
    private ListaVotos listaVotos;

    public TarjetonController() {
        tarjeton = new Tarjeton();
        tarjeton.cargarMotos();
        listaMotos = tarjeton.getMotos();
        listaVotos = new ListaVotos(new ArrayList<>());
        tarjetonSeleccionado = null;
    }

    public void validarCedula() {

        personaActual = null;
        for (PersonaDTO p : registroPersonaBean.getListaPersonas()) {
            if (p.getId().equals(cedulaVotante)) {
                personaActual = p;
                break;
            }
        }

        if (personaActual == null) {
            mostrarMensaje("Error", "Cédula no registrada", FacesMessage.SEVERITY_ERROR);
            mostrarTarjetones = false;
            return;
        }

        if (registroPersonaBean.haVotado(personaActual)) {
            mostrarMensaje("Error", "La persona ya votó", FacesMessage.SEVERITY_ERROR);
            mostrarTarjetones = false;
            return;
        }

        mostrarTarjetones = true;
        mostrarMensaje("Bienvenido", "Hola " + personaActual.getNombres(), FacesMessage.SEVERITY_INFO);
    }

    public void seleccionarTarjeton(Integer tarjeton) {
        tarjetonSeleccionado = tarjeton;
    }

    public void registrarVoto() {
        if (tarjetonSeleccionado == null) {
            mostrarMensaje("Error", "Debe seleccionar una moto", FacesMessage.SEVERITY_ERROR);
            return;
        }

        MotoDTO motoSeleccionada = null;
        for (MotoDTO m : listaMotos) {
            if (m.getTarjeton() == tarjetonSeleccionado) {
                motoSeleccionada = m;
                break;
            }
        }

        if (personaActual == null) {
            mostrarMensaje("Error", "Debe validar la cédula", FacesMessage.SEVERITY_ERROR);
            return;
        }
        
        Voto voto = new Voto(tarjetonSeleccionado, motoSeleccionada, personaActual, new Date());
        registroPersonaBean.getListaVotos().getListaVotos().add(voto);

        mostrarMensaje("Éxito", "Voto registrado correctamente por " + personaActual.getNombres(),
                FacesMessage.SEVERITY_INFO);

        cedulaVotante = null;
        personaActual = null;
        tarjetonSeleccionado = null;
        mostrarTarjetones = false;
    }
    
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

    private void mostrarMensaje(String titulo, String mensaje, FacesMessage.Severity tipo) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(tipo, titulo, mensaje));
    }

    public Tarjeton getTarjeton() {
        return tarjeton;
    }

    public void setTarjeton(Tarjeton tarjeton) {
        this.tarjeton = tarjeton;
    }

    public ArrayList<MotoDTO> getListaMotos() {
        return listaMotos;
    }

    public void setListaMotos(ArrayList<MotoDTO> listaMotos) {
        this.listaMotos = listaMotos;
    }

    public String getCedulaVotante() {
        return cedulaVotante;
    }

    public void setCedulaVotante(String cedulaVotante) {
        this.cedulaVotante = cedulaVotante;
    }

    public Integer getTarjetonSeleccionado() {
        return tarjetonSeleccionado;
    }

    public void setTarjetonSeleccionado(Integer tarjetonSeleccionado) {
        this.tarjetonSeleccionado = tarjetonSeleccionado;
    }

    public boolean isMostrarTarjetones() {
        return mostrarTarjetones;
    }

    public void setMostrarTarjetones(boolean mostrarTarjetones) {
        this.mostrarTarjetones = mostrarTarjetones;
    }

    public ListaVotos getListaVotos() {
        return listaVotos;
    }

    public void setListaVotos(ListaVotos listaVotos) {
        this.listaVotos = listaVotos;
    }

    public PersonaDTO getPersonaActual() {
        return personaActual;
    }

    public void setPersonaActual(PersonaDTO personaActual) {
        this.personaActual = personaActual;
    }
}

