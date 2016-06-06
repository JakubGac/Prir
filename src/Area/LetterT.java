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

    public int getC() {
        return c;
    }

    public int getD() {
        return d;
    }

    public void fill_edges(Point[][] points) {
        int g = (b - d )/ 2;


        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if(i == a - 1 || (i >= c && j == b - 1) || (i >= c && j == 0) || (i == c && j >= d + g) || (i == c && j < g) ||
                        (j == d + g - 1 && i <= c) || (j == g && i <= c) || (i == 0 && j >= g && j < d + g)) {
                    points[i][j].setIf_edge(true);
                } else if ((i < c && j < g) || (i < c && j >= g + d) ) {
                    points[i][j].setIf_edge(true);
                    points[i][j].setValue(0);
                }
            }
        }
    }

    @Override
    public ArrayList<Integer> get_sizes_array() {
        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(a);
        al.add(b);
        al.add(c);
        al.add(d);
        return  al;
    }

}


