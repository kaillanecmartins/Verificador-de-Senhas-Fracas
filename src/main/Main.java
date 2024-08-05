package main;

import java.util.StringTokenizer;
import util.LeituraArquivo;
import util.Trie;
import util.Controlador;

public class Main {
    
	public static void main(String[] args) {
        
        LeituraArquivo palavras = new LeituraArquivo("src\\entradas\\listadepalavras.txt");
        //link da lista: https://github.com/0xrdf/Brazilian-wordlist/blob/master/brazilPasswords.txt
        
        LeituraArquivo dados = new LeituraArquivo("src\\entradas\\palavra.txt");
        String palavra = dados.lerEnesima(0).toString();
        Controlador ctrl = new Controlador();
        Trie arv = new Trie();
        
        //inserindo palavras na árvore
        ctrl.adicionarDados(palavras.lerTudo(), arv);
        
        System.out.println("Atividade 05 - Árvore Trie");
        System.out.println("Dupla: Kaillane e Valter");
        System.out.println("----------Iniciando----------");
        System.out.println("Identificador de senhas fracas");
        System.out.println("Para testar sua senha, insira ela no arquivo palavra.txt na pasta entradas\n");
  
        if(arv.contem(palavra) == false){
            System.out.println("A senha " + palavra + " provavelmente é segura");
        }else if(arv.contem(palavra) == true){
            System.err.println("A senha " + palavra + " não é segura!!!");
            System.out.println("Tente outra senha.");
        }
        
        
      }
       
}
