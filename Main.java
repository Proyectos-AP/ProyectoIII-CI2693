//package ProyectoAlgo;

/**
 * 
 * Main.java
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
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import org.jfree.ui.RefineryUtilities;


public class Main {
    

    public static void main(String[] args) throws IOException {
        
        Grafo grafo = new Grafo();
        
        grafo.LeerArchivo(args[1]);
        System.out.println("Argumento 1 : "+args[1]);
        System.out.println("PASE LEER ARCHIVO");
        
        // Se empieza a tomar el tiempo:
        long tiempoIni = System.currentTimeMillis();
        
        // Se forman los singletones
        for (Nodo p : grafo.ObtenerVertices()) {
            grafo.make_set(p);
        }
        System.out.println("PASE EL MAKE SET");
        
        //Se calculan las distancias entre todos los puntos:        
        grafo.CalcularDistancias();
        System.out.println("PASE CALCULAR DISTANCIA");
        
        // Se ordenan las aristas 
        Collections.sort(grafo.aristas,new ComparadorDistancias());      
        System.out.println("ya ordene");                  
        
        System.out.println("ORDENE LAS ARISTAS");
        int C = grafo.vertices.size();
        
        // Se aplica el algoritmos de Kruscal
        for (Arista a : grafo.aristas) {
     
            if ( C <= grafo.kClusters) {
                break;
            }
            
            if (grafo.find(a.u) != grafo.find(a.v)) {
                grafo.union(a.u,a.v);
                C = C - 1;
            }  
        }
        
        // Se termina de tomar el tiempo:
        
        long tiempoFin = System.currentTimeMillis();
        
        long tiempoCorrida = tiempoFin - tiempoIni;
        
        System.out.println(grafo.kClusters);
        
        ArrayList<Nodo> ArregloPadres = new ArrayList<>();
        
        // Primero se encuentran los padres de cada cluster: 
        
        for (Nodo x : grafo.ObtenerVertices()) {
            if (x.padre == x) {
                ArregloPadres.add(x);
            }
        }
        
   
        
        // Se asigna cada nodo a su padre correspondiente:
        
        for (Nodo x : grafo.ObtenerVertices()) {
            if (x.padre != x) {
                Nodo padre = grafo.find(x);
                //System.out.println(padre.abscisa + " hijo " + x.abscisa);
                for (int i = 0; i < ArregloPadres.size(); i++) {
                   if (padre == ArregloPadres.get(i)) {
                        ArregloPadres.get(i).hijos.add(x);
                    }
                }
  
           }
        }
        
 
       // Se grafican los clusters
        
       if(args[0].equals("1")){
    	   System.out.println("voy a graficar");
        
    	   String TituloVentana = "Grafico: " + grafo.kClusters + "-clusters"; 
    	   Grafico scatterplotdemo4 = new Grafico(TituloVentana,ArregloPadres,grafo.kClusters);
    	   scatterplotdemo4.pack();
    	   RefineryUtilities.centerFrameOnScreen(scatterplotdemo4);
    	   scatterplotdemo4.setVisible(true); 
        
    	   // Se grafican los puntos
    	   System.out.println("voy a graficar verdadero grafico");
        
    	   String TituloVentana2 = "Grafico2: " + grafo.kClusters + "-clusters"; 
    	   Grafico2 scatterplotdemo2 = new Grafico2(TituloVentana2,grafo.vertices);
    	   scatterplotdemo2.pack();
    	   RefineryUtilities.centerFrameOnScreen(scatterplotdemo2);
    	   scatterplotdemo2.setVisible(true);  
       			}        
            
           
	 System.out.println(tiempoCorrida+" "+grafo.vertices.size()); 
        }

   
    } 
        