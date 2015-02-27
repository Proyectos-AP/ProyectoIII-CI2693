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
 * Ultima modificacion: 02/02/2015
 * 
 */

// Importes:

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Shape;
import java.util.*;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.util.ShapeUtilities;

public class Grafico extends ApplicationFrame {

    public Grafico(String s,ArrayList<Nodo> vertices) {
        super(s);
        JPanel ventana = crearVentana(vertices);
        ventana.setPreferredSize(new Dimension(640, 480));
        add(ventana);
    }

    public static JPanel crearVentana(ArrayList<Nodo> vertices) {
        JFreeChart jfreechart = ChartFactory.createScatterPlot(
            "Grafico de Clusters", "Abscisas", "Ordenadas", 
                crearPuntos(vertices),
            PlotOrientation.VERTICAL, true, true, false);
        Shape cross = ShapeUtilities.createDiagonalCross(3, 1);
        XYPlot xyPlot = (XYPlot) jfreechart.getPlot();
        xyPlot.setDomainCrosshairVisible(true);
        xyPlot.setRangeCrosshairVisible(true);
        XYItemRenderer renderer = xyPlot.getRenderer();
        
        renderer.setSeriesShape(0, cross);
        renderer.setSeriesPaint(0, Color.orange);          
                
        return new ChartPanel(jfreechart);
    }
    
      private static XYDataset crearPuntos(ArrayList<Nodo> vertices) {
        //int cols = vertices.size();
        //int rows = vertices.size();
        //double[] values = new double[cols];
        XYSeriesCollection xySeriesCollection = new XYSeriesCollection();
        XYSeries series = new XYSeries("Puntos");
        //Random rand = new Random();
        for (int i = 0; i < vertices.size(); i++) {
                double x = vertices.get(i).abscisa;
                double y = vertices.get(i).ordenada;
                series.add(x, y);  
        }
        xySeriesCollection.addSeries(series);
        return xySeriesCollection;
    }

}
