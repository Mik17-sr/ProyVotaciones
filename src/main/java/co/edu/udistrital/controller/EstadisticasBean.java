package co.edu.udistrital.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.bar.BarChartDataSet;
import org.primefaces.model.charts.bar.BarChartModel;

import co.edu.udistrital.model.Voto;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class EstadisticasBean implements Serializable {
    private static final long serialVersionUID = 1L;

    @Inject
    private RegistroPersonaBean registroPersonaBean;

    private BarChartModel barModel;

    public BarChartModel getBarModel() {
        if (barModel == null) {
            crearModelo();
        }
        return barModel;
    }

    private void crearModelo() {

        barModel = new BarChartModel();
        ChartData data = new ChartData();
        BarChartDataSet dataSet = new BarChartDataSet();

        Map<String, Integer> conteo = new HashMap<>();

        for (Voto v : registroPersonaBean.getListaVotos().getListaVotos()) {
            String nombreMoto = v.getMotoElegida().getMarca();
            conteo.put(nombreMoto, conteo.getOrDefault(nombreMoto, 0) + 1);
        }

        dataSet.setLabel("Cantidad de Votos");
        dataSet.setData(conteo.values().stream().map(n -> (Number) n).toList());

        data.setLabels(conteo.keySet().stream().toList());
        data.addChartDataSet(dataSet);

        barModel.setData(data);
    }
}
