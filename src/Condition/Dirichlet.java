package Condition;

/**
 * Created by Dante on 26.05.2016.
 */
public class Dirichlet implements Condition {
	
	private boolean IfX;
	private boolean IfY;
	private int x;
	private int y;
	
	public Dirichlet(){
		IfX = false;
		IfY = false;
	}
	
	public void setX (int value1){
		x = value1;
		IfX = true;
		IfY = false;
	}
	
	public void setY (Boolean value, int value1){
		y = value1;
		IfX = true;
		IfX = false;
	}
	
	@Override
	public int getValue(){
		if(IfX){
			return x;
		} else {
			return y;
		}
	}
	
	public boolean getIfX(){
		return IfX;
	}
	
	public boolean getIfY(){
		return IfY;
	}
}
