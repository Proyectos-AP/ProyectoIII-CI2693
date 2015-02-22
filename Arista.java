/**
 * 
 * Arista.java
 * 
 * Descripcion: Clase Arista
 * 
 * Nombres:
 *      Alejandra Cordero  / Carnet: 12-10645
 *      Pablo Maldonado    / Carnet: 12-10561
 * 
 * Ultima modificacion: 02/02/2015
 * 
 */

public class Arista {
    // Atributos de una arista:
    public Nodo u;
    public Nodo v;
    public double peso;
    
    public Arista(Nodo nodo1, Nodo nodo2, double weight) {
        this.u = nodo1;
        this.v = nodo2;
        this.peso = weight;
        
    }
    
    
    
}
