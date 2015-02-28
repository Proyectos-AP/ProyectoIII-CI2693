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
        
        grafo.LeerArchivo("/home/prmm95/NetBeansProjects/Proyecto2-CI2693/src/data/puntos32.dat");
        
        System.out.println("PASE LEER ARCHIVO");
        
        // Se empieza a tomar el tiempo:
        long tiempoIni = System.currentTimeMillis();
        
        // Se forman los singletones
        for (Nodo p : grafo.ObtenerVertices()) {
            grafo.make_set(p);
        }
        System.out.println("PASE EL MAKE SET");
                
        grafo.CalcularDistancias();
        System.out.println("PASE CALCULAR DISTANCIA");
        
        Collections.sort(grafo.aristas,new ComparadorDistancias());
        
        //Boolean ordenado = true;
        //for (int i = 0; i < grafo.aristas.size() - 1; i++) {
            
        //    if ( grafo.aristas.get(i).peso > grafo.aristas.get(i + 1).peso ) {
        //       ordenado = false;
        //       break;
        //    }
        //    
        //    else {
        //        continue;
        //    }
        //}
        
        //System.out.println(ordenado);
        
        
        
        System.out.println("ya ordene");
        
        /*        for (int x=0; x<grafo.aristas.size();x++){
        System.out.println(grafo.aristas.get(x).peso);
        System.out.println("Aristas :");
        System.out.println(grafo.aristas.get(x).u.abscisa + " "+grafo.aristas.get(x).u.ordenada);
        System.out.println(grafo.aristas.get(x).v.abscisa + " "+grafo.aristas.get(x).v.ordenada);
        }*/
                        
        
        System.out.println("ORDENE LAS ARISTAS");
        int C = grafo.vertices.size();
        
        for (Arista a : grafo.aristas) {
            //System.out.println("Numero de clusters " + C );
            if ( C <= grafo.kClusters) {
                break;
            }
            
            if (grafo.find(a.u) != grafo.find(a.v)) {
                grafo.union(a.u,a.v);
                C = C - 1;
            }
            
            //System.out.println(a.peso);
            
        }
        
        // Se termina de tomar el tiempo:
        
        long tiempoFin = System.currentTimeMillis();
        
        long tiempoCorrida = tiempoFin - tiempoIni;
        
        System.out.println(grafo.kClusters);
        
        ArrayList<Nodo> ArregloPadres = new ArrayList<>();
        
        // Primero se encuentran los padres: 
        
        for (Nodo x : grafo.ObtenerVertices()) {
            if (x.padre == x) {
                ArregloPadres.add(x);
            }
        }
        
        //System.out.println("numero de clusters " + ArregloPadres.size());
        
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
        
        
        
        //for (Nodo x : grafo.ObtenerVertices()) {
        //    if(x.padre==x){
        //    System.out.println("    ");
        //    System.out.println("aqui empieza un cluster:");
        //    System.out.println(x.abscisa+"  "+x.ordenada);
        //    for (Nodo w:x.hijos){
        //        System.out.println("El hijo del pader cluster es :");
        //        System.out.println(w.abscisa+"  "+w.ordenada);
               
        //     }
        //  }
        // }
        
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
                  
       
       // Se imprime por consola el tiempo tomado por el algoritmo
       // y el numero de puntos procesados
        System.out.println(tiempoCorrida + " " + grafo.vertices.size());
            
        }

   
    } 
        