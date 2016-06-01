package Prir;

import BorderPoints.BorderPoints;
import Loading.DataLoading;
import Matrix.CreateMatrix;
import Matrix.My_Matrix;
import Threads.MainThread;

public class Main {

	public static void main(String []args) throws Exception {
		
		// code for data loading
		DataLoading data = new DataLoading();
		// reading functions
		data.FunctionLoading();
		// reading area
		data.AreaLoading();
		// reading conditions
		data.ConditionLoading();
		// since this moment, reading is all done

		// code for setting values to the border points
		BorderPoints borderPoints = new BorderPoints();
		// so, let's set them!
		borderPoints.setValues(data.getArea(), data.getConditionsList());
		
		// now it's the time to create and fill up matrixes
		CreateMatrix createMatrix = new CreateMatrix();
		// create_equations sie wywala
		createMatrix.create_equations(data.getArea(), data.getFunction());
	
		// code for counting results
		MainThread mainThread = new MainThread();
		mainThread.count(createMatrix.get_matrix('a'), createMatrix.get_matrix('b')); 
		
	}
}