package calculator.model;

import java.util.List;

public class Line {
    private Coordinate point1;
    private Coordinate point2;

    public Line(List<Coordinate> coordinates) {
        this.point1 = coordinates.get(0);
        this.point2 = coordinates.get(1);
    }

    public double calculateDistance() {
        return point1.calculateDistanceTo(point2);
    }

    public boolean hasPoint(int x, int y) {
        return (point1.getX() == x && point1.getY() == y) || point2.getX() == x && point2.getY() == y;
    }
}
