package main;

import util.Controlador;
import util.LeituraArquivo;

public class Main {
    
	public static void main(String[] args) {
        
        LeituraArquivo palavras = new LeituraArquivo("src\\entradas\\listadepalavras.txt");
        LeituraArquivo dados = new LeituraArquivo("src\\entradas\\palavra.txt");
        Controlador ctrl = new Controlador();
        String palavra = dados.lerEnesima(0).toString();

        System.out.println("Identificador de senhas fracas");
        System.out.println("----------Iniciando----------");
        System.out.println("");
        
         ctrl.adicionarDados(dados.lerTudo());
         ctrl.tratar("buscar " + palavra);
        
        
      }
       
}
