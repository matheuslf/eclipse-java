
public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String procurado = "Dave";
		System.out.println("Procurando : "+procurado);
		
		BuscaNomeRunnable busca1 = new BuscaNomeRunnable("signatarios-fev-2002.txt", procurado);
		BuscaNomeRunnable busca2 = new BuscaNomeRunnable("signatarios-fev-2016.txt", procurado);
		BuscaNomeRunnable busca3 = new BuscaNomeRunnable("signatarios-out-2014.txt", procurado);
		
		Thread t1 = new Thread(busca1);
		Thread t2 = new Thread(busca2);
		Thread t3 = new Thread(busca3);
		
		t1.start();
		t2.start();
		t3.start();
		
	}

}
