/**
 * 
 * Main.java
 * 
 * Descripcion: Dado un parametro k, se calculan los k-clusters de un conjunto 
 * de puntos dados utilizando el algoritmo de Kruskal
 * 
 * Nombres:
 *      Alejandra Cordero  / Carnet: 12-10645
 *      Pablo Maldonado    / Carnet: 12-10561
 * 
 * Ultima modificacion: 04/03/2015
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
        // args[1] es el parametro recibido por agrupar
        grafo.LeerArchivo(args[1]); 
        
        
        //Se calculan las distancias entre todos los puntos:        
        grafo.CalcularDistancias();
        
        // Se empieza a tomar el tiempo:
        long tiempoIni = System.currentTimeMillis();
        
        // Se forman los singletones
        for (Nodo p : grafo.ObtenerVertices()) {
            grafo.make_set(p);
        }
                
        // Se ordenan las aristas usando el comparator implementado en
        // ComparadorDistancias.java
        Collections.sort(grafo.aristas,new ComparadorDistancias());                      
        
        // Se inicializa el numero de k-clusters como el numero de vertices:
        int C = grafo.vertices.size();
        
        // Se aplica el algoritmo de Kruskal
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
      
        // Dependiendo del argumento recibido en agrupar se genera una grafica
        // con los k-clusters:   
        
        
        if(args[0].equals("1")) {
            
            // Se inicializa el arreglo que contendra los padres (raices) de 
            // cada cluster:
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
                    for (int i = 0; i < ArregloPadres.size(); i++) {
                        if (padre == ArregloPadres.get(i)) {
                            ArregloPadres.get(i).hijos.add(x);
                        }
                    }
  
                }
            }        
                  
            // Se crea la grafica de los k-clusters:
    	    String TituloVentana = 
                    "Grafico: " + grafo.kClusters + "-clusters"; 
            // Se crea una variabe de tipo Grafico:
    	    Grafico graficakClusters = 
                    new Grafico(TituloVentana,ArregloPadres,grafo.kClusters);
            // Se centra la grafica y se establece visible:
    	    graficakClusters.pack();
    	    RefineryUtilities.centerFrameOnScreen(graficakClusters);
    	    graficakClusters.setVisible(true); 
        
       	}        
            
        // Se imprimen el tiempo de ejecucion del algoritmo de Kruskal
        // y el numero de puntos procesados:
	System.out.println(tiempoCorrida + " " + grafo.vertices.size()); 
        
        }

   
    } 
        