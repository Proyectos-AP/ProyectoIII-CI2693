//package ProyectoAlgo;


import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 *
 */
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
    
    