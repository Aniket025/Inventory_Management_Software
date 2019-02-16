import java.lang.*;


class Point
{
    int x,y;
    void setPoint(int a , int b )
        {
            x=a;
            y=b;
        }
}
//definition of another class. This is main class
class PointsDemo
{
    //float distance;  Error: non-static variable referenced from static main
    static float distance;
    public static void main(String args[]){
        Point p1 = new Point();
        Point p2 = p1;
        Point p3 = new Point();
        Point p4 = new Point();
        p1.setPoint (5 , 10);
        p2.setPoint (15 , 20);
        p3.setPoint (20 , 30);
        p4.setPoint (30 , 40);
       
        System.out.println("X1 = " + p1.x + " Y1 = " + p1.y);
        System.out.println("X2 = " + p2.x + " Y2 = " + p2.y);
        int dx = p3.x - p4.x;
        int dy = p3.y - p4.y;
        //distance = Math.sqrt (dx*dx + dy*dy ); Error: lossy conversion from double to float
        distance = (float)Math.sqrt (dx*dx + dy*dy );  //typecast
        System.out.println( " Distance = " + distance );
    }
}