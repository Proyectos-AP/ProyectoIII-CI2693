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


public class Main {
    

    public static void main(String[] args) throws IOException {
        
        Grafo grafo = new Grafo();
        
        grafo.LeerArchivo("/home/alejandra/workspace/ProyectoAlgo/src/ProyectoAlgo/prueba.dat");
        

        // Se forman los singletones
        for (Nodo p : grafo.ObtenerVertices()) {
            grafo.make_set(p);
        }
                
        grafo.CalcularDistancias();
        
        ArrayList<Arista> AristasOrd = grafo.mergeSort(grafo.aristas);
        
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
        
        for (Nodo x : grafo.ObtenerVertices()) {
            if(x.padre==x){
            	System.out.println("    ");
            	System.out.println("El pader cluster es :");
            	System.out.println(x.abscisa+"  "+x.ordenada);
            	for (Nodo w:x.adyacencias){
                	System.out.println("El hijo del pader cluster es :");
                	System.out.println(w.abscisa+"  "+w.ordenada);
            		
            	}
            	
            	
            	
            }
            
            
        }

    }         
  
}
