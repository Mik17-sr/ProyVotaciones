package co.edu.udistrital.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.bar.BarChartDataSet;
import org.primefaces.model.charts.bar.BarChartModel;
import org.primefaces.model.charts.pie.PieChartDataSet;
import org.primefaces.model.charts.pie.PieChartModel;

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
    private PieChartModel pieModel;

    public BarChartModel getBarModel() {
        if (barModel == null) {
            crearModelo();
        }
        return barModel;
    }
    
    public PieChartModel getPieModel() {
        if (pieModel == null) {
            crearPieModel();
        }
        return pieModel;
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
    
    private void crearPieModel() {
        pieModel = new PieChartModel();
        ChartData data = new ChartData();
        PieChartDataSet dataSet = new PieChartDataSet();

        Map<String, Integer> conteo = new HashMap<>();
        int total = 0;

        for (Voto v : registroPersonaBean.getListaVotos().getListaVotos()) {
            String nombreMoto = v.getMotoElegida().getMarca();
            conteo.put(nombreMoto, conteo.getOrDefault(nombreMoto, 0) + 1);
            total++;
        }

        ArrayList<Number> valores = new ArrayList<>();
        ArrayList<String> etiquetas = new ArrayList<>();

        for (String marca : conteo.keySet()) {

            int cantidad = conteo.get(marca);

            double porcentaje = (total == 0)
                    ? 0
                    : (cantidad * 100.0) / total;

            etiquetas.add(marca + " (" + String.format("%.1f", porcentaje) + "%)");
            valores.add(cantidad);
        }

        dataSet.setData(valores);

        dataSet.setBackgroundColor(
            Arrays.asList("#FF6384", "#36A2EB", "#FFCE56", "#4BC0C0")
        );

        data.addChartDataSet(dataSet);
        data.setLabels(etiquetas);

        pieModel.setData(data);
    }

}
