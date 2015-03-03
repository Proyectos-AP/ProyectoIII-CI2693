/**
 * 
 * Grafico.java
 * 
 * Descripcion: Clase Grafico que permite graficar un conjunto de puntos
 * dados
 * 
 * Nombres:
 *      Alejandra Cordero  / Carnet: 12-10645
 *      Pablo Maldonado    / Carnet: 12-10561
 * 
 * Ultima modificacion: 04/03/2015
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
	
    public Grafico(String s,ArrayList<Nodo> arregloPadres,int kClusters) {  
        super(s);
        JPanel ventana = crearVentana(arregloPadres,kClusters);
        // Se define el tamano se la ventana:
        ventana.setPreferredSize(new Dimension(640, 480));
        add(ventana);
    }

    public static JPanel crearVentana(ArrayList<Nodo> vertices,int kClusters ) {
        // Se crea una grafica de puntos (ScatterPlot):
        JFreeChart jfreechart = ChartFactory.createScatterPlot(
            "K = "+ kClusters, "Abscisas", "Ordenadas", 
            crearPuntos(vertices),
            PlotOrientation.VERTICAL, true, true, false);
        
        return new ChartPanel(jfreechart);
        
    }
    
    public static XYDataset crearPuntos(ArrayList<Nodo> arregloPadres) {
        // Descripcion: Se crea el conjunto de puntos a graficar.
        
        // Se inicializa la coleccion de puntos:
        XYSeriesCollection coleccionPuntos = new XYSeriesCollection();

        int k = 0;
   
        for (int i = 0; i < arregloPadres.size(); i++) {
            // Para cada cluster en el arreglo de padres,
            // se crea un conjunto de puntos (XYSeries) y se
            // agregan a coleccionPuntos:
            XYSeries clusterGrafico = new XYSeries("Cluster "+k);
            double x = arregloPadres.get(i).abscisa;
            double y = arregloPadres.get(i).ordenada;
            clusterGrafico.add(x, y);  
            for (Nodo w : arregloPadres.get(i).hijos) {
                double x1 = w.abscisa;
                double y1 = w.ordenada;
                clusterGrafico.add(x1,y1); 
            } 
            coleccionPuntos.addSeries(clusterGrafico);
            // Se pasa al siguiente elemento del arreglo de padres:
            k++;
                       
        }     
        return coleccionPuntos;
    }

}
