import java.util.ArrayList;
import java.util.List;

public class Grafo {
	
	/**
	 * Lista de vertices deste grafo.
	 */
	private List<Vertice> listaVertices;
	
	/**
	 * Construtor padr�o do grafo.
	 */
	public Grafo() {
		listaVertices = new ArrayList<Vertice>();
	}
	
	/**
	 * Adiciona um n� no grafo.
	 * @param nome
	 * 			representando este n�.
	 * @return
	 * 		  o vertice criado.
	 */
	public Vertice addVertice(final String nome) {
		Vertice v = new Vertice(nome);
		listaVertices.add(v);
		return v;
	}
	
	/**
	 * Adiciona uma aresta no grafo.
	 * @param origem
	 * 			n� origem
	 * @param destino
	 * 			n� destino.
	 * @return
	 */
	public Aresta addAresta(final Vertice origem, final Vertice destino) {
		Aresta a = new Aresta(origem, destino);
		origem.getAdj().add(a);
		return a;
	}
	
	@Override
	public String toString() {
		
		String r = "";
		for (Vertice v : listaVertices) {
			r += v.getNome() + " -> ";
			for (Aresta a : v.getAdj()) {
				v = a.getDestino();
				r += "["+v.getNome()+"] -> ";
			}
			r += "[*]";
			r += "\n";
		}
		
		return r;
	}
}
