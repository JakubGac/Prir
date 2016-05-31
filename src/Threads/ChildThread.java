package Threads;

import Matrix.My_Matrix;

public class ChildThread implements Runnable {
	 
	private int id;
    private int row;
    private int column;
    private My_Matrix A;
    private My_Matrix B;
    private My_Matrix C;
    private float result = 0.0f;
    
    public ChildThread(int id, int row, int column, My_Matrix X, My_Matrix Y, My_Matrix Z) {
        this.id = id;
        this.row = row;
        this.column = column;
        this.A = X;
        this.B = Y;
        this.C = Z;
    }
 
    @Override
    public void run() {
    	System.out.println("Working Thread: " + id);
    	sumuj();
    	zmien();
    }
    
    private synchronized void zmien(){
    	C.set_a_table(row, column, result);
    }
    
    private void sumuj(){
    	for(int i=0 ; i < A.getWidth() ; i++){
    		result += A.get_a_table(row, i) * B.get_a_table(i, column);
    	}
    }
}