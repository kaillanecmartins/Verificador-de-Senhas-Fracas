package util;

import java.util.ArrayList;
import java.util.List;

public class Trie {
    private static final int R = 256; // ASCII estendido
    private TrieNo raiz;
	
    private class TrieNo {
    	boolean eFim;
    	TrieNo[] filhos;
    	
        public TrieNo() {
            eFim = true;
            filhos = new TrieNo[R];
        }
    }
    
    public Trie() {
        raiz = new TrieNo();
    }

    // Insere uma palavra na trie.
    public void inserir(String palavra) {
    	TrieNo atual = raiz;
    	for(int i=0, L=palavra.length(); i<L; i++) {
        	int id = palavra.charAt(i) - 0;
        	if(atual.filhos[id]==null) {
        		atual.filhos[id] = new TrieNo();
        		atual.filhos[id].eFim = false;
        	}
        	atual = atual.filhos[id];
        }
        atual.eFim = true;
    }

    // Retorna se a palavra está na trie.
    public boolean contem(String palavra) {
        return buscar(palavra, 1);
    }

    // Retorna se há alguma palavra na trie que começa com o prefixo dado.
    public boolean contemPrefixo(String prefixo) {
        return buscar(prefixo, 2);
    }
    
    private boolean buscar(String str, int tipo) {
        TrieNo atual = raiz;
        int i=-1, L=str.length();
        while(++i<L) {
	        int id = str.charAt(i) - 0;
	        if(atual.filhos[id]==null) return false;
	    	atual = atual.filhos[id];
        }
        return tipo==1 ? atual.eFim : true;
    }
    
    // Remove uma palavra da trie
    public void remover(String palavra) {
        remover(raiz, palavra, 0);
    }

    private boolean remover(TrieNo no, String palavra, int profundidade) {
        if (no == null) {
            return false;
        }

        if (profundidade == palavra.length()) {
            if (!no.eFim) {
                return false;
            }
            no.eFim = false;
            return estaVazia(no);
        }

        int id = palavra.charAt(profundidade);
        if (remover(no.filhos[id], palavra, profundidade + 1)) {
            no.filhos[id] = null;
            return !no.eFim && estaVazia(no);
        }
        return false;
    }

    private boolean estaVazia(TrieNo no) {
        for (int i = 0; i < R; i++) {
            if (no.filhos[i] != null) {
                return false;
            }
        }
        return true;
    }
    
    // Lista de palavras na trie
    public List<String> listarPalavras() {
    	List<String> lista = new ArrayList<>();
    	listar(raiz, 0, "", lista);
    	return lista;
    }
    
    private void listar(TrieNo atual, int id, String prefixo, List<String> lista) {
    	if(atual == null) return;
    	for(int i=0; i<R; i++) {
			TrieNo filho = atual.filhos[i];
    		if(filho != null) {
    			String res = prefixo + (char)i;
    			if(filho.eFim) lista.add(res);
    			listar(filho, i, res, lista);
    		}
    	}
    }
    
    // Imprime o conteúdo da trie de forma simples
    public void imprimir() {
        imprimir(raiz, new StringBuilder());
    }

    private void imprimir(TrieNo no, StringBuilder prefixo) {
        if (no == null) {
            return;
        }
        
        if (no.eFim) {
            System.out.println(prefixo.toString());
        }

        for (int i = 0; i < R; i++) {
            if (no.filhos[i] != null) {
                prefixo.append((char) i);
                imprimir(no.filhos[i], prefixo);
                prefixo.deleteCharAt(prefixo.length() - 1);
            }
        }
    }
}
