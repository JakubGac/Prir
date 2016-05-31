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
		printMatrix(createMatrix.get_matrix('a'));
		printMatrix(createMatrix.get_matrix('b'));
		printMatrix(createMatrix.get_matrix('c'));
	}
	
	private static void printMatrix(My_Matrix macierz){
		System.out.println("");
		for(int i=0 ; i < macierz.getHeight(); i++){
			for(int j=0 ; j < macierz.getWidth() ; j++){
				System.out.print(macierz.get_a_table(i, j) + " ");
			}
			System.out.println("");
		}
	}
}