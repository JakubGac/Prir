package Prir;

import BorderPoints.BorderPoints;
import Loading.DataLoading;

public class Main {

	public static void main(String []args) throws Exception {
		
		// code for data loading
		DataLoading data = new DataLoading();
		// reading functions
		//data.FunctionLoading();
		// reading area
		data.AreaLoading();
		// reading conditions
		data.ConditionLoading();
		// since this moment, reading is all done

		// code for setting values to the border points
		BorderPoints borderPoints = new BorderPoints();
		// so, let's set them!
		borderPoints.setValues(data.getArea(), data.getConditionsList());
	}
}