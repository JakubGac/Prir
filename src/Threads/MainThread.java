package Threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Jama.*;
import Matrix.My_Matrix;

public class MainThread {
	private Scanner read;
	private List<Integer> eachThread;;
	private Runnable[] runners;
	private Thread[] threads;
	
	
	public MainThread(){
		read = new Scanner(System.in);
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
		
		// creating Matrix with results
		My_Matrix resultsMatrix = new My_Matrix(B.getHeight());
		for(int i=0 ; i < resultsMatrix.getHeight() ; i++){
			resultsMatrix.set_b_table(i, 0);
		}
		
		// creating N - child processes, each child process will receive a number in the resulting matrix 
		int N = resultsMatrix.getHeight();
		
		System.out.println("Jak liczymy? ");
		System.out.println("0 - równolegle");
		System.out.println("1 - sekwencyjnie");
		
		if(Integer.parseInt(read.nextLine()) == 0) {
			System.out.println("Chcesz wybrać ilość wątków?");
			System.out.println("Jeżeli nie, to program stworzy tyle wątków ile jest pozycji w macierz wynikowa :)");
			System.out.println("0 - Wybieram!");
			System.out.println("1 - Rób co chcesz");
			if(Integer.parseInt(read.nextLine()) == 0) {
				System.out.println("Podaj liczbę wątków (musi być liczba całkowita):");
				int a = Integer.parseInt(read.nextLine());
				eachThread = new ArrayList<Integer>();
				int whichThread = 0;
				for(int i=0 ; i < a ; i++){
					eachThread.add(i,0);
				}
				
				while(N > 0){
					eachThread.set(whichThread, eachThread.get(whichThread) + 1);
					whichThread++;
					if(whichThread == a){
						whichThread = 0;
					}
					N--;
				}
				
				runners = new Runnable[a];
				threads = new Thread[a];
				
				whichThread = 0;
				for(int i=0 ; i < a ; i++){
					int from = whichThread;
					for(int j=0 ; j < eachThread.get(i) ; j++){
						whichThread++;
					}
					runners[i] = new ChildThread2(i, from, whichThread, A,B,resultsMatrix);
				}
				
				for(int i=0; i < a ; i++) {
					threads[i] = new Thread(runners[i]);
				}
					    
				for(int i=0; i < a ; i++) {
					threads[i].start();
				}
				
			} else { 
				// starting threads
				int whichThread = 0;
				runners = new Runnable[N];
				threads = new Thread[N];
				
				for(int i=0 ; i < resultsMatrix.getHeight() ; i++){
						runners[whichThread++] = new ChildThread(whichThread,i,A,B,resultsMatrix);
				}
				
				for(int i=0; i < N; i++) {
					threads[i] = new Thread(runners[i]);
				}
					    
				for(int i=0; i<N; i++) {
					threads[i].start();
				}
			}
			// I put to sleep main program for one second to ensure that the threads finish
			try {
				System.out.println("Main thread is snoring for one second ");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}		
		} else {
			for(int i=0 ; i < resultsMatrix.getHeight() ; i++){ 	
				double result = 0.0;
				for(int j=0 ; j < A.getWidth() ; j++){
			    	result += A.get_a_table(i,j) * B.get_b_table(j);
			    }
				resultsMatrix.set_b_table(i, result);
			}	
		}
		
		// let's print the results :)
		System.out.println("\nMatrix with results:");
		printMatrix(resultsMatrix);
	}
	
	private void printMatrix(My_Matrix macierz){
		System.out.println("");
		for(int i=0 ; i < macierz.getHeight(); i++){
			System.out.println(i+1 + ". " + macierz.get_b_table(i) + " ");
		}
	}
}
