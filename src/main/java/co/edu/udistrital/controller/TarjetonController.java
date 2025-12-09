package co.edu.udistrital.controller;

import java.io.Serializable;
import java.util.ArrayList;

import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.annotation.PostConstruct;

import co.edu.udistrital.model.MotoDTO;
import co.edu.udistrital.model.Tarjeton;

@Named
@SessionScoped
public class TarjetonController implements Serializable {
    
    private static final long serialVersionUID = 1L;
    

    private Tarjeton tarjeton; 

    private ArrayList<MotoDTO> listaMotos; 

    @PostConstruct
    public void init() {
        tarjeton = new Tarjeton();
        tarjeton.cargarMotos(); 
        listaMotos = tarjeton.getMotos(); 
    }


    public TarjetonController() {
    }

    public ArrayList<MotoDTO> getListaMotos() {
        return listaMotos;
    }

    public void setListaMotos(ArrayList<MotoDTO> listaMotos) {
        this.listaMotos = listaMotos;
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
}