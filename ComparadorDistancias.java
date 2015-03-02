//package ProyectoAlgo;

/**
 * 
 * Nodo.java
 * 
 * Descripcion: Comparador para ordenar las aristas segun su peso
 * 
 * Nombres:
 *      Alejandra Cordero  / Carnet: 12-10645
 *      Pablo Maldonado    / Carnet: 12-10561
 * 
 * Ultima modificacion: 04/03/2015
 * 
 */

// Importes:
import java.util.Comparator;

public class ComparadorDistancias implements Comparator<Arista>{

    @Override
    public int compare(Arista A,Arista B){
        if (A.peso < B.peso){
            return -1;
        }
        if (A.peso > B.peso){
            return 1;
        }
        return 0;
    }
}
    
    