package calculator.model;

public class Coordinate {
    public static final String INPUT_VALIDATION_EXCEPTION_MESSAGE = "0 ~ 24 사이의 숫자만 입력이 가능합니다.";
    public static final int MIN_VALUE = 0;
    public static final int MAX_VALUE = 24;


    private final int x;
    private final int y;

    private Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    private static void validateCoordinate(int x, int y) {
        if (!(MIN_VALUE <= x && x <= MAX_VALUE) || !(MIN_VALUE <= y && y <= MAX_VALUE)) {
            throw new IllegalArgumentException(INPUT_VALIDATION_EXCEPTION_MESSAGE);
        }
    }

    public static Coordinate create(int x, int y) {
        validateCoordinate(x, y);
        return new Coordinate(x, y);
    }

    public double calculateDistanceTo(Coordinate coordinate) {
        return Math.sqrt(Math.pow(this.x - coordinate.x, SQUARE_OF_TWO) + Math.pow(this.y - coordinate.y, SQUARE_OF_TWO));
    }
}
