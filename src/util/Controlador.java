package util;

import util.Trie;
import java.util.StringTokenizer;

public class Controlador {
   private StringTokenizer comando;
    private Trie arvTrie;
    
    public Controlador(){
        arvTrie = new Trie();
        
    }

    public void tratar(String comando){

        this.comando = new StringTokenizer(comando, " ");
        String metodo = this.comando.nextToken().toLowerCase();


        if(arvTrie != null){
            //System.out.print(arvTrie.getClass().getSimpleName() + ": ");

            //Escolher método
            if(metodo.equals("inserir")){
                if(this.comando.hasMoreElements()){
                    Object dado = this.comando.nextToken("\n").substring(1);
                    arvTrie.inserir((String) dado);
                    System.out.println(dado + " adicionado");
                }
            }
            else if(metodo.equals("remover")){
                if(this.comando.hasMoreElements()){
                    Object dado = this.comando.nextToken("\n").substring(1);
                    arvTrie.remover((String) dado);
                    System.out.println(dado + " removido");
                }
                
            }
            else if(metodo.equals("imprimir")){       
                System.out.println("\n------IMPRIMIR------");
                arvTrie.imprimir(); 
                System.out.println("----------------------\n");
            }
            else if(metodo.equals("buscar")){
                if(this.comando.hasMoreElements()){
                    Object dado = this.comando.nextToken("\n").substring(1);
    
                    if(arvTrie.contem((String) dado) == false){
                        System.out.println(dado + " não foi encontrado");
                    }
                    else{
                        System.out.println(dado + " foi encontrado");
                    }
                }else{
                    System.out.println("Dado inválido");
                }
                
            }
            else{
                System.out.println("Método inválido.");
            }
        
        }
    }

    public void adicionarDados(Object[] dados){
        if(dados != null){
            for (int i = 0; i < dados.length ; i++){
              arvTrie.inserir((String) dados[i]);
          } 
        }   
    } 
}
