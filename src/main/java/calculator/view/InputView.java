package calculator.view;

import calculator.model.Point;
import calculator.model.Line;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);
    public static final String INPUT_COORDINATE = "좌표를 입력하세요.";
    public static final String ERROR_INVALID_INPUT_MESSAGE = "올바르지 않은 입력값입니다.";
    public static final String COORDINATE_SEPARATOR = "-";


    private InputView() {}

    public static Line inputCoordinate() {
        System.out.println(INPUT_COORDINATE);
        return inputCoordinate(sc.nextLine());
    }

    private static Line inputCoordinate(String input) {
        try {
            input = input.replace(" ", "");
            checkEmptyOf(input);
            checkPatternOf(input);
            return new Line(generatePoints(input));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return inputCoordinate();
        }
    }

    protected static List<Point> generatePoints(String input) {
        String[] inputPoints = input.split(COORDINATE_SEPARATOR);

        List<Point> points = new ArrayList<>();

        for (String coordinate : inputPoints) {
            points.add(Point.of(coordinate));
        }
        return points;
    }

    protected static void checkEmptyOf(String input) {
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException(ERROR_INVALID_INPUT_MESSAGE);
        }
    }


    protected static void checkPatternOf(String input) {
        String regex = "\\(\\d+,\\d+\\)-\\(\\d+,\\d+\\)";
        if (!input.matches(regex)) {
            throw new IllegalArgumentException(ERROR_INVALID_INPUT_MESSAGE);
        }
    }
}
