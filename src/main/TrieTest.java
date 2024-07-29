package main;

import util.Controlador;
import util.LeituraArquivo;

public class TrieTest {
    
	public static void main(String[] args) {
        
        LeituraArquivo dados = new LeituraArquivo("src\\entradas\\listadepalavras.txt");
        LeituraArquivo comandos = new LeituraArquivo("src\\entradas\\palavra.txt");
        Controlador ctrl = new Controlador();

        System.out.println("Identificador de senhas fracas");
        System.out.println("----------Iniciando----------");
        
        ctrl.adicionarDados(dados.lerTudo());
        
        Object comando[] = comandos.lerTudo();
        for (int i = 0; i < comando.length; i++) {
            ctrl.tratar(comando[i].toString());
        }
        
      }
}
