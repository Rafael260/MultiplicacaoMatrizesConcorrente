/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multimatrizconc;

import calculadora_matrizes.CalculadoraMatrizes;
import dominio.Matriz;
import entrada_saida.LeitorEscritor;
import java.io.IOException;

/**
 *
 * @author Rafael
 */
public class MultiMatrizConc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        int qtdeExecucoes = 25;
        LeitorEscritor leitorEscritor = new LeitorEscritor();
        CalculadoraMatrizes calculadora = new CalculadoraMatrizes();
        
        
        Matriz matrizA = leitorEscritor.getMatrizEntrada(args[0]);
        Matriz matrizB = leitorEscritor.getMatrizEntrada(args[1]);
        
        Integer numeroThreads;
        Integer dimensao = matrizA.getDimensao();
        switch (args[2]) {
            case "-m":
                numeroThreads = dimensao / 2;
                break;
            case "-M":
                numeroThreads = dimensao;
                break;
            default:
                numeroThreads = Integer.parseInt(args[2]);
                break;
        }
        if (dimensao < numeroThreads){
            numeroThreads = dimensao;
        }
        else if (numeroThreads < 2){
            numeroThreads = 2;
        }
        
        long tempoInicial = System.currentTimeMillis();
        Matriz resultante = null;
        System.out.println("Número de threads: "+ numeroThreads);
        for (int i = 0; i < qtdeExecucoes; i++){
            System.out.println("Calculando pela "+(i+1) +"ª vez");
            resultante = calculadora.getProduto(matrizA, matrizB, numeroThreads);
        }
        long tempoFinal = System.currentTimeMillis();
        int diferenca = (int) (tempoFinal-tempoInicial);
        double mediaExecucao = ((double) diferenca)/(qtdeExecucoes);
        System.out.println("Resultado calculado e armazenado. Tempo de processamento: "+ mediaExecucao + " mili segundos");
        leitorEscritor.armazenarMatrizResultante(resultante);
    }
    
}
