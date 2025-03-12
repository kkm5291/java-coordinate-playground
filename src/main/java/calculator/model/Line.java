package calculator.model;

import java.util.HashSet;
import java.util.List;

public class Line {
    public static final String ERROR_DUPLICATE_POINTS_FOUND = "좌표에 중복값이 존재합니다.";

    private Point point1;
    private Point point2;

    public Line(List<Point> points) {
        validateDuplicate(points);
        this.point1 = points.get(0);
        this.point2 = points.get(1);
    }

    public double calculateDistance() {
        return point1.calculateDistanceTo(point2);
    }

    public boolean hasPoint(int x, int y) {
        return (point1.getX() == x && point1.getY() == y) || point2.getX() == x && point2.getY() == y;
    }
    
    private void validateDuplicate(List<Point> points) {
        if (points.size() != new HashSet<>(points).size()) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_POINTS_FOUND);
        }
    }
}
