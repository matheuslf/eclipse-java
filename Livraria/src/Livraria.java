
public class Livraria {

	private String titulo;
	private String autor;
	private int isbn;
	private String genero;
	private float preco;
	
	public Livraria() {
	}
	
	public Livraria(final String titulo, final String autor, final int isbn, final String genero, final float preco) {
		this.titulo = titulo;
		this.autor = autor;
		this.isbn = isbn;
		this.genero = genero;
		this.preco = preco;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	@Override
	public String toString() {		
		return "Titulo: "+titulo+"\r\n"
				+"Autor: "+autor+"\r\n"
				+"Isbn: "+isbn+"\r\n"
				+"Gênero: "+genero+"\r\n"
				+String.format("Preço R$ 2.f%", preco);
	}
	
}
