package Area;

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

}
