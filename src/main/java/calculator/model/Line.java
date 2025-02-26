package calculator.model;

public class Line {
    private Coordinate point1;
    private Coordinate point2;

    public Line(Coordinate point1, Coordinate point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    public double calculateDistance() {
        return point1.calculateDistanceTo(point2);
    }
}
