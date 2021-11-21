import java.awt.*;

public class Ellipse extends Figure {
    public int semiAxisX = 0;
    public int semiAxisY = 0;
    Point origin = new Point();
    public void draw(Graphics g){
        g.setColor(c);
        if(filled==1){
            g.fillOval(origin.getX(), origin.getY(), semiAxisY, semiAxisX);
        }
        if(filled==0){
        g.drawOval(origin.getX(), origin.getY(), semiAxisY, semiAxisX);
        }
    }
    public void setBoundingBox(int heightBB, int widthBB) {
        setSemiAxisX(widthBB);
        setSemiAxisY(heightBB);
    }
    public void setSemiAxisX(int semiAxisX) {
        this.semiAxisX = semiAxisX;
    }
    public void setSemiAxisY(int semiAxisY) {
        this.semiAxisY = semiAxisY;
    }
    public Ellipse (Point p, Color c){
        super(c,p);
        origin=p;
    }
    public int getPerimeter() {
        return (int) (2*Math.PI*Math.sqrt((semiAxisX^2+semiAxisY^2)/2.0));
    }
    public int getSurface(){
        return (int) (semiAxisX*semiAxisY* Math.PI);
    }
    public String toString() {
        return "semi axis X : "+semiAxisX+",semi axis Y :"+semiAxisY;
    }
}
