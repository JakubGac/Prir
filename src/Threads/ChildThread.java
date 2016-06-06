package Threads;

import Matrix.My_Matrix;

public class ChildThread implements Runnable {
	 
	private int id;
    private int row;
    private My_Matrix A;
    private My_Matrix B;
    private My_Matrix C;
    private double result = 0.0;
    
    public ChildThread(int id, int row, My_Matrix X, My_Matrix Y, My_Matrix Z) {
        this.id = id;
        this.row = row;
        this.A = X;
        this.B = Y;
        this.C = Z;
    }
 
    @Override
    public void run() {
    	System.out.println("Working Thread: " + id);
    	count();
    	changeValue();
    }
    
    private synchronized void changeValue(){
    	C.set_b_table(row, result);
    }
    
    private void count(){
    	for(int i=0 ; i < A.getWidth() ; i++){
    		result += A.get_a_table(row, i) * B.get_b_table(i);
    	}
    }
}