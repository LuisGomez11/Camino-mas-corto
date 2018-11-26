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
public class CaminosMinimos {
    
    public String algoritmoFloyd(long [][] mAdy){
        int  vertices = mAdy.length;
        long matrizAdyacencia [][] = mAdy;
        String caminos[][] = new String[vertices][vertices];
        String caminosAuxiliares[][] = new String[vertices][vertices];
        String caminosRecorrido="",cadena="",caminitos="";
        int i, j, k;
        float temporal1, temporal2, temporal3, temporal4, minimo;
        
        for(i=0;i<vertices;i++){
            for(j=0;j<vertices;j++){
                caminos[i][j] ="";
                caminosAuxiliares[i][j] ="";
            }
        }
        for(k=0;k<vertices;k++){
            for(i=0;i<vertices;i++){
                for(j=0;j<vertices;j++){
                    temporal1=matrizAdyacencia[i][j];
                    temporal2=matrizAdyacencia[i][k];
                    temporal3=matrizAdyacencia[k][j];
                    temporal4=temporal2+temporal3;
                    //Econtrando al Minimo
                    minimo=Math.min(temporal1, temporal4);
                    if(temporal1!=temporal4){
                        if(minimo==temporal4){
                            caminosRecorrido="";
                            caminosAuxiliares[i][j] = k +"";
                            caminos[i][j]=caminosR(i, k, caminosAuxiliares, caminosRecorrido) + (k+1);
                            
                        }
                    }
                    matrizAdyacencia[i][j] = (long) minimo;
                }
            }
        }
        //Agregando el camino minimo a cadena
        
        for(i=0;i<vertices;i++){
            for(j=0;j<vertices;j++){
                cadena = cadena + "["+matrizAdyacencia[i][j]+"]";
            }
            cadena=cadena+"\n";
        }
        
        ////////////////////////////////////////////////////////////
        
        for(i=0;i<vertices;i++){
            for(j=0;j<vertices;j++){
                if(matrizAdyacencia[i][j]!=1000000000){
                    if(i != j){
                        if(caminos[i][j].equals("")){
                            caminitos += "De ("+(i+1)+"---->"+(j+1)+") Irse por ... ("+(i+1)+", "+(j+1)+")\n";
                        }else {
                            caminitos += "De ("+(i+1)+"---->"+(j+1)+") Irse por ... ("+(i+1)+", "+caminos[i][j]+", "+(j+1)+")\n";
                        }
                    }
                }
            } 
        }
        return "La matriz de caminos mas cortos entre los diferentes vertices es: \n"+cadena+
                "\nLos diferentes caminos mas cortos entre vertices son:\n"+caminitos;
        
    }
    
    public String caminosR (int i, int k, String[][] caminosAux, String caminoRecorrido ){
        
        if(caminosAux[i][k].equals("")){
            return "";
        } else {
            //Recursividad
            caminoRecorrido += caminosR(i, Integer.parseInt(caminosAux[i][k]), caminosAux, caminoRecorrido)+
                    (Integer.parseInt(caminosAux[i][k])+1)+", ";
            return caminoRecorrido;
        }

    }
    
}
