package Threads;

import Matrix.My_Matrix;

public class ChildThread2 implements Runnable {
	 
	private int id;
    private int from;
    private int to;
    private My_Matrix A;
    private My_Matrix B;
    private My_Matrix C;
    private double result = 0.0;
    
    public ChildThread2(int id, int from, int to, My_Matrix X, My_Matrix Y, My_Matrix Z) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.A = X;
        this.B = Y;
        this.C = Z;
    }
 
    @Override
    public void run() {
    	System.out.println("Working Thread: " + id);
    	for(int i = from ; i < to ; i++){
    		count(i);
    		changeValue(i);
    		result = 0.0;
    	}
    }
    
    private synchronized void changeValue(int i){
    	C.set_b_table(i, result);
    }
    
    private void count(int j){
    	for(int i=0 ; i < A.getWidth() ; i++){
    		result += A.get_a_table(j, i) * B.get_b_table(i);
    	}
    }
}