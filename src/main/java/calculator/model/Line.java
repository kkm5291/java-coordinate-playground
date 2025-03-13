package calculator.model;

import java.util.List;

public class Line extends AbstractFigure {

    public Line(List<Point> points) {
        super(points);
    }

    @Override
    public double getArea() {
        return getPoints().get(0).calculateDistanceTo(getPoints().get(1));
    }
}
