package Area;


import java.util.ArrayList;

/**
 * Created by Dante on 24.05.2016.
 */
public class LetterT extends Area {

    private int b;
    private int c;
    private int e;
    private int f;
    private int all;

    public LetterT(int b,int c, int e, int f, int h) {
        this.b = b;
        this.c = c;
        this.e = e;
        this.f = f;
        this.h = h;
        this.all = c + e;
        super.fill_this_shit_up(this);
    }



    public int getB() {
        return b;
    }

    public int getAll() {
        return all;
    }

    public int getC() {
        return c;
    }

    public int getE() {
        return e;
    }

    public int getF() {
        return f;
    }

    public void fill_edges(Point[][] points) {
        int all = c + e;
        int d = (b - f )/ 2;


        for (int i = 0; i < all; i++) {
            for (int j = 0; j < b; j++) {
                if(i == all - 1 || (i >= e && j == b - 1) || (i >= e && j == 0) || (i == e && j >= f + d) || (i == e && j < d) ||
                        (j == f + d - 1 && i <= e) || (j == d && i <= e) || (i == 0 && j >= d && j < f + d)) {
                    points[i][j].setIf_edge(true);
                } else if ((i < e && j < d) || (i < e && j >= f + d)) {
                    points[i][j].setIf_edge(true);
                    points[i][j].setValue(0);
                }
            }
        }
    }

    @Override
    public ArrayList<Integer> get_sizes_array() {
        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(b);
        al.add(c);
        al.add(e);
        al.add(f);
        return  al;
    }

}


