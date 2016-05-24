package Area;

/**
 * Created by Dante on 24.05.2016.
 */
public class Rectangle extends Area {

    private int a;
    private int b;

    public Rectangle(int a, int b, int h) {
        this.a = a;
        this.b = b;
        this.h = h;
        super.fill_this_shit_up(this);
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }


}
