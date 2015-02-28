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
	
	int nClusters;

    public Grafico(String s,ArrayList<Nodo> vertices,int NumeroKclusters) {
    	//this.nClusters=NumeroKclusters;
        super(s);
        JPanel ventana = crearVentana(vertices,NumeroKclusters);
        ventana.setPreferredSize(new Dimension(640, 480));
        add(ventana);
    }

    public static JPanel crearVentana(ArrayList<Nodo> vertices,int NumeroKclusters ) {
        JFreeChart jfreechart = ChartFactory.createScatterPlot(
            "Grafico de Clusters", "Abscisas", "Ordenadas", 
            crearPuntos(vertices,NumeroKclusters),
            PlotOrientation.VERTICAL, true, true, false);
        Shape cross = ShapeUtilities.createDiagonalCross(3, 1);
        XYPlot xyPlot = (XYPlot) jfreechart.getPlot();
        xyPlot.setDomainCrosshairVisible(true);
        xyPlot.setRangeCrosshairVisible(true);
        XYItemRenderer renderer = xyPlot.getRenderer();
        
        //renderer.setSeriesShape(0, cross);
        //renderer.setSeriesPaint(0, Color.orange);          
                
        return new ChartPanel(jfreechart);
    }
    
    	public static void DFS (Nodo n,XYSeries s){
    		n.color="Gris";
    		for(Nodo w:n.hijos){
    			if (w.color.equals("Blanco")){
    				s.add(w.abscisa,w.ordenada);
    				DFS(w,s);
    				
    			}
    		}
    		n.color="Negro";
    	}
    
       static XYDataset crearPuntos(ArrayList<Nodo> vertices,int NumeroKclusters) {
        //int cols = vertices.size();
        //int rows = vertices.size();
        //double[] values = new double[cols];
        XYSeriesCollection xySeriesCollection = new XYSeriesCollection();
        //XYSeries series = new XYSeries("Puntos");
       // XYSeries[] series = null;
        
        //for(int i=0;i<NumeroKclusters;i++){
        	
        	 // series[i]=new XYSeries("Puntos");	
        //}
        
        int k = 0;
        //Random rand = new Random();
        for (int i = 0; i < vertices.size(); i++) {
        		if(vertices.get(i).padre==vertices.get(i)){
        			XYSeries series = new XYSeries("Puntos"+k);
                    double x = vertices.get(i).abscisa;
                    double y = vertices.get(i).ordenada;
                    series.add(x, y);  
                    DFS(vertices.get(i),series);
                    //for(Nodo w:vertices.get(i).adyacencias){
                    //   double x1 = w.abscisa;
                    //    double y1 = w.ordenada;
                    //    series.add(x1, y1); 
                    //} 
                    xySeriesCollection.addSeries(series);
                    k++;
                    }   
        		}
        	
               // double x = vertices.get(i).abscisa;
                //double y = vertices.get(i).ordenada;
                //series.add(x, y);  
        //}
    	//series2.add(1.0, 1.0);
		//xySeriesCollection.addSeries(series2);
       
        return xySeriesCollection;
    }

}