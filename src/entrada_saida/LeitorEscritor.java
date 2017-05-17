/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entrada_saida;

import dominio.Matriz;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Rafael
 */
public class LeitorEscritor {
    
    public Matriz getMatrizEntrada(String nomeArquivo) throws FileNotFoundException, IOException{
        Matriz m;
        FileReader arq = new FileReader(nomeArquivo);
        BufferedReader lerArq = new BufferedReader(arq);
        int dimensao = Integer.parseInt(lerArq.readLine().split(" ")[0]);
        m = new Matriz(dimensao);
        String linha;
        String[] valoresLinha;
        for (int i = 0; i < dimensao; i++){
            linha = lerArq.readLine();
            valoresLinha = linha.split(" ");
            for (int j = 0; j < dimensao; j++){
                m.atribuirValor(i, j, Integer.parseInt(valoresLinha[j]));
            }
        }
        lerArq.close();
        return m;
    }
    
    public void armazenarMatrizResultante(Matriz resultante) throws IOException{
        int dimensaoUsada = resultante.getDimensao();
        FileWriter arq = new FileWriter("Resultado"+dimensaoUsada+"x"+dimensaoUsada+".txt");
        PrintWriter gravarArq = new PrintWriter(arq);
        for (int i = 0; i < dimensaoUsada; i++){
            for (int j = 0; j < dimensaoUsada; j++){
                gravarArq.print(resultante.getValor(i, j) + " ");
            }
            gravarArq.println();
        }
        gravarArq.close();
    }
}
