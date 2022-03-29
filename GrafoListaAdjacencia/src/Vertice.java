import java.util.ArrayList;
import java.util.List;

public class Vertice {
	
	/*
	 * Nome representativo do Nó.
	 */
	private String nome;
	
	/*
	 * Lista de adjcencia. 
	 */
	private List<Aresta> adj;
	
	/**
	 * Contrutor do vertice.
	 * @param nome
	 * 			representativo deste nó.
	 */
	public Vertice(final String nome) {
		this.nome = nome;
		this.adj = new ArrayList<Aresta>();
	}
	
	/**
	 * @return
	 * 	Nome representativo do nó.
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * @return
	 *  Lista de adjacencia deste nó.
	 */
	public List<Aresta> getAdj() {
		return adj;
	}
}
