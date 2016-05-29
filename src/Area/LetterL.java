package Area;

import java.util.ArrayList;

/**
 * Created by Dante on 24.05.2016.
 */
public class LetterL extends Area{

    private int a;
    private int b;
    private int c;
    private int d;

    public LetterL(int a,int b, int c, int d, int h) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.h = h;
        super.fill_this_shit_up(this);
    }


    public int getB() {
        return b;
    }

    public int getA() {
        return a;
    }

    public int getD() {
        return d;
    }

    public int getC() {
        return c;
    }

    public void fill_edges(Point[][] points) {
        int e = b - d;
        //int f = a - c;

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if(i == 0 || (i == b  - 1 && j > c - 1) || (i == e - 1 && j < c) || (j == 0 && i < e) || (j == c && i >= e ) || j == a - 1 ) {
                    points[i][j].setIf_edge(true); //ustawiamy flage brzegowosci na TRUE
                } else if( i > e - 1 && j < c - 1) {
                    points[i][j].setIf_edge(true); // ustawiamy flage "dla porzadku" dla obszaru lezacego poza litera L
                    points[i][j].setValue(0);
                }
            }
        }
    }

    @Override
    public ArrayList<Integer> get_sizes_array() {
        ArrayList<Integer> all = new ArrayList<Integer>();
        all.add(a);
        all.add(b);
        all.add(c);
        all.add(d);
        return  all;
    }

}
