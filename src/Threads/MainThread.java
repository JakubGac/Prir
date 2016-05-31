package Threads;

import Jama.*;
import Matrix.My_Matrix;

public class MainThread {
	
	public MainThread(){
		
	}
	
	public void count(My_Matrix A, My_Matrix B, My_Matrix C) throws Exception{
		inverse(A);
		multiply(A,B,C);
	}
	
	private void inverse(My_Matrix A){
		Matrix tmp = new Matrix(A.get_full_a_table());
		tmp = tmp.inverse();
		A.set_full_a_table(tmp.getArray());
	}
	
	private void multiply(My_Matrix A, My_Matrix B, My_Matrix C) throws Exception{
		// chceck if multiply is possible
		if(A.getWidth() != B.getHeight()){
			throw new Exception("Mnożenie tych macierzy nie jest możliwe!");
		}
		
		// creating N - child processes, each child process will receive a number in the resulting matrix 
		int N = A.getWidth() * B.getHeight();
		
		// starting threads
		int whichThread = 0;
		Runnable[] runners = new Runnable[N];
		Thread[] threads = new Thread[N];
		
		for(int i=0 ; i < C.getHeight() ; i++){
			for(int j=0 ; j < C.getWidth() ; j++){
				runners[whichThread++] = new ChildThread(whichThread,i,j,A,B,C);
			}
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
		printMatrix(C);
	}
	
	private void printMatrix(My_Matrix macierz){
		System.out.println("");
		for(int i=0 ; i < macierz.getHeight(); i++){
			for(int j=0 ; j < macierz.getWidth() ; j++){
				System.out.print(macierz.get_a_table(i, j) + " ");
			}
			System.out.println("");
		}
	}
}
