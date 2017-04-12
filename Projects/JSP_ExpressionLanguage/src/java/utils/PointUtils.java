package utils;

import java.io.IOException;
import java.util.Random;
import javax.servlet.jsp.PageContext;

public class PointUtils {

    public static Point createRandomPoint() {
        Point p = new Point();
        
        Random r = new Random();
        p.setX( r.nextInt(100) );
        p.setY( r.nextInt(100) );
        
        return p;
    }
    
    public static void movePoint(Point p, int newX, int newY) {
        p.setX(newX);
        p.setY(newY);
    }

    public static void createPoint(int x, int y, String attName, 
            PageContext pageContext) {
        
        Point p = new Point();
        p.setX(x);
        p.setY(y);
        
        pageContext.setAttribute(attName, p);
    }
    
    public static void copyAttributeName(Point p, String attName, PageContext pageContext) {
        pageContext.setAttribute(attName, p);
    }
}
