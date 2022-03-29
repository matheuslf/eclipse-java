import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class AtividadeArray {
	
	//
	// TODOS OS MÉTODOS JÁ TIPADOS COMO STRING.
	//
	
	// Remove os itens duplicados sem alterar o array original.
	public static ArrayList<String> removeDuplicates(ArrayList<String> arl)
    {
        final ArrayList<String> newList = new ArrayList<String>();
        for (String element : arl) {
            if (!newList.contains(element)) {  
                newList.add(element);
            }
        }
        return newList;
    }
	
	// Remove os itens vazios sem alterar o original.
	public static ArrayList<String> removeEmpty(ArrayList<String> arl)
    {
        final ArrayList<String> newList = new ArrayList<String>();
        for (String element : arl) {
            if (!element.isEmpty()) {  
                newList.add(element);
            }
        }
        return newList;
    }
	
	// Retira os espaços sem alterar o original.
	public static ArrayList<String> applyTrim(ArrayList<String> arl)
    {
        final ArrayList<String> newList = new ArrayList<String>();
        for (String element : arl) {              
            newList.add(element.trim());
        }
        return newList;
    }
	
	// Aplica a função TUDO MAIUSCULO sem alterar o original.
	public static ArrayList<String> toUpperCase(ArrayList<String> arl)
    {
        final ArrayList<String> newList = new ArrayList<String>();
        for (String element : arl) {              
            newList.add(element.toUpperCase());
        }
        return newList;
    }
	
	// Aplica a função TUDO MINUSCULO sem alterar o original.
	public static ArrayList<String> toLowerCase(ArrayList<String> arl)
    {
        final ArrayList<String> newList = new ArrayList<String>();
        for (String element : arl) {              
            newList.add(element.toLowerCase());
        }
        return newList;
    }
	
	public static ArrayList<String> toCapitalize(ArrayList<String> arl) 
	{
		final ArrayList<String> newList = new ArrayList<String>();
		for (int i = 0; i < arl.size(); i++) {			
			String novoNome = "";
			if (arl.get(i).indexOf(" ") > 0) {
				String pedacos[] = arl.get(i).split(" ");
				for (String partes : pedacos) {
					novoNome += partes.substring(0, 1).toUpperCase() + partes.substring(1).toLowerCase();
					novoNome = novoNome + " ";
				}
			}
			else {
				novoNome = arl.get(i);
				novoNome = novoNome.replaceFirst(" ", "");
				novoNome = novoNome.substring(0, 1).toUpperCase() + novoNome.substring(1).toLowerCase();
			}
			novoNome = novoNome.trim();
			newList.add(novoNome);
		}
		return newList;
	}

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int opcao = 0;
		
		ArrayList<String> arl = new ArrayList<String>();
		arl.add("Matheus Leandro Ferreira");
		arl.add("Vanessa Rocha alexandre");
		arl.add("Lucas alexandre ferreira");
		//arl.add("");
		arl.add("Giovanna alexandre Ferreira");
		
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
				Collections.sort(arl);
				System.out.println(arl.toString());				
				break;
			case 2:
				Collections.sort(arl);
				Collections.reverse(arl);
				System.out.println(arl.toString());
				break;
			case 3:
				System.out.println(removeDuplicates(arl).toString());
				break;				
			case 4:			
				Collections.reverse(arl);
				System.out.println(arl.toString());
				break;
			case 5:		
				System.out.println(removeEmpty(arl).toString());
				break;
			case 6:		
				System.out.println(applyTrim(arl).toString());
				break;
			case 7:
				System.out.println(toUpperCase(arl).toString());				
				break;
			case 8:
				System.out.println(toLowerCase(arl).toString());
				break;
			case 9:
				System.out.println(toCapitalize(arl).toString());
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
