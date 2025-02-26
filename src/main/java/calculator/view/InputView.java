package calculator.view;

import calculator.model.Coordinate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);
    public static final String INPUT_COORDINATE = "좌표를 입력하세요.";
    public static final String ERROR_INVALID_INPUT_MESSAGE = "올바르지 않은 입력값입니다.";
    public static final String COORDINATE_SEPARATOR = "-";

    private InputView() {}

    public static List<Coordinate> inputCoordinate() {
        System.out.println(INPUT_COORDINATE);
        return inputCoordinate(sc.nextLine());
    }

    public static List<Coordinate> inputCoordinate(String input) {
        try {
            input = input.replace(" ", "");
            checkInputPattern(input);
            List<Coordinate> coordinates = generateCoordinates(input);
        }
    }

    private static List<Coordinate> generateCoordinates(String input) {
        String[] inputCoordinates = input.split(COORDINATE_SEPARATOR);

        List<Coordinate> coordinates = new ArrayList<>();

        for (String coordinate : inputCoordinates) {
            coordinates.add(Coordinate.create(coordinate));
        }

        return coordinates;
    }

    protected static void checkEmptyInput(String input) {
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException(ERROR_INVALID_INPUT_MESSAGE);
        }
    }


    protected static void checkInputPattern(String input) {
        String regex = "\\(\\d+,\\d+\\)-\\(\\d+,\\d+\\)";
        if (!input.matches(regex)) {
            throw new IllegalArgumentException(ERROR_INVALID_INPUT_MESSAGE);
        }
    }

    protected static void checkDuplicateInput(String input) {

    }
}
