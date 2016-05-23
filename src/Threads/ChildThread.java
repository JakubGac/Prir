package Threads;

public class ChildThread implements Runnable {
	 
    private int id;
    
    public ChildThread(int id) {
        this.id = id;
    }
 
    @Override
    public void run() {
    	System.out.println("działa wątek: " + id);
    }
}