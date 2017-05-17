/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora_matrizes;

import dominio.Matriz;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rafael
 */
public class CalculadoraMatrizes {
    public Matriz getProduto(Matriz matriz1, Matriz matriz2, int numThreads){
        int dimensao = matriz1.getDimensao();
        //Crio a instancia da matriz resultante
        Matriz resultante = new Matriz(dimensao);
        //Crio a lista de threads para execucao
        List<Thread> threadsMulti = new ArrayList<>();
        Thread thread;
        int linhaInicial;
        int linhaFinal;
        //Crio a primeira thread para pegar a primeira linha (indice 0)
        thread = new ThreadCalculadora(matriz1, matriz2, resultante, 0,Math.floorDiv(dimensao, numThreads)-1,"Thread 1");
        //Inicia a thread para calcular as linhas da matriz resultante
        thread.start();
        //Armazena a thread na lista, para que a thread main espere-a terminar para exibir o resultado
        threadsMulti.add(thread);
        for (int i = 1; i < numThreads; i++){
            linhaInicial = Math.floorDiv(i*dimensao, numThreads);
            linhaFinal = Math.floorDiv(dimensao*(i+1),numThreads)-1;
            thread = new ThreadCalculadora(matriz1, matriz2, resultante, linhaInicial, linhaFinal, "Thread "+(i+1));
            thread.start();
            threadsMulti.add(thread);
        }

        //percorre a lista de threads para esperá-las terminarem
        for(Thread th: threadsMulti){
            try {
                th.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(CalculadoraMatrizes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resultante;
    }
    
    //Calcula a celula (linha, coluna) da matriz resultante
    public static int getValorProduto(Matriz m1, Matriz m2, int linha, int coluna){
        int tamanho = m1.getDimensao();
        int valor = 0;
        for (int i = 0; i < tamanho; i++){
            valor += m1.getValor(linha, i)*m2.getValor(i,coluna);
        }
        return valor;
    }
    
    
}
