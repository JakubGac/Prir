package Matrix;
import Area.*;
import Loading.*;
/**
 * Created by Dante on 26.05.2016.
 */
public class CreateMatrix {

    private Point[] x;
    private Matrix A;
    private Matrix B;
    private static int size;

    public CreateMatrix() {
        this.x = new Point[size];
        this.A = new Matrix(size, size);
        this.B = new Matrix(size);
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                this.A.set_a_table(i, j, .0);
            }
        }
    }

    public void fill_matrix(Area area, Function function) {

        int sizeA = area.get_sizes_array().get(0);
        int sizeB = area.get_sizes_array().get(1);
        int k = 0;
        int tmpX;
        int tmpY;

        for(int i = 0; i < sizeA; i++) {
            for(int j = 0; j < sizeB; j++) {
                if(area.getPoint(i, j).getIf_edge() == true) { //wypelniam macierz x "niewiadomymi"
                    x[k++] = area.getPoint(i, j);
                }
            }
        }

        if (k == 0) {System.out.println("podaj lepsze wymiary gupi uzytkowniku\n"); return;}

        for(int i = 0; i < k; i++) {
            B.set_b_table(i, function.get((double)x[i].getX(), (double)x[i].getY()));  //wypelniam macierz prawych stron danymi
        }

        for(int i = 0; i < k; i++) {
            for(int j = 0; j < k; j++) {

            }
        }
    }

    private void check_index(int tmpX, int tmpY) {


    }


    public static void setSize(int my_size) {
        size = my_size;
    }
}
