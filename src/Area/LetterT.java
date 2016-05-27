package Area;


import java.util.ArrayList;

/**
 * Created by Dante on 24.05.2016.
 */
public class LetterT extends Area {

    private int a;
    private int b;
    private int c;
    private int d;

    public LetterT(int a,int b, int c, int d, int h) {
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
        int e = b - c;
        int f = (a-d)/2;

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if(j == 0 || (i == 0 && j < e) || (i == a - 1 && j < e) || (j == e - 1 && i <= f) || (j < e - 1 && i >= (a - f - 1)) ||
                        ( i == f && j > e - 1) || (i == (a - f - 1) && j > e - 1)) {
                    points[i][j].setIf_edge(true);
                } else if ((i < f && j > e - 1) || (i > a - f - 1 && j > e - 1)) {
                    points[i][j].setIf_edge(true);
                    points[i][j].setValue(0);
                }
            }
        }
    }

    @Override
    public ArrayList get_sizes_array() {
        ArrayList<Integer> al = new ArrayList();
        al.add(a);
        al.add(b);
        al.add(c);
        al.add(d);
        return  al;
    }

}


