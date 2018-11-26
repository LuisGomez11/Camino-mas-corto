/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caminos;

/**
 *
 * @author User
 */
public class Caminos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        long matrizA[][] ={{0,3,4,999999999,8,99999999},{999999999,0,99999999,99999999,5,999999999},{999999999,999999999,0,999999999,3,999999999},{999999999,999999999,999999999,0,999999999,999999999},{999999999,999999999,999999999,7,0,3},{999999999,999999999,999999999,2,999999999,0}};
        
        CaminosMinimos cm = new CaminosMinimos();
        System.out.println(cm.algoritmoFloyd(matrizA));
        
    }
    
}
