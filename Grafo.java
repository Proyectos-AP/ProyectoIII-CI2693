//package ProyectoAlgo;

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
 * Ultima modificacion: 02/02/2015
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
    //public double[][] Distancias = new double[0][0];
        
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
    
    public void LeerArchivo(String ruta) throws FileNotFoundException, IOException {

        BufferedReader Archivo = new BufferedReader(new FileReader(ruta));
        
        String Linea = Archivo.readLine();
        
        while (Linea != null) {
            
            String[] ArregloLineas = Linea.split(" ");
            
            if (ArregloLineas.length == 1) {                
                int nClusters = Integer.parseInt(ArregloLineas[0]);                
                this.kClusters = nClusters;
            }
            
            else if (ArregloLineas.length == 2) {
               
                double xNodo = Double.parseDouble(ArregloLineas[0]);  
                double yNodo = Double.parseDouble(ArregloLineas[1]);     
                
                Nodo nuevoNodo = new Nodo(xNodo,yNodo);
                
                // No hace falta verificar si el nodo ya fue agregado
                // porque es un HashSet<Nodo>:
                this.AgregarVertice(nuevoNodo);                    
               
            }
            
            Linea = Archivo.readLine();
        
        }
  
    }
    
    public double DistanciaNodos(Nodo z,Nodo w) {
        double resultado;
        resultado = 
                Math.pow(w.abscisa-z.abscisa,2) + 
                Math.pow(w.ordenada-z.ordenada,2);
        return Math.sqrt(resultado);
        
    }
    
    public void AgregarArista(Arista arista) {
        this.aristas.add(arista);
        
    } 
    
    public void CalcularDistancias() {
        
        int numeroV = this.vertices.size();
        
        for (int i = 0; i < numeroV; i++) {
            
            for (int j = i+1; j < numeroV; j++) {              
    
                double Distancias = DistanciaNodos(this.vertices.get(i),this.vertices.get(j));
                Arista arista1 = new Arista( this.vertices.get(i),this.vertices.get(j),Distancias);
                this.AgregarArista(arista1);
                Arista arista2 = new Arista( this.vertices.get(j),this.vertices.get(i),Distancias);
                this.AgregarArista(arista2);
                      
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
            x.adyacencias.add(y);
        }
        else {
            x.padre = y;
             y.adyacencias.add(x);
            if (x.rango == y.rango) {
                y.rango++;
            }
        }
    }
    public Nodo find(Nodo x) {        
        if ( x != x.padre) {
            x.padre = find(x.padre);
        }        
        return x.padre;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public ArrayList<Arista>  mezclar(ArrayList<Arista> ArregloI ,ArrayList<Arista> ArregloD) {
        
        ArrayList<Arista> ArregloMezclado = new ArrayList<Arista>();
        
        while (ArregloI.size() > 0 || ArregloD.size() > 0) {
            
            if (ArregloI.size() > 0 && ArregloD.size() > 0  ) {
                
                if (ArregloI.get(0).peso < ArregloD.get(0).peso) {
                ArregloMezclado.add(ArregloI.get(0));
                ArregloI.remove(0);
                }
            
                else {
                ArregloMezclado.add(ArregloD.get(0));
                ArregloD.remove(0);
                }
                
            }
            
            else if (ArregloI.size() > 0) {
                ArregloMezclado.add(ArregloI.get(0));
                ArregloI.remove(0);
            }
            
            else if (ArregloD.size() > 0) {
                ArregloMezclado.add(ArregloD.get(0));
                ArregloD.remove(0);
            }
               
        }
        
        return ArregloMezclado;
        
        
    }
    
    public ArrayList<Arista> mergeSort(ArrayList<Arista> Arreglo) {
        
        if (Arreglo.size() <= 1) {
            return Arreglo;
        }
        
        ArrayList<Arista> ArregloOrdenado = new ArrayList<Arista>();
        
        ArrayList<Arista> ArregloIzq = new ArrayList<Arista>();
        
        ArrayList<Arista> ArregloDer = new ArrayList<Arista>();
        
        int mitad = Arreglo.size() / 2;
        
        for (int i = 0; i < Arreglo.size(); i++) {
            
            if (i < mitad) {
                ArregloIzq.add(Arreglo.get(i));
            }
            
            else {
                ArregloDer.add(Arreglo.get(i));
                
            }
             
        }
        
        ArregloIzq = mergeSort(ArregloIzq);
        ArregloDer = mergeSort(ArregloDer);
        
        ArregloOrdenado = mezclar(ArregloIzq,ArregloDer);
        
        return ArregloOrdenado;
        
        
        
    }
    

    
    }
    
    
