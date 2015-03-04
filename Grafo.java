/**
 * 
 * Grafo.java
 * 
 * Descripcion: Clase Grafo
 * 
 * Nombres:
 *      Alejandra Cordero  / Carnet: 12-10645
 *      Pablo Maldonado    / Carnet: 12-10561
 * 
 * Ultima modificacion: 04/03/2015
 * 
 */

// Importes:
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Grafo {
    
    // Atributos del grafo:
    public ArrayList<Nodo> vertices;
    public int kClusters;
    public ArrayList<Arista> aristas;
        
    public Grafo() {
        this.vertices = new ArrayList<>();
        this.aristas = new ArrayList<>();
    }
    
    public void AgregarVertice(Nodo vertice) {
        vertices.add(vertice);
    }
    
    public ArrayList<Nodo> ObtenerVertices() {
        return this.vertices;
    }
    
    public void LeerArchivo(String ruta) throws FileNotFoundException, 
            IOException {

        BufferedReader Archivo = new BufferedReader(new FileReader(ruta));
        
        String Linea = Archivo.readLine();
        
        while (Linea != null) {
            
            String[] ArregloLineas = Linea.split(" ");
            
            // Se lee el numero de clusters a generar:            
            if (ArregloLineas.length == 1) {                
                int nClusters = Integer.parseInt(ArregloLineas[0]);                
                this.kClusters = nClusters;
            }
            
            // Se agregan los nodos al grafo:
            else if (ArregloLineas.length == 2) {
               
                double xNodo = Double.parseDouble(ArregloLineas[0]);  
                double yNodo = Double.parseDouble(ArregloLineas[1]);     
                
                Nodo nuevoNodo = new Nodo(xNodo,yNodo);
                // Se verifica que no se agreguen nodos repetidos:
                if (!this.vertices.contains(nuevoNodo)) {
                    this.AgregarVertice(nuevoNodo);       
                }
            }
            
            Linea = Archivo.readLine();
        }
  
    }
    
    public double DistanciaNodos(Nodo z,Nodo w) {
        // Descripcion: Esta funcion calcula la distancia entre dos
        // puntos (Nodos)
        double resultado = (Math.pow(w.abscisa-z.abscisa,2) + 
                Math.pow(w.ordenada-z.ordenada,2));
        return Math.sqrt(resultado);
        
    }
    
    public void AgregarArista(Arista arista) {
        this.aristas.add(arista);
        
    } 
    
    public void CalcularDistancias() {
        // Descripcion: Calcula las distancias entre un punto con todos 
        // los demas y crea las aristas correspondientes.
        int numeroV = this.vertices.size();
        
        for (int i = 0; i < numeroV; i++) {
            
            for (int j = i+1; j < numeroV; j++) {              
    
                double Distancias = 
                        DistanciaNodos(this.vertices.get(i),
                                this.vertices.get(j));
                Arista arista1 = 
                        new Arista( this.vertices.get(i),
                                this.vertices.get(j),Distancias);
                this.AgregarArista(arista1);
                      
                }
               
            }
              
        }
    
    public void make_set(Nodo z) {
        z.padre = z;
        z.rango = 0;    
    }
    
    public void union(Nodo z,Nodo w) {
        link(find(z),find(w));
    }
    
    public void link(Nodo x, Nodo y) {
       
        if (x.rango > y.rango) {
            y.padre = x;
        }
        else {
            x.padre = y;
            if (x.rango == y.rango) {
                y.rango = y.rango + 1;
            }
        }
    }
    
    public Nodo find(Nodo x) {        
        if ( x != x.padre) {
                x.padre = find(x.padre);               
        }
        return x.padre;
    }
  
    }
    
    
