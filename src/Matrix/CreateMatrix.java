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
        //this.A = new My_Matrix(size, size);
        //this.B = new My_Matrix(size);
        /*for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                this.A.set_a_table(i, j, .0);
            }
        }*/
    }

    public void create_equations(Area area, Function function) {

        int sizeA = area.get_sizes_array().get(0);
        int sizeB = area.get_sizes_array().get(1);
        System.out.println("sizea = "+ sizeA);
        System.out.println("sizeb = " + sizeB);
        //print_matrix(A, B, x);
        int k = 0;
        int tmpX;
        int tmpY;
        HashMap<Point, Double> hm = new HashMap<Point, Double>();

        for(int i = 0; i < sizeA; i++) {
            //System.out.println("tu gdzies\n");
            for(int j = 0; j < sizeB; j++) {
                System.out.println("czy tu? k = " + k + "\n");
                if(!area.getPoint(i, j).getIf_edge()) { //wypelniam macierz x "niewiadomymi"
                    x.set_x_table(k, area.getPoint(i, j));
                    k++;
                }
            }
        }

        this.A = new My_Matrix(k, k);
        this.B = new My_Matrix(k);
        System.out.println(" k = "+ k);

        print_matrix(A, B, x, k);
        for(int i = 0; i < k; i++) {
            tmpX = x.get_x_table(i).getX();
            tmpY = x.get_x_table(i).getY();

            System.out.println("tmpx = "+ tmpX);
            System.out.println("tmpy = " + tmpY);

            B.set_b_table(i, function.get((double)tmpX, (double)tmpY));

            moja_fun(i, tmpX, tmpY, area, hm); // budujemy haszmape
            System.out.println("w forze i i = " + i);
            print_matrix(A, B, x, k);
            fill_A(i, area, hm, k);//wypelniamy finalnie macierz wspolczynnikow
            hm.clear();
        }
        print_matrix(A, B, x, k);
    }


    private void fill_A(int i, Area area, HashMap hm, int k) {

        for(int n = 0; n < k; n++) {
            System.out.println("x.get_x_table(n) =  " + x.get_x_table(n) + " i n = " + n);
            if(hm.containsKey(x.get_x_table(n))) {
                double val = (double)hm.get(x.get_x_table(n));
                System.out.println("val = " + val);
                A.set_a_table(i, n, val * 1/Math.pow(area.getH(), 2));
            } else {
                System.out.println("znowu cos sie zjebalo :( \n");
                continue;
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
        System.out.println(hm);

    }

    public static void setSize(int my_size) {
        size = my_size;
    }

    public My_Matrix get_matrix(char c) {
        if(c == 'a') {
            return A;
        } else if(c == 'b') {
            return B;
        } else if(c == 'x') {
            return x;
        } else {
            System.out.println("nie ma takiego bicia\n");
            return null;
        }
    }


    public void print_matrix(My_Matrix A, My_Matrix B, My_Matrix x, int k) {
        System.out.println("A : ");
        for(int i = 0; i < k; i++) {
            for(int j = 0; j < k; j++) {
                System.out.print(A.get_a_table(i, j) + " ");
            }
            System.out.println();
        }

        System.out.println("B : ");
        for(int i = 0; i < k; i++) {
            System.out.print(B.get_b_table(i)+ " ");
        }
        System.out.println();

        System.out.println("x : ");
        for(int i = 0; i < k; i++) {
            System.out.print(x.get_x_table(i) + " ");
        }
        System.out.println();
    }
}
