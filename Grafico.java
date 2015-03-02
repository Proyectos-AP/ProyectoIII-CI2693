//package ProyectoAlgo;

/**
 * 
 * Grafico.java
 * 
 * Descripcion:
 * 
 * Nombres:
 *      Alejandra Cordero  / Carnet: 12-10645
 *      Pablo Maldonado    / Carnet: 12-10561
 * 
 * Ultima modificacion: 05/03/2015
 * 
 */

// Importes:


import java.awt.Dimension;
import java.util.*;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;

public class Grafico extends ApplicationFrame {
	
    public Grafico(String s,ArrayList<Nodo> vertices) {
  
        super(s);
        JPanel ventana = crearVentana(vertices);
        ventana.setPreferredSize(new Dimension(640, 480));
        add(ventana);
    }

    public static JPanel crearVentana(ArrayList<Nodo> vertices ) {
        JFreeChart jfreechart = ChartFactory.createScatterPlot(
            "Grafico de Clusters", "Abscisas", "Ordenadas", 
            crearPuntos(vertices),
            PlotOrientation.VERTICAL, true, true, false);
        XYPlot xyPlot = (XYPlot) jfreechart.getPlot();
        xyPlot.setDomainCrosshairVisible(true);
        xyPlot.setRangeCrosshairVisible(true);        
        return new ChartPanel(jfreechart);
        
    }
       static XYDataset crearPuntos(ArrayList<Nodo> vertices) {
   
        XYSeriesCollection xySeriesCollection = new XYSeriesCollection();

        int k = 0;
   
        for (int i = 0; i < vertices.size(); i++) {
        			XYSeries series = new XYSeries("Puntos"+k);
                    double x = vertices.get(i).abscisa;
                    double y = vertices.get(i).ordenada;
                    series.add(x, y);  
                    for(Nodo w:vertices.get(i).hijos){
                        double x1 = w.abscisa;
                        double y1 = w.ordenada;
                        series.add(x1, y1); 
                    } 
                    xySeriesCollection.addSeries(series);
                    k++;
                       
        		}     
        return xySeriesCollection;
    }

}