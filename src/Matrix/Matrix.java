package Matrix;
import Area.*;
import Loading.*;
/**
 * Created by Dante on 26.05.2016.
 */
public class Matrix {

    private Point[] x;
    private Double[][] A;
    private Double[] B;
    private static int size;

    public Matrix() {
        this.x = new Point[size];
        this.A = new Double[size][size];
        this.B = new Double[size];
    }

    public void fill_matrix(Area area, Function function) {

        int sizeA = (int)area.get_sizes_array().get(0);
        int sizeB = (int)area.get_sizes_array().get(1);
        int k = 0;

        for(int i = 0; i < sizeA; i++) {
            for(int j = 0; j < sizeB; j++) {
                if(area.getPoint(i, j).getIf_edge() == true) { //wypelniam macierz x "niewiadomymi"
                    x[k++] = area.getPoint(i, j);
                }
            }
        }

        if (k == 0) {System.out.println("podaj lepsze wymiary gupi uzytkowniku\n"); return;}

        for(int i = 0; i < k; i++) {
            B[i] = function.get((double)x[i].getX(), (double)x[i].getY()) - 4/Math.pow(area.getH(), 2); //wypelniam macierz prawych stron danymi
        }

        for(int i = 0; i < k; i++) {
            for(int j = 0; j < k; j++) {

            }
        }
    }


    public static void setSize(int my_size) {
        size = my_size;
    }
}
