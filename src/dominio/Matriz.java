/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

/**
 *
 * @author Rafael
 */
public class Matriz {
    private int[][] matriz;
    private int dimensao;
    
    public Matriz(int dimensao){
        this.dimensao = dimensao;
        matriz = new int[this.dimensao][this.dimensao];
    }
    
    public int getDimensao(){
        return this.dimensao;
    }
    
    public int getValor(int linha, int coluna){
        return matriz[linha][coluna];
    }
    
    public void atribuirValor(int linha, int coluna, int valor){
        matriz[linha][coluna] = valor;
    }
    
    public void imprimir(){
        for (int i = 0; i < dimensao; i++){
            for (int j = 0; j < dimensao; j++){
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}
