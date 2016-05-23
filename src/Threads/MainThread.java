package Threads;

public class MainThread {
	
	public MainThread(){ }
	
	public void start(){
		
		// prowizoryczne póki co
		
		// N - liczba procesów potomnych
		int N = 5;
	
		// uruchamiamy wątki
		int ktoryWatek = 0;
		Runnable[] runners = new Runnable[N];
		Thread[] threads = new Thread[N];
	
		for( int i = 0 ; i < N ; i++)
		{
			runners[ktoryWatek] = new ChildThread(ktoryWatek);
			ktoryWatek++;
		}
	
		// start wątków
		for( int i = 0 ; i < N ; i++ ) {
			threads[i] = new Thread(runners[i]);
		}
	
		for( int i = 0 ; i < N ; i++ ) {
			threads[i].start();
		}
	
		// usypiam program główny na sekunde aby mieć pewność, że wątki skończą
		try { 
			Thread.sleep(1000);
		} catch ( InterruptedException e) {
			e.printStackTrace();
		}
	
		// po wykonaniu dzieci, od tego momentu leci tylko program główny
		System.out.println("Dalsze działania wątka głównego");
	}
}
