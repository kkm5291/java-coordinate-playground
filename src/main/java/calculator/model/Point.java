package calculator.model;

import java.util.Objects;

public class Point {
    public static final String INPUT_VALIDATION_EXCEPTION_MESSAGE = "0 ~ 24 사이의 숫자만 입력이 가능합니다.";
    public static final int MIN_VALUE = 0;
    public static final int MAX_VALUE = 24;
    private static final int SQUARE_OF_TWO = 2;
    public static final String OPEN_BRACKET = "(";
    public static final String CLOSE_BRACKET = ")";
    public static final String DELIMITER = ",";

    private final int x;
    private final int y;

    private Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Point of(String inputCoordinate) {
        String replace = inputCoordinate.replace(OPEN_BRACKET, "")
                .replace(CLOSE_BRACKET, "");

        String[] split = replace.split(DELIMITER);

        int x = Integer.parseInt(split[0].trim());
        int y = Integer.parseInt(split[1].trim());

        validateCoordinate(x, y);
        return new Point(x, y);
    }

    public double calculateDistanceTo(Point point) {
        return Math.sqrt(Math.pow(this.x - point.x, SQUARE_OF_TWO) + Math.pow(this.y - point.y, SQUARE_OF_TWO));
    }

    private static void validateCoordinate(int x, int y) {
        if (!(MIN_VALUE <= x && x <= MAX_VALUE) || !(MIN_VALUE <= y && y <= MAX_VALUE)) {
            throw new IllegalArgumentException(INPUT_VALIDATION_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Point that = (Point) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isSame(int x, int y) {
        return this.x == x && this.y == y;
    }
}
