package Matrix;
import Area.*;
import Loading.*;
import java.util.HashMap;


public class CreateMatrix {

    private My_Matrix x;
    private My_Matrix A;
    private My_Matrix B;
    private static int size;

    public CreateMatrix() {
        this.x = new My_Matrix(size, "dupa");
        this.A = new My_Matrix(size, size);
        this.B = new My_Matrix(size);
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                this.A.set_a_table(i, j, .0);
            }
        }
    }

    public void create_equations(Area area, Function function) {

        int sizeA = area.get_sizes_array().get(0);
        int sizeB = area.get_sizes_array().get(1);
        int k = 0;
        int tmpX;
        int tmpY;
        HashMap<Point, Double> hm = new HashMap<Point, Double>();

        for(int i = 0; i < sizeA; i++) {
            for(int j = 0; j < sizeB; j++) {
                if(area.getPoint(i, j).getIf_edge()) { //wypelniam macierz x "niewiadomymi"
                    x.set_x_table(k++, area.getPoint(i, j));
                }
            }
        }

        for(int i = 0; i < k; i++) {
            tmpX = x.get_x_table(i).getX();
            tmpY = x.get_x_table(i).getY();

            B.set_b_table(i, function.get((double)tmpX, (double)tmpY));

            moja_fun(i,  tmpX, tmpY, area, hm); // budujemy haszmape
            fill_A(i, area, hm);                //wypelniamy finalnie macierz wspolczynnikow
        }
    }

    private void fill_A(int i, Area area, HashMap hm) {

        for(int n = 0; n < size; n++) {
            if(hm.containsKey(x.get_x_table(n))) {
                double val = (double)hm.get(x.get_x_table(n));
                A.set_a_table(n, i, val * 1/Math.pow(area.getH(), 2));
            } else {
                System.out.println("znowu cos sie zjebalo :( \n");
                return;
            }
        }
    }

    @SuppressWarnings("unchecked")
    private void moja_fun(int i, int tmpX, int tmpY,  Area area, HashMap hm) {

        if (area.getPoint(tmpX - 1, tmpY).getIf_edge()) {  // == true
            B.set_b_table(i, B.get_b_table(i) - area.getPoint(tmpX - 1, tmpY).getValue() / Math.pow(area.getH(), 2));
        } else {
            hm.put(area.getPoint(tmpX - 1, tmpY), 1.0);
        }

        hm.put(area.getPoint(tmpX, tmpY), -4.0);

        if (area.getPoint(tmpX + 1, tmpY).getIf_edge()) {
            B.set_b_table(i, B.get_b_table(i) - area.getPoint(tmpX + 1, tmpY).getValue() / Math.pow(area.getH(), 2));
        } else {
            hm.put(area.getPoint(tmpX + 1, tmpY), 1.0);
        }

        if (area.getPoint(tmpX, tmpY + 1).getIf_edge()) {
            B.set_b_table(i, B.get_b_table(i) - area.getPoint(tmpX, tmpY + 1).getValue() / Math.pow(area.getH(), 2));
        } else {
            hm.put(area.getPoint(tmpX, tmpY + 1), 1.0);
        }

        if (area.getPoint(tmpX, tmpY - 1).getIf_edge()) {
            B.set_b_table(i, B.get_b_table(i) - area.getPoint(tmpX, tmpY - 1).getValue() / Math.pow(area.getH(), 2));
        } else {
            hm.put(area.getPoint(tmpX, tmpY - 1), 1.0);
        }

    }

    public static void setSize(int my_size) {
        size = my_size;
    }

   /* public void print_matrix_equation() {

        for(int i = 0; i < size; i++) {
            System.out.println("|");
            for (int j = 0; j < size; j++) {
                System.out.println(A.get_a_table(i, j) + " ");
                System.out.println("*   |   ");
                System.out.println(x[i]);
            }
            System.out.println("|\n");
        }
    }*/
}
