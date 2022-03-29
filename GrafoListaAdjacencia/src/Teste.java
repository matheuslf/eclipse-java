import java.util.ArrayList;

public class Teste {

	public static void main(String[] args) {
		
		Grafo g = new Grafo();
		Vertice s = g.addVertice("s");
		Vertice t = g.addVertice("t");
		Vertice y = g.addVertice("y");
		Aresta st = g.addAresta(s, t);
		Aresta sy = g.addAresta(s, y);
		Aresta ty = g.addAresta(t, y);
		Aresta yt = g.addAresta(y, t);
				
		System.out.println(g.toString());
		
	}

}
