
public class Aresta {
	
	/**
	 * N� origem.
	 */
	private Vertice origem;
	
	/**
	 * N� destino.
	 */
	private Vertice destino;
	
	/**
	 * Construtor da aresta.
	 * @param origem
	 * 			N� origem
	 * @param destino
	 * 			N� destino
	 */
	public Aresta(final Vertice origem, final Vertice destino) {
		this.origem = origem;
		this.destino = destino;
	}

	/**
	 * @return
	 * 	O n� origem desta aresta.
	 */
	public Vertice getOrigem() {
		return origem;
	}
	
	/**
	 * @return
	 * 	O n� destino desta aresta.
	 */
	public Vertice getDestino() {
		return destino;
	}	
}
