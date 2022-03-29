import java.util.ArrayList;

public class Acervo {
	
	private static ArrayList<Livraria> listaLivros = new ArrayList<Livraria>();
	
	public static ArrayList<Livraria> getListaLivros() {
		return listaLivros;
	}
	
	public static void adicionar(Livraria l) {
		listaLivros.add(l);
	}
	
	public static String listar() {
		String saida = "";
		
		int i = 1;
		for (Livraria l : listaLivros) {
			saida += "\n======== Livro nº "+(i++) +" ====== \n";
			saida += l.toString()+"\r\n";
		}
		
		return saida;
	}
	
	public static int pesquisar(final String genero) {
		int qtd = 0;
		
		for (Livraria l : listaLivros) {
			if (l.getGenero().equalsIgnoreCase(genero)) {
				qtd++;
			}	
		}		
		return qtd;
	}
	
	public static int pesquisar(final double vInicial, final double vFinal) {
		int qtd = 0;
		
		for (Livraria l : listaLivros) {
			if (l.getPreco() >= vInicial && l.getPreco() < vFinal) {
				qtd++;
			}	
		}		
		return qtd;
	}
	
	public static boolean remover(final String titulo) {				
		for (Livraria l : listaLivros) {
			if (l.getTitulo().equalsIgnoreCase(titulo)) {
				return (listaLivros.remove(l));
			}	
		}		
		return false;
	}
	
	public static double calcularTotalAcervo() {
		double total = 0;
		
		for (Livraria l : listaLivros) {
			total = total + l.getPreco();	
		}	
		
		return total;
	}
	

}
