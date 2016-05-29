package Matrix;
import Area.*;
import Loading.*;

import java.util.HashMap;

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
        Point[] indexes = new Point[6];
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

        int a_counter = 0;

        while(a_counter != Math.pow(k, 2)) {
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < k; j++) {
                    tmpX = x[i].getX();
                    tmpY = x[i].getY();
                    int main_index = find_index(tmpX, tmpY, k);
                    if( main_index != -1) {
                        A.set_a_table(main_index, j, -4.0);
                        indexes = this.get_interesting_indexes(tmpX, tmpY, area);
                        int other_index = find_matches(k, indexes);
                        if(other_index != -1) {
                            A.set_a_table(other_index, j, );
                        } else {
                            A.set_a_table(other_index, j, .0);
                        }
                    }

                }
            }
        }
    }

    private void check_index(int tmpX, int tmpY) {

    }

    private Point[] get_interesting_indexes(int tmpX, int tmpY, Area area) { //wypelnia tablice okolicznymi punktami
        Point[] indexes = new Point[6];

        indexes[0] = area.getPoint(tmpX - 1, tmpY);
        indexes[1] = area.getPoint(tmpX, tmpY);
        indexes[2] = area.getPoint(tmpX + 1, tmpY);
        indexes[3] = area.getPoint(tmpX, tmpY + 1);
        indexes[4] = area.getPoint(tmpX, tmpY);
        indexes[5] = area.getPoint(tmpX, tmpY - 1);

        return indexes;
    }

    private int find_index(int tmpX, int tmpY, int k) {  //zwraca indeks dopasowanego punktu w tablicy niewiadomych x
        for(int i = 0; i < k; i++) {
            if(x[i].getX() == tmpX && x[i].getY() == tmpY) {
                return i;
            }
        }
        return -1;
    }

    private int find_matches(int k, Point[] indexes ){ //zwraca indeks elementu dopasowego do "obszaru zainteresowan" w tablicy niewiadomych

        for(int i = 0; i < k; i++) {
            for(int j = 0 ; j < indexes.length; j++) {
                if(indexes[j].getX() == x[i].getX() && indexes[j].getY() == x[i].getY()) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void setSize(int my_size) {
        size = my_size;
    }
}
