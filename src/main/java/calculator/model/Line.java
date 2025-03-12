package calculator.model;

import java.util.HashSet;
import java.util.List;

public class Line extends AbstractFigure {

    public Line(List<Point> points) {
        super(points);
    }

    @Override
    public double getArea() {
        return getPoints().get(0).calculateDistanceTo(getPoints().get(1));
    }

    @Override
    public boolean hasPoint(int x, int y) {
        return (getPoints().get(0).getX() == x && getPoints().get(0).getY() == y) || getPoints().get(1).getX() == x && getPoints().get(1).getY() == y;
    }

    @Override
    public void validateDuplicate(List<Point> points) {
        if (points.size() != new HashSet<>(points).size()) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_POINTS_FOUND);
        }
    }
}
