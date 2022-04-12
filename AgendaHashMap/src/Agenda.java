import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Map.Entry;

public class Agenda {

    private static final HashMap<String, Contato> hmp = new HashMap<String, Contato>();
    private static final String SEPARADOR_IMPORTADOR_ARQUIVO = "@";
    private static final int POSICAO_NOME_AGENDA = 0;
    private static final int POSICAO_TELEFONE_AGENDA = 1;
    private static final int POSICAO_ENDERECO_AGENDA = 2;

    private static boolean importarContato() {

        boolean isSucesso = true;

        try {
            InputStream is = new FileInputStream(new File("C:\\contato\\contato.txt"));
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader buffer = new BufferedReader(isr);
                
            String linha= "";
            while ((linha = buffer.readLine()) != null) {
                String[] partes = linha.split(SEPARADOR_IMPORTADOR_ARQUIVO);
                Contato c = new Contato();
                c.setNome(partes[POSICAO_NOME_AGENDA]);
                c.setFone(partes[POSICAO_TELEFONE_AGENDA]);
                c.setEndereco(partes[POSICAO_ENDERECO_AGENDA]);                
                hmp.put(c.getFone(),c);
            }
            buffer.close();
        }
        catch (Exception ex) {
            isSucesso = false;
        }

        return isSucesso;        
    }

    private static boolean exportarContato() {

        boolean isSucesso = true;

        try {
            String nome = "C:\\contato\\contato.txt";  
			File f = new File(nome);  
			f.delete();
			
			FileWriter arq = new FileWriter("C:\\contato\\contato.txt");
			
			Iterator<Entry<String, Contato>> it = hmp.entrySet().iterator();
			while (it.hasNext()) {
				Entry<String, Contato> entry = it.next();
			
				Contato c = entry.getValue();
				
				arq.write(c.getNome()+"@"+c.getFone()+"@"+c.getEndereco());
				arq.write("\r\n");
			}
			
			arq.close();    
        }
        catch (Exception ex) {
            isSucesso = false;
        }

        return isSucesso;
    }

    private static Contato dadosContatoSolicitar(final Scanner scan) {
        Contato contato = new Contato();
			
        System.out.println("Qual o nome do contato?\n");
        String nome = scan.next();
        contato.setNome(nome);        
        
        System.out.println("Qual o numero do contato?\n");
        String numero = scan.next();
        contato.setFone(numero);        
        
        System.out.println("Qual o endereco do contato?\n");
        String end = scan.next();
        contato.setEndereco(end);
    
        return contato;
    }

    private static void removerContato(final Scanner scan, final String pergunta) {
        System.out.println(pergunta);
        String resposta = scan.next();

        if (hmp.containsKey(resposta)) {
            hmp.remove(resposta);
        }
        else {
            Iterator<Entry<String, Contato>> it = hmp.entrySet().iterator();
            while (it.hasNext()) {
            Entry<String, Contato> entry = it.next();            
                if(entry.getValue().getNome().equals(resposta)) {
                    hmp.remove(entry.getValue().getFone());
                }
            }
        }
    }

    private static Contato getContato(final Scanner scan, final String pergunta) {
        System.out.println(pergunta);
        String resposta = scan.next();

        if (hmp.containsKey(resposta)) {
            return hmp.get(resposta);
        }
        else {
            Iterator<Entry<String, Contato>> it = hmp.entrySet().iterator();
            while (it.hasNext()) {
            Entry<String, Contato> entry = it.next();            
                if(entry.getValue().getNome().equals(resposta)) {                    
                    return hmp.get(entry.getValue().getFone());
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {        
        
        Scanner scan = new Scanner(System.in);
        int opcao = 11;

        do
        {            
            System.out.println(
				"=========================================================\n"+
				"1- Importar Contatos\n"+  
				"2- Exportar Contatos\n"+  
				"3- Inserir Contato\n"+  
				"4- Remover Contato usando o Número de Telefone\n"+  
				"5- Remover Contato usando o Nome pessoal\n"+  
				"6- Localizar Contato usando o Nome pessoal\n"+  
				"7- Localizar Contato usando o Número de telefone\n"+  
				"8- Listar todos os contatos\n"+  
				"9- Realizar chamada\n"+  
				"10- Limpar Agenda\n"+  
				"11- Sair da Agenda\n"+
				"=========================================================");

                opcao = scan.nextInt();

                switch (opcao) {
                    case 1:
                        if (importarContato()) {
                            System.out.println("Contatos importados!");
                        }
                        break;
                    case 2:
                        if (exportarContato()) {
                            System.out.println("Contatos exportados!");
                        }
                        break;
                    case 3:                        
                        Contato c = dadosContatoSolicitar(scan);
                        hmp.put(c.getFone(), c);
                        break;
                    case 4:
                        removerContato(scan, "Qual o número de telefone do contato?");
                        break;
                    case 5:
                        removerContato(scan, "Qual o nome do contato?");
                        break;
                    case 6:
                        Contato c1 = getContato(scan, "Qual o nome do contato?");
                        if (c1 == null) {
                            System.out.println("Contatos não encontrado!");
                        }
                        else {
                            System.out.println(c1.toString());
                        }

                        break;
                    case 7:
                        Contato c2 = getContato(scan, "Qual o telefone do contato?");
                        if (c2 == null) {
                            System.out.println("Contatos não encontrado!");
                        }
                        else {
                            System.out.println(c2.toString());
                        }
                        break;
                    case 8:
                        System.out.println(hmp.values().toString());
                        break;
                    case 9:
                        break;
                    case 10:
                        hmp.clear();
                        System.out.println("Agenda limpa");
                        break;
                    case 11:
                        System.out.println("Você saiu ;)");
                        break;
                    default:
                        System.err.print("Opção inválida!");
                        break;
                }

        } while (opcao != 11);

    }
}