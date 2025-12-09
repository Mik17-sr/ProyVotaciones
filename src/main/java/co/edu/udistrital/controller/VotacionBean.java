package co.edu.udistrital.controller;

import co.edu.udistrital.model.MotoDTO;
import co.edu.udistrital.model.PersonaDTO;
import co.edu.udistrital.model.Voto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import org.primefaces.PrimeFaces;

@Named("votacionBean") 
@SessionScoped
public class VotacionBean implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private PersonaDTO votante;
    private List<MotoDTO> motos;
    
    // CORRECCIÓN: Objeto único para manejar la selección de un solo voto
    private MotoDTO motoSeleccionada; 
    
    private List<Voto> votosRegistrados;
    
    public VotacionBean() {
        this.votante = new PersonaDTO();
        this.motos = new ArrayList<>();
        this.motoSeleccionada = null;
        this.votosRegistrados = new ArrayList<>();
        this.cargarMotos(); 
    }
    
    public void cargarMotos() {
        // CORRECCIÓN CLAVE: Solo se incluye el nombre del archivo. 
        // La carpeta "img" se define en el atributo 'library' de p:graphicImage.
        motos.add(new MotoDTO("Agusta", "Italia", 1, "agusta.png"));
        motos.add(new MotoDTO("Bajaj", "India", 2, "bajaj.png"));
        motos.add(new MotoDTO("BMW", "Alemania", 3, "bmw.png"));
        motos.add(new MotoDTO("CFMoto", "China", 4, "cfmoto.png"));
        motos.add(new MotoDTO("Ducati", "Italia", 5, "ducati.png"));
        motos.add(new MotoDTO("Harley-Davidson", "Estados Unidos", 6, "harleydavidson.png"));
        motos.add(new MotoDTO("Kawasaki", "Japón", 7, "kawasaki.png"));
        motos.add(new MotoDTO("KTM", "Austria", 8, "ktm.png"));
        motos.add(new MotoDTO("Royal Enfield", "India", 9, "royalenfield.png"));
        motos.add(new MotoDTO("Suzuki", "Japón", 10, "suzuki.png"));
        motos.add(new MotoDTO("SYM", "Taiwán", 11, "sym.png"));
        motos.add(new MotoDTO("Triumph", "Reino Unido", 12, "triumph.png"));
        motos.add(new MotoDTO("TVS", "India", 13, "tvs.png"));
        motos.add(new MotoDTO("Voge", "China", 14, "voge.png"));
        motos.add(new MotoDTO("Yamaha", "Japón", 15, "yamaha.png"));
    }

    public void registrarVoto() {
        // Validación del voto único
        if (motoSeleccionada == null) {
             PrimeFaces.current().executeScript("PF('growlWidget').render([{'severity': 'warn', 'summary': 'Error de Votación', 'detail': 'Debe seleccionar una opción de tarjetón.'}]);");
            return;
        }
        
        MotoDTO motoVotada = motoSeleccionada;
        
        // Crear el objeto Voto
        Voto nuevoVoto = new Voto(
            motoVotada.getTarjeton(), 
            motoVotada, 
            this.votante
        );
        
        votosRegistrados.add(nuevoVoto);
        
        // Reiniciar el estado
        this.votante = new PersonaDTO();
        this.motoSeleccionada = null;
        
        PrimeFaces.current().executeScript("PF('growlWidget').render([{'severity': 'info', 'summary': 'Voto Registrado', 'detail': 'Voto por " + motoVotada.getMarca() + " registrado con éxito.'}]);");
    }

    // --- Getters y Setters ---

    public PersonaDTO getVotante() {
        return votante;
    }

    public void setVotante(PersonaDTO votante) {
        this.votante = votante;
    }

    public List<MotoDTO> getMotos() {
        return motos;
    }

    // Getter y Setter para la moto seleccionada (CLAVE para el XHTML)
    public MotoDTO getMotoSeleccionada() {
        return motoSeleccionada;
    }

    public void setMotoSeleccionada(MotoDTO motoSeleccionada) {
        this.motoSeleccionada = motoSeleccionada;
    }
    
    public List<Voto> getVotosRegistrados() {
        return votosRegistrados;
    }

    public void setVotosRegistrados(List<Voto> votosRegistrados) {
        this.votosRegistrados = votosRegistrados;
    }
}