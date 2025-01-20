package calculator.line;

public class Coordinate {
    public static final int SQUARE_OF_TWO = 2;

    private final int x;
    private final int y;

    private Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Coordinate create(int x, int y) {
        return new Coordinate(x, y);
    }

    public double calculateDistanceTo(Coordinate coordinate) {
        return Math.sqrt(Math.pow(this.x - coordinate.x, SQUARE_OF_TWO) + Math.pow(this.y - coordinate.y, SQUARE_OF_TWO));
    }
}
