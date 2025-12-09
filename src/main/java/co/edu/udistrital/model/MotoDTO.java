package co.edu.udistrital.model;

import java.io.Serializable;

public class MotoDTO implements Serializable {
    private static final long serialVersionUID = 5997582684165293608L;
    private String marca;
    private String pais;
    private int tarjeton;
    private String urlImg;

    public MotoDTO(String marca, String pais, int tarjeton, String urlImg) {
        super();
        this.marca = marca;
        this.pais = pais;
        this.tarjeton = tarjeton;
        this.urlImg = urlImg;
    }

    public MotoDTO() {
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getTarjeton() {
        return tarjeton;
    }

    public void setTarjeton(int tarjeton) {
        this.tarjeton = tarjeton;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

	public String getUrlImg() {
		return urlImg;
	}

	public void setUrlImg(String urlImg) {
		this.urlImg = urlImg;
	}

    
}
