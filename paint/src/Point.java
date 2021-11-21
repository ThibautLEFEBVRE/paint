import java.io.Serializable;

public class Point implements Serializable {
    public int X;
    public int Y;
    public Point(){
        X=0;
        Y=0;
    }
    public Point(int a,int b){
        X=a;
        Y=b;
    }
    public int getX(){
        return X;
    }
    public int getY() {
        return Y;
    }
    @Override
    public String toString() {
        return "("+X+","+Y+")";
    }

}
