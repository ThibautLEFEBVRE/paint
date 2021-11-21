import java.awt.*;
import java.io.Serializable;

public abstract class Figure implements Serializable {
    protected Color c;
    protected Point origin;
    protected static int filled;
    public static void setFilled(int fill) {
        filled = fill;
    }
    public abstract void setBoundingBox (int heightBB, int widthBB);
    public abstract void draw (Graphics g);
    public abstract int getPerimeter();
    public abstract int getSurface();
    public Figure(Color c,Point p){
        this.c = c;
        origin = p;
    }
    @Override
    public abstract String toString();
    }