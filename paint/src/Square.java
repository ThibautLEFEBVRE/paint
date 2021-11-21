import java.awt.*;

public class Square extends Rectangle{
    public Square(Point p, Color c) {
        super(p,c);
    }

    @Override
    public void setLength(int side) {
        length=side;
        width=side;
    }
    @Override
    public void setWidth(int side) {
        length=side;
        width=side;
    }
    @Override
    public void setBoundingBox(int heightBB, int widthBB) {
        setWidth(widthBB);
        setLength(heightBB);
    }
}