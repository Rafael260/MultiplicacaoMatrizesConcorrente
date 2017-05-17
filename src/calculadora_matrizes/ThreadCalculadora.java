/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora_matrizes;

import dominio.Matriz;

/**
 *
 * @author Rafael
 */
public class ThreadCalculadora extends Thread{
    private Matriz matriz1;
    private Matriz matriz2;
    private Matriz resultante;
    private int linhaInicial;
    private int linhaFinal;
    private String nome;
    
    public ThreadCalculadora(Matriz matriz1, Matriz matriz2, Matriz resultante, int linhaInicial, int linhaFinal, String nome) {
        super(nome);
        this.nome = nome;
        this.matriz1 = matriz1;
        this.matriz2 = matriz2;
        this.resultante = resultante;
        this.linhaInicial = linhaInicial;
        this.linhaFinal = linhaFinal;
    }
    
    @Override
    public void run(){
//        System.out.println("Rodando "+ nome +". Linha inicial: "+ linhaInicial + ". Linha final: "+linhaFinal+".");
        int dimensao = matriz1.getDimensao();
        for (int i = linhaInicial; i <= linhaFinal; i++){
            for (int j = 0; j < dimensao; j++){
                resultante.atribuirValor(i, j, CalculadoraMatrizes.getValorProduto(matriz1, matriz2, i, j));
            }
        }
//        System.out.println("Finalizando "+ nome);
    }
}
