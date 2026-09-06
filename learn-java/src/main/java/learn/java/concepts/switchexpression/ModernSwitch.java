package learn.java.concepts.switchexpression;

public class ModernSwitch {

    public record Circle(double radius) {}
    public record Square(double side) {}

    static void main() {
        Object shape = new Circle(5.0);

        double area = switch (shape) {
            case Circle c -> Math.PI * c.radius() * c.radius();
            case Square s -> s.side() * s.side();
            default -> throw new IllegalArgumentException("Unknown shape");
        };

        IO.println(area);
    }

}
