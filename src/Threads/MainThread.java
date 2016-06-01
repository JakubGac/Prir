package Threads;

import Jama.*;
import Matrix.My_Matrix;

public class MainThread {
	
	public MainThread(){
		
	}
	
	public void count(My_Matrix A, My_Matrix B) throws Exception{
		inverse(A);
		multiply(A,B);
	}
	
	private void inverse(My_Matrix A){
		Matrix tmp = new Matrix(A.get_full_a_table());
		tmp = tmp.inverse();
		A.set_full_a_table(tmp.getArray());
	}
	
	private void multiply(My_Matrix A, My_Matrix B) throws Exception{
		// chceck if multiply is possible
		if(A.getWidth() != B.getHeight()){
			throw new Exception("Mnożenie tych macierzy nie jest możliwe!");
		}
		
		// creating N - child processes, each child process will receive a number in the resulting matrix 
		int N = A.getWidth() * B.getHeight();
		
		// creating Matrix with results
		My_Matrix resultsMatrix = new My_Matrix(B.getHeight());
		for(int i=0 ; i < resultsMatrix.getHeight() ; i++){
			resultsMatrix.set_b_table(i, 0);
		}
		
		// starting threads
		int whichThread = 0;
		Runnable[] runners = new Runnable[N];
		Thread[] threads = new Thread[N];
		
		for(int i=0 ; i < resultsMatrix.getHeight() ; i++){
				runners[whichThread++] = new ChildThread(whichThread,i,A,B,resultsMatrix);
		}
		
		for(int i=0; i<N; i++) {
			threads[i] = new Thread(runners[i]);
		}
			    
		for(int i=0; i<N; i++) {
			threads[i].start();
		}
		
		// usypiam program główny na sekunde aby mieć pewność, że wątki skończą
		try {
			System.out.println("Main thread is snoring for one second ");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// let's print the results :)
		System.out.println("\nMatrix with results:");
		printMatrix(resultsMatrix);
	}
	
	private void printMatrix(My_Matrix macierz){
		System.out.println("");
		for(int i=0 ; i < macierz.getHeight(); i++){
			System.out.println(macierz.get_b_table(i) + " ");
		}
	}
}
