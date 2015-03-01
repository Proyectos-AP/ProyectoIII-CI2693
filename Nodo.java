//package ProyectoAlgo;

/**
 * 
 * Nodo.java
 * 
 * Descripcion: Clase Nodo
 * 
 * Nombres:
 *      Alejandra Cordero  / Carnet: 12-10645
 *      Pablo Maldonado    / Carnet: 12-10561
 * 
 * Ultima modificacion: 04/03/2015
 * 
 */

// Importes:
import java.util.HashSet;

public class Nodo {
    
    // Atributos de un Nodo: 
    public float abscisa;
    public float ordenada;
    public Nodo  padre;
    public int   rango;
    public int   GrupoCluster;
    public HashSet<Nodo> hijos;
    public String color;
    
    public Nodo(float x, float y) {
        this.abscisa = x;
        this.ordenada = y;
        this.hijos = new HashSet<>();
        this.padre = null;
        this.rango = 0;
        this.GrupoCluster=-1;
        this.color = "Blanco";       
    }
    
}
