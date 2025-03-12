package calculator.model;

import java.util.List;

public class Square extends AbstractFigure {

    public Square(List<Point> points) {
        super(points);
    }

    @Override
    public double getArea() {
        return 0;
    }

    @Override
    public void validateDuplicate(List<Point> points) {

    }

    @Override
    public boolean hasPoint(int x, int y) {
        return false;
    }
}
