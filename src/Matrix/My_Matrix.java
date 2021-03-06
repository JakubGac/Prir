package Matrix;

import Area.Point;

import java.util.ArrayList;


public class My_Matrix {

    private int height;
    private int width;
    private double[] b_table;
    private double[][] a_table;
    private ArrayList<Point> x_table;

    public My_Matrix(int height) {
        this.height = height;
        this.b_table = new double[height];
    }

    public My_Matrix(int height, int width) {
        this.height = height;
        this.width = width;
        this.a_table = new double[height][width];
    }

    public My_Matrix(int height, String string) {
        this.height = height;
        this.x_table = new ArrayList<Point>();
    }

    public Point get_x_table(int a) {
        return x_table.get(a);
    }

    public void set_x_table( int a, Point point) {
        x_table.add(a, point);
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
