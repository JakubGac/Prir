package BorderPoints;

import java.util.ArrayList;
import java.util.List;

import Area.Area;
import Area.LetterL;
import Area.Rectangle;
import Area.Square;
import Condition.Condition;

public class BorderPoints {

	private ArrayList<Integer> areaDimensions;
	private List<Condition> conditions;
	
	public BorderPoints(){}
	
	public void setValues(Area area, List<Condition> list){
		this.areaDimensions = area.get_sizes_array();
		this.conditions = list;
		if(area instanceof Square) {
			setSquareOrRectangle(area);
        } else if(area instanceof Rectangle){
        	setSquareOrRectangle(area);
        } else if(area instanceof LetterL) {
        	setLetterL(area);
        } else {
        	setLetterT(area);
        }
	}
	
	private void setSquareOrRectangle(Area area){
		// left and right
		for(int i=0 ; i < areaDimensions.get(0); i++){
			area.getPoint(i, 0).setValue((double)conditions.get(0).getValue());
			area.getPoint(i, areaDimensions.get(1) - 1).setValue((double)conditions.get(2).getValue());
		}
		// up and down
		for(int i=0 ; i < areaDimensions.get(1) ; i++){
			area.getPoint(0, i).setValue((double)conditions.get(1).getValue());
			area.getPoint(areaDimensions.get(0) - 1, i).setValue((double)conditions.get(3).getValue());
		}
	}
	
	private void setLetterL(Area area){
		// first condition
		for(int i=0 ; i < areaDimensions.get(0) ; i++){
			area.getPoint(i, 0).setValue((double)conditions.get(0).getValue());
		}
		// second condition
		for(int i=0 ; i < areaDimensions.get(1) - areaDimensions.get(3); i++){
			area.getPoint(0, i).setValue((double)conditions.get(1).getValue());
		}
		// third condition
		for(int i=0 ; i <= areaDimensions.get(2) ; i++){
			area.getPoint(i, areaDimensions.get(1) - areaDimensions.get(3) - 1).setValue((double)conditions.get(2).getValue());
		}
		// fourth condition
		for(int i = areaDimensions.get(2) ; i < areaDimensions.get(1); i++ ){
			area.getPoint(areaDimensions.get(2), i).setValue((double)conditions.get(3).getValue());
		}
		// fifth condition
		for(int i = areaDimensions.get(2) ; i < areaDimensions.get(0) ;  i++){
			area.getPoint(i,areaDimensions.get(1) -1).setValue((double)conditions.get(4).getValue());
		}
		// sixth condition
		for(int i=0 ; i < areaDimensions.get(1) ; i++){
			area.getPoint(areaDimensions.get(0) - 1, i).setValue((double)conditions.get(5).getValue());
		}
	}
	
	private void setLetterT(Area area){
		// first and third condition
		for(int i=0 ; i < areaDimensions.get(0) - areaDimensions.get(2); i++){
			area.getPoint(i, 0).setValue((double)conditions.get(0).getValue());
			area.getPoint(i, (areaDimensions.get(1)-1)).setValue((double)conditions.get(2).getValue());
		}
		// second condition
		for(int i=0 ; i < areaDimensions.get(1) ; i++){
			area.getPoint(0, i).setValue((double)conditions.get(1).getValue());
		}
		// fourth condition
		for(int i = areaDimensions.get(1) - ((areaDimensions.get(1) - areaDimensions.get(3)) / 2) -1; i < areaDimensions.get(1) ; i++){
			area.getPoint(areaDimensions.get(0) - areaDimensions.get(2) -1, i).setValue((double)conditions.get(3).getValue());
		}
		// fifth condition
		for(int i = areaDimensions.get(0) - areaDimensions.get(2) ; i < areaDimensions.get(0) ; i++){
			area.getPoint(i, areaDimensions.get(1) - ((areaDimensions.get(1) - areaDimensions.get(3)) / 2) -1 ).setValue((double)conditions.get(4).getValue());
		}
		// sixth condition
		for(int i = ((areaDimensions.get(1) - areaDimensions.get(3)) / 2 ) ; 
			i < ( ((areaDimensions.get(1) - areaDimensions.get(3)) / 2 ) +  areaDimensions.get(3)) ; i++){
			area.getPoint(areaDimensions.get(0) -1 , i).setValue((double)conditions.get(5).getValue());
		}
		// seventh condition
		for(int i = areaDimensions.get(0) - areaDimensions.get(2) ; i < areaDimensions.get(0) ; i++ ){
			area.getPoint(i, (areaDimensions.get(1) - areaDimensions.get(3)) / 2).setValue((double)conditions.get(6).getValue());
		}
		// eighth condition
		for(int i=0 ; i <= (areaDimensions.get(1) - areaDimensions.get(3)) / 2 ; i++){
			area.getPoint(areaDimensions.get(0) - areaDimensions.get(2) -1, i).setValue((double)conditions.get(3).getValue());
		}		
	}
}
