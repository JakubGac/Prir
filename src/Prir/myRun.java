package Prir;

public class myRun implements Runnable {
	 
    private int id;
    
    public myRun(int id) {
        this.id = id;
    }
 
    @Override
    public void run() {
    	System.out.println("działa wątek: " + id);
    }
}