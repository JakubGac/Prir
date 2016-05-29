package Matrix;

public class Matrix {
    private int numberOfColumns;
    private int numberOfRows;
    private double values[][];

    public Matrix(int rows, int columns) {
    	this.numberOfRows = rows;
    	this.numberOfColumns = columns;
        values = new double[rows][columns];
    }

    public void setValue(int row, int column, float value) {
        values[row][column] = value;
    }
    
    public double getValue(int row, int column) {
        return values[row][column];
    }

    public synchronized int getRows() {
        return numberOfRows;
    }

    public synchronized int getCols() {
        return numberOfColumns;
    }
    
    public void printMatrix() {
    	for(int i=0 ; i < numberOfRows ; i++){
    		for(int j=0 ; j < numberOfColumns ; j++){
    			System.out.print(values[i][j] + " ");
    		}
    		System.out.println();
    	}
    	System.out.println();
    }
}