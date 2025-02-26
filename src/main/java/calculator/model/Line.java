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
}
