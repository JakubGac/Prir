package Matrix;

/**
 * Created by Dante on 29.05.2016.
 */
public class My_Matrix {

    private int height;
    private int width;
    private double[] b_table;
    private double[][] a_table;

    public My_Matrix(int height) {
        this.height = height;
        this.b_table = new double[height];
    }

    public My_Matrix(int height, int width) {
        this.height = height;
        this.width = width;
        this.a_table = new double[height][width];
    }

    public double get_a_table(int a, int b) {
        return a_table[a][b];
    }

    public double get_b_table(int a) {
        return b_table[a];
    }

    public void set_a_table(int a, int b, double value) {
        a_table[a][b] = value;
    }

    public void set_b_table(int a, double value) {
        b_table[a] = value;
    }
    
    public void set_full_a_table(double[][] a_table){
    	this.a_table = a_table;
    }
    
    public int getHeight(){
    	return height;
    }
    
    public int getWidth(){
    	return width;
    }
    
    public double[][] get_full_a_table(){
    	return a_table;
    }
}
