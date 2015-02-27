package ProyectoAlgo;

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
        
        grafo.LeerArchivo("/home/alejandra/workspace/ProyectoAlgo/src/ProyectoAlgo/puntos1.dat");
        
        System.out.println("PASE LEER ARCHIVO");
        // Se forman los singletones
        for (Nodo p : grafo.ObtenerVertices()) {
            grafo.make_set(p);
        }
        System.out.println("PASE EL MAKE SET");
                
        grafo.CalcularDistancias();
        System.out.println("PASE CALCULAR DISTANCIA");
        
        ArrayList<Arista> AristasOrd = grafo.aristas;
        
        Collections.sort(AristasOrd,new ComparadorDistancias());
        
        System.out.println("ya ordene");
        
       // for (int x=0; x<AristasOrd.size();x++){
       // 	System.out.println(AristasOrd.get(x).peso);
       // 	System.out.println("Aristas :");
       // 	System.out.println(AristasOrd.get(x).u.abscisa + " "+AristasOrd.get(x).u.ordenada);
       // 	System.out.println(AristasOrd.get(x).v.abscisa + " "+AristasOrd.get(x).v.ordenada);
      //}
        System.out.println("ORDENE LAS ARISTAS");
        int C = grafo.vertices.size();
        
        for (Arista a : AristasOrd ) {
            
            if ( C <= grafo.kClusters) {
                break;
            }
            
            if (grafo.find(a.u) != grafo.find(a.v)) {
                grafo.union(a.u,a.v);
                C--;
            }
            
            //System.out.println(a.peso);
            
        }
        
        System.out.println(grafo.kClusters);
        
        //for (Nodo x : grafo.ObtenerVertices()) {
            //if(x.padre==x){
            	//System.out.println("    ");
            	//System.out.println("El pader cluster es :");
            	//System.out.println(x.abscisa+"  "+x.ordenada);
            	//for (Nodo w:x.adyacencias){
                //	System.out.println("El hijo del pader cluster es :");
                //	System.out.println(w.abscisa+"  "+w.ordenada);
            		
            //	}
            	
            	
            	
          //  }
        //}
        
       // Se grafican los puntos
        
       System.out.println("voy a graficar");
        
       String TituloVentana = "Grafico: " + grafo.kClusters + "-clusters"; 
       Grafico scatterplotdemo4 = new Grafico(TituloVentana,grafo.vertices,grafo.kClusters);
       Grafico.crearPuntos(grafo.vertices, grafo.kClusters);
       scatterplotdemo4.pack();
       RefineryUtilities.centerFrameOnScreen(scatterplotdemo4);
       scatterplotdemo4.setVisible(true); 
        
       // Se grafican los clusters
       System.out.println("voy a graficar verdadero grafico");
        
       String TituloVentana2 = "Grafico2: " + grafo.kClusters + "-clusters"; 
       Grafico2 scatterplotdemo2 = new Grafico2(TituloVentana2,grafo.vertices,grafo.kClusters);
       Grafico2.crearPuntos(grafo.vertices, grafo.kClusters);
       scatterplotdemo2.pack();
       RefineryUtilities.centerFrameOnScreen(scatterplotdemo2);
       scatterplotdemo2.setVisible(true);  
                  
            
            
        }

    } 
        