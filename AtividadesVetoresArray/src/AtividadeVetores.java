import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class AtividadeVetores {

	// Remove os itens duplicados sem alterar o array original.
	public static String[] removeDuplicates(String[] nomes)
    {
        Set<String> s = new HashSet<String>();
        for (String n : nomes) {
        	s.add(n);
        }     
        final String[] newList = new String[s.size()];
        return s.toArray(newList);
    }
	
	// Inverte ou embaralha o vetor de String.
	public static String[] inversao(String [] v) {

		Random random = new Random();

		for (int i=0; i < (v.length - 1); i++) {

			//sorteia um índice
			int j = random.nextInt(v.length);

			//troca o conteúdo dos índices i e j do vetor
			String temp = v[i];
			v[i] = v[j];
			v[j] = temp;
		}
		
		return v;
	}
	
	// Remove os itens vazios sem alterar o original.
	public static String[] removeEmpty(String[] arl)
    {        
        Set<String> set = new HashSet<String>();
        for (String element : arl) {
            if (!element.isEmpty()) {  
            	set.add(element);
            }
        }
        final String[] newList = new String[set.size()];
        set.toArray(newList);        
        return newList;
    }
	
	// Retira os espaços sem alterar o original.
	public static String[]  applyTrim(String[] arl)
    {
		Set<String> set = new HashSet<String>();
	        for (String element : arl) {	          
	            set.add(element.trim());
	        }
        final String[] newList = new String[set.size()];
        set.toArray(newList);        
        return newList;
    }
	
	// Aplica a função TUDO MAIUSCULO sem alterar o original.
	public static String[] toUpperCase(String[] arl)
    {
		Set<String> set = new HashSet<String>();
        for (String element : arl) {	          
            set.add(element.toUpperCase());
        }
	    final String[] newList = new String[set.size()];
	    set.toArray(newList);        
	    return newList;
    }
	
	// Aplica a função TUDO MINUSCULO sem alterar o original.
	public static String[] toLowerCase(String[] arl)
    {
		Set<String> set = new HashSet<String>();
        for (String element : arl) {	          
            set.add(element.toLowerCase());
        }
	    final String[] newList = new String[set.size()];
	    set.toArray(newList);        
	    return newList;
    }
	
	public static String[] toCapitalize(String[] arl) 
	{
		final String[] newList = new String[arl.length];
		for (int i = 0; i < arl.length; i++) {			
			String novoNome = "";
			if (arl[i].indexOf(" ") > 0) {
				String pedacos[] = arl[i].split(" ");
				for (String partes : pedacos) {
					novoNome += partes.substring(0, 1).toUpperCase() + partes.substring(1).toLowerCase();
					novoNome = novoNome + " ";
				}
			}
			else {
				novoNome = arl[i];
				novoNome = novoNome.replaceFirst(" ", "");
				novoNome = novoNome.substring(0, 1).toUpperCase() + novoNome.substring(1).toLowerCase();
			}
			novoNome = novoNome.trim();
			newList[i] = novoNome;
		}
		return newList;
	}
	
	// Faz a impressão do vetor.
	public static void imprimirVetor(final String[] vetor) {
		for (String n : vetor) {
			System.out.println(n);
		}
	}
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int opcao = 0;
		int contador = 0;
		
		final String[] nomes = new String[]{
			"Matheus Leandro Ferreira",
			"Matheus Leandro Ferreira",
			"Lucas alexandre ferreira",
			"Giovanna alexandre Ferreira"
		};
		
		String[] novosNomes = new String[nomes.length];
		
		do {
			
			System.out.println("=== Escolha uma das opções abaixo ===");
			System.out.println("=== 0 - Sair");
			System.out.println("=== 1 - Ordenação de A-Z");
			System.out.println("=== 2 - Ordenação de Z-A");
			System.out.println("=== 3 - Remover duplicados");
			System.out.println("=== 4 - Inversão de Valores");
			System.out.println("=== 5 - Remover vazios");
			System.out.println("=== 6 - Aplicar TRIM");
			System.out.println("=== 7 - Converter para tudo MAIUSCULO");
			System.out.println("=== 8 - Converter para tudo MINUSCULO");
			System.out.println("=== 9 - Converter Capitalizar");			
			System.out.println("======================================");
			
			opcao = s.nextInt();
			
			switch (opcao) {
			case 1:				
				Arrays.sort(nomes);
				imprimirVetor(nomes);
				break;
			case 2:
				Arrays.sort(nomes);
				novosNomes = new String[nomes.length];
				contador = 0;
				for (int i = nomes.length; i > 0; i--) {
					novosNomes[contador] = nomes[i-1];					
					contador++;
				}
				imprimirVetor(novosNomes);
				break;
			case 3:
				Arrays.sort(nomes);
				novosNomes = removeDuplicates(nomes);
				imprimirVetor(novosNomes);
				break;				
			case 4:		
				
				Arrays.sort(nomes);
				novosNomes = new String[nomes.length];
				contador = 0;
				for (int i = nomes.length; i > 0; i--) {
					novosNomes[contador] = nomes[i-1];					
					contador++;
				}
				
				novosNomes = inversao(novosNomes);
				imprimirVetor(novosNomes);
				break;
			case 5:		
				imprimirVetor(removeEmpty(nomes));				
				break;
			case 6:
				imprimirVetor(applyTrim(nomes));
				break;
			case 7:
				imprimirVetor(toUpperCase(nomes));				
				break;
			case 8:
				imprimirVetor(toLowerCase(nomes));
				break;
			case 9:
				imprimirVetor(toCapitalize(nomes));
				break;
			case 0:
				System.out.println("Você saiu do programa!");
				break;
			default:
				System.out.println("Opção inválida!");
				break;
			}	
		}
		while (opcao > 0);		
		
	}

}
