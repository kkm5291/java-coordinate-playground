package calculator.view;

import calculator.model.Coordinate;
import calculator.model.Line;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);
    public static final String INPUT_COORDINATE = "좌표를 입력하세요.";
    public static final String ERROR_INVALID_INPUT_MESSAGE = "올바르지 않은 입력값입니다.";
    public static final String COORDINATE_SEPARATOR = "-";
    public static final String ERROR_DUPLICATE_COORDINATES_FOUND = "좌표에 중복값이 존재합니다.";

    private InputView() {}

    public static Line inputCoordinate() {
        System.out.println(INPUT_COORDINATE);
        return inputCoordinate(sc.nextLine());
    }

    public static Line inputCoordinate(String input) {
        try {
            input = input.replace(" ", "");
            checkPatternOf(input);
            return new Line(generateCoordinates(input));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return inputCoordinate();
        }
    }

    protected static List<Coordinate> generateCoordinates(String input) {
        String[] inputCoordinates = input.split(COORDINATE_SEPARATOR);

        List<Coordinate> coordinates = new ArrayList<>();

        for (String coordinate : inputCoordinates) {
            coordinates.add(Coordinate.of(coordinate));
        }
        checkDuplicateOf(coordinates);
        return coordinates;
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

    protected static void checkDuplicateOf(List<Coordinate> coordinates) {
        if (coordinates.size() != new HashSet<>(coordinates).size()) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_COORDINATES_FOUND);
        }
    }
}
