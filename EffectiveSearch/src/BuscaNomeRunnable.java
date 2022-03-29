import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;


public class BuscaNomeRunnable implements Runnable {

	private String nomeArquivo;
	private String nomeBuscado;
	
	
	public BuscaNomeRunnable(String nomeArquivo, String nomeBuscado) {
		super();
		this.nomeArquivo = nomeArquivo;
		this.nomeBuscado = nomeBuscado;
	}

	@Override
	public void run() {
		try {
			Scanner scanner = new Scanner(new FileReader(nomeArquivo));
			int lin = 1;
			while(scanner.hasNext()) {
				String line = scanner.nextLine();
				if(line.contains(nomeBuscado)) {
					System.out.println(nomeBuscado + " foi encontrado no Arquivo: "+this.nomeArquivo+" na linha: "+lin+" : "+line);
				}
				lin++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
