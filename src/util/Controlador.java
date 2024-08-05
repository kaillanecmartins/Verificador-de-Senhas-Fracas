package util;

public class Controlador {

    public Controlador() {
    }
    
    public void adicionarDados(Object[] dados, Trie arvTrie){
        if(dados != null){
            for (int i = 0; i < dados.length ; i++){
              arvTrie.inserir((String) dados[i]);
          } 
        }   
    } 
}

