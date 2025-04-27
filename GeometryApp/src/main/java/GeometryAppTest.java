import figures.Circle;
import org.roller.geometry.figures.*;


public class GeometryAppTest {
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        Circle circle2 = new Circle(5);
        Triangle triangle = new Triangle(4, 4, 4);
        Rectangle rectangle = new Rectangle(4, 7);

        Cube cube = new Cube(56);
        Sphere sphere = new Sphere(52);

        System.out.println(sphere.getVolume());
        System.out.println(cube.getSurfaceArea());

        System.out.println(GeoUtils.compareByArea(circle, circle2));
        System.out.println(GeoUtils.compareByArea(rectangle, triangle));

        System.out.println(circle.getArea() + " " + circle.getPerimeter());
        System.out.println(rectangle.getArea() + " " + rectangle.getPerimeter());
        System.out.println(triangle.getArea() + " " + triangle.getPerimeter());

        triangle.getArea();
    }


}
