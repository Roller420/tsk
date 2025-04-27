import org.roller.geometry.figures.Figure;
public class GeoUtils {
    public static boolean compareByArea(Figure figure1, Figure figure2) {
        return figure1.getArea() == figure2.getArea();
    }

    public static boolean compareByPerimeter(Figure figure1, Figure figure2) {
        return figure1.getPerimeter() == figure2.getPerimeter();
    }

}
