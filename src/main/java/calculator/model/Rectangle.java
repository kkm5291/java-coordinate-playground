package calculator.model;

import java.util.*;

public class Rectangle extends AbstractFigure {

    private static final String ERROR_NOT_RECTANGLE_POINTS = "직사각형을 만들 수 없는 좌표입니다.";

    public Rectangle(List<Point> points) {
        super(points);
        isRectangle(points);
    }

    /**
     * 직사각형 넓이 w * h
     */
    @Override
    public double getArea() {
        List<Point> points = getPoints();
        Map<Integer, Integer> xAxis = createAxisMap(points, true);
        Map<Integer, Integer> yAxis = createAxisMap(points, false);

        int width = calculateDifference(xAxis);
        int height = calculateDifference(yAxis);

        return width * height;
    }

    private int calculateDifference(Map<Integer, Integer> axisMap) {
        ArrayList<Integer> axisValues = new ArrayList<>(axisMap.keySet());
        return Math.abs(axisValues.get(0) - axisValues.get(1));
    }

    @Override
    public boolean hasPoint(int x, int y) {
        return false;
    }

    private void isRectangle(List<Point> points) {
        if (points.size() != 4) {
            throw new IllegalArgumentException(ERROR_NOT_RECTANGLE_POINTS);
        }

        Map<Integer, Integer> xAxis = createAxisMap(points, true);
        Map<Integer, Integer> yAxis = createAxisMap(points, false);

        validateAxis(xAxis);
        validateAxis(yAxis);
    }

    private Map<Integer, Integer> createAxisMap(List<Point> points, boolean isXAxis) {
        Map<Integer, Integer> axisCountMap = new HashMap<>();

        for (Point point : points) {
            int key = getAxisKey(point, isXAxis);
            axisCountMap.put(key, axisCountMap.getOrDefault(key, 0) + 1);
        }

        return axisCountMap;
    }

    private int getAxisKey(Point point, boolean isXAxis) {
        if (isXAxis) {
            return point.getX();
        }
        return point.getY();
    }

    private void validateAxis(Map<Integer, Integer> axis) {
        if (axis.size() != 2) {
            throw new IllegalArgumentException(ERROR_NOT_RECTANGLE_POINTS);
        }

        if (axis.values().stream().anyMatch(value -> value != 2)) {
            throw new IllegalArgumentException(ERROR_NOT_RECTANGLE_POINTS);
        }
    }
}
