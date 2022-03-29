import java.util.ArrayList;
import java.util.List;

public class Vertice {
	
	/*
	 * Nome representativo do N�.
	 */
	private String nome;
	
	/*
	 * Lista de adjcencia. 
	 */
	private List<Aresta> adj;
	
	/**
	 * Contrutor do vertice.
	 * @param nome
	 * 			representativo deste n�.
	 */
	public Vertice(final String nome) {
		this.nome = nome;
		this.adj = new ArrayList<Aresta>();
	}
	
	/**
	 * @return
	 * 	Nome representativo do n�.
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * @return
	 *  Lista de adjacencia deste n�.
	 */
	public List<Aresta> getAdj() {
		return adj;
	}
}
