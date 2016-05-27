package BorderPoints;

import Area.Area;
import Area.LetterL;
import Area.LetterT;
import Area.Point;
import Area.Rectangle;
import Area.Square;

public class BorderPoints {

	public BorderPoints(){
		
	}
	
	public void setValues(Area area){
		if(area instanceof Square) {
			setSquare(area);
        } else if(area instanceof Rectangle){
        	setRectangle(area);
        } else if(area instanceof LetterL) {
        	setLetterL(area);
        } else {
        	setLetterT(area);
        }
	}
	
	private void setSquare(Area area){
		
	}
	
	private void setRectangle(Area area){
		
	}
	
	private void setLetterL(Area area){
		
	}
	
	private void setLetterT(Area area){
		
	}
}
