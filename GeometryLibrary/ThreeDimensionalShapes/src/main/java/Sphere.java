public class Sphere {
    private double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    public double getVolume() {
        return (4.0 / 3.0) * Math.PI * radius * radius * radius;
    }

    public double getSurfaceArea() {
        return 4 * Math.PI * radius * radius;
    }
}
