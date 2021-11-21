import java.awt.*;
public class Circle extends Ellipse{
    public Circle(Point p, Color c) {
        super(p, c);
    }

    @Override
    public void setSemiAxisX(int semiAxis) {
        this.semiAxisX=semiAxis;
    }
    @Override
    public void setSemiAxisY(int semiAxis) {
        this.semiAxisY=semiAxis;
    }

    @Override
    public void setBoundingBox(int heightBB, int widthBB) {
        setSemiAxisX(widthBB);
        setSemiAxisY(widthBB);
    }
}
