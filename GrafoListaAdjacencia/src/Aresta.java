
public class Aresta {
	
	/**
	 * Nó origem.
	 */
	private Vertice origem;
	
	/**
	 * Nó destino.
	 */
	private Vertice destino;
	
	/**
	 * Construtor da aresta.
	 * @param origem
	 * 			Nó origem
	 * @param destino
	 * 			Nó destino
	 */
	public Aresta(final Vertice origem, final Vertice destino) {
		this.origem = origem;
		this.destino = destino;
	}

	/**
	 * @return
	 * 	O nó origem desta aresta.
	 */
	public Vertice getOrigem() {
		return origem;
	}
	
	/**
	 * @return
	 * 	O nó destino desta aresta.
	 */
	public Vertice getDestino() {
		return destino;
	}	
}
