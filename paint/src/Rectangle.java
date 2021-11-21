import java.awt.*;
public class Rectangle extends Figure{
    Point origin = new Point();
    public Rectangle(Point p, Color c) {
        super(c,p);
        length=0;
        width=0;
        origin=p;
    }
    public int length;
    public int width;
    public void setLength(int length) {
        this.length = length;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public void draw(Graphics g){
        g.setColor(c);
        if(filled==1) {
            g.fillRect(origin.getX(), origin.getY(), length, width);
        }
        if(filled==0){
            g.drawRect(origin.getX(), origin.getY(), length, width);
        }
    }
    public void setBoundingBox(int heightBB, int widthBB){
        setLength(heightBB);
        setWidth(widthBB);
    }
    public int getLength() {
        return length;
    }
    public int getWidth() {
        return width;
    }
    public int getPerimeter(){
        return 2*length+2*width;
    }
    public int getSurface(){
        return length*width;
    }
    public String toString() {
        return "length : "+length+",width : "+width;
    }
}
