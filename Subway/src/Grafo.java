import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Grafo {
	
	private static final int INDEFINIDO = -1;
	private int vertices[][];
	
	//
	// Construtor para a cria��o do Grafo.
	//
	public Grafo(final int numVertices) {
		vertices = new int[numVertices][numVertices];
	}
	
	public void criaArestar(final int noOrigem, final int noDestino, final int peso) {
		//
		// Se o peso for positivo ...
		//
		if (peso >= 1) {
			vertices[noOrigem][noDestino] = peso;
			vertices[noDestino][noOrigem] = peso;
		}
		else {
			throw new InvalidParameterException("O peso do n� origem ["+noOrigem+"] para o n� destino ["+noDestino+"] n�o pode ser negativo ["+peso+"]");
		}
	}
	
	public List<Integer> caminhoMinimo(final int noOrigem, final int noDestino) {
		
		// Variaveis de controle.
		int custo[] = new int[vertices.length];
		int antecessor[] = new int[vertices.length];
		Set<Integer> naoVisitados = new HashSet<Integer>();
		
		// Custo inicial.
		custo[noOrigem] = 0;
		
		// Inicializa as variaveis de controle.
		for (int v = 0; v < vertices.length; v++) {
			if (v != noOrigem) {
				custo[v] = Integer.MAX_VALUE; // Simboliza o infinito.
			}
			antecessor[v] = INDEFINIDO;
			naoVisitados.add(v);
		}
		
		while (!naoVisitados.isEmpty()) {
			
			// Busca o vertifice n�o visitado mais pr�ximo.
			int noMaisProximo = getMaisProximos(custo, naoVisitados);
			
			// Retira da lista dos Visitados.
			naoVisitados.remove(noMaisProximo);		
			
			for (Integer vizinho : getVizinho(noMaisProximo)) {
				int custoTotal = custo[noMaisProximo] + getCusto(noMaisProximo, vizinho);
				if (custoTotal < custo[vizinho]) {
					custo[vizinho] = custoTotal;
					antecessor[vizinho] = noMaisProximo;
				}
			}
			
			if (noMaisProximo == noDestino) {
				return caminhoMaisProximo(antecessor, noMaisProximo);
			}
		}
		
		return null;
	}
	
	/**
	 * Busca o n� mais pr�ximo a ser explorado.
	 * @param listaCusto
	 * @param naoVisitados
	 * @return
	 */
	public int getMaisProximos(final int listaCusto[], final Set<Integer> naoVisitados) {
		
		double minDistancia = Integer.MAX_VALUE;
		int noProximo = 0;
		for (Integer i : naoVisitados) {
			if (listaCusto[i] < minDistancia) {
				minDistancia = listaCusto[i];
				noProximo = i;
			}
		}
		
		return noProximo;
	}
	
	public List<Integer> getVizinho(final int no) {
		
		List<Integer> vizinhos = new ArrayList<Integer>();
		for (int i = 0; i < vertices.length; i++) {
			if (vertices[no][i] > 0) {
				vizinhos.add(i);
			}
		}
		return vizinhos;
	}
	
	public int getCusto(final int noOrigem, final int noDestino) { 
		return vertices[noOrigem][noDestino];		
	}
	
	private List<Integer> caminhoMaisProximo(final int antecessor[], int noMaisProximo) {
		List<Integer> caminho = new ArrayList<Integer>();
		caminho.add(noMaisProximo);
		while (antecessor[noMaisProximo] != INDEFINIDO) {
			caminho.add(antecessor[noMaisProximo]);
			noMaisProximo = antecessor[noMaisProximo];
		}
		
		Collections.reverse(caminho);
		return caminho;
	}

}



















