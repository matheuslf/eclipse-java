import java.util.Scanner;

public class Principal {
	
	private static final int S1 = 0;
	private static final int S2 = 1;
	private static final int S3 = 2;
	private static final int S4 = 3;
	private static final int S5 = 4;
	private static final int S6 = 5;
	private static final int S7 = 6;
	private static final int S8 = 7;
	private static final int S9 = 8;
	private static final int S10 = 9;
	private static final int S11 = 10;
	private static final int S12 = 11;
	private static final int S13 = 12;
	private static final int S14 = 13;
	private static final int S15 = 14;
	private static final int S16 = 15;
	private static final int S17 = 16;
	private static final int S18 = 17;
	private static final int S19 = 18;
	private static final int S20 = 19;	
	
	private static int lerEstacao(final String tipo, final Scanner in) {
		
		while (true) {
			System.out.println(tipo+":");
			String linha = in.nextLine().trim();
			if (linha.isEmpty()) {
				System.out.println("Até a próxima!");
				System.exit(0);
			}

			try {
				int estacao = Integer.parseInt(linha);
				if (estacao >= 1 && estacao <= 20) {
					return estacao-1;
				}
			}
			catch (Exception e) {
				System.out.println("Digite uma estação válida. Opções disponíveis: 1 a 20");
			}			
		}
	}

	public static void main(String[] args) {
		
		Grafo g = new Grafo(20);
		
		// Linha vermelha
		g.criaArestar(S1, S2, 16);
		g.criaArestar(S2, S3, 14);
		g.criaArestar(S3, S4, 12);
		g.criaArestar(S4, S5, 12);
		g.criaArestar(S5, S6, 14);
		
		// Linha verde
		g.criaArestar(S7, S8, 15);
		g.criaArestar(S8, S9, 11);
		g.criaArestar(S9, S10, 13);
		g.criaArestar(S10, S11, 16);
		g.criaArestar(S11, S6, 15);
		
		// Linha Amarela.
		g.criaArestar(S12, S8, 11);
		g.criaArestar(S8, S2, 8);
		g.criaArestar(S2, S15, 7);
		g.criaArestar(S15, S16, 7);
		g.criaArestar(S16, S17, 12);
		g.criaArestar(S17, S18, 9);
		
		// Linha Azul
		g.criaArestar(S12, S9, 17);
		g.criaArestar(S9, S13, 7);
		g.criaArestar(S13, S14, 9);
		g.criaArestar(S14, S5, 9);
		g.criaArestar(S5, S17, 10);
		
		// Linha Roxa.
		g.criaArestar(S10, S13, 11);
		g.criaArestar(S13, S3, 13);
		g.criaArestar(S3, S16, 11);
		g.criaArestar(S16, S19, 13);
		g.criaArestar(S19, S20, 12);
		
		Scanner in = new Scanner(System.in);
		System.out.println("Bem-vindo ao Subway System");
		System.out.println("	Disciplina de Teoria dos Grafos");
		System.out.println("	Desenvolvido por: Prof. Matheus Leandro Ferreira");
		System.out.println("----------------------------------------------------");
		
		while (true) {
							
			System.out.println("Por favor, entre com a sua rota ou pressione ENTER para sair do programa.");
			int origem = lerEstacao("Origem", in);
			int destino = lerEstacao("Destino", in);
			
			
			for (Integer estacao : g.caminhoMinimo(origem, destino)) {
				System.out.print((estacao+1) +" -> ");	
			}
			
			System.out.println("Fim da Rota");
			
		}
	}

}
