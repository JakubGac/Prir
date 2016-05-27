package Condition;

/**
 * Created by Dante on 26.05.2016.
 */
public class Dirichlet implements Condition {
	
	private boolean IfX;
	private boolean IfY;
	private int x;
	private int y;
	
	public Dirichlet(String value){
		if(value.charAt(1) == 'x' || value.charAt(1) == 'X'){
			setX(Character.getNumericValue(value.charAt(2)));
		} else {
			setY(Character.getNumericValue(value.charAt(2)));
		}
	}

	private void setX (int value1){
		x = value1;
		y = 99999;
		IfX = true;
		IfY = false;
	}
	
	private void setY (int value1){
		y = value1;
		x = 99999;
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

	@Override
	public String toString(){
		if(x != 99999){
			return Integer.toString(x);
		} else {
			return Integer.toString(y);
		}
		
	}
}
