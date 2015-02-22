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
 * Ultima modificacion: 02/02/2015
 * 
 */

// Importes:

public class Nodo {
    
    // Atributos de un Nodo: 
    public double abscisa;
    public double ordenada;
    public Nodo  padre;
    public int   rango;
    
    public Nodo(double x, double y) {
        this.abscisa = x;
        this.ordenada = y;
        this.padre = null;
        this.rango = 0;
           
    }
    
        
}
