package calculator.view;

import calculator.model.AbstractFigure;
import calculator.model.Point;

public class OutputView {
    private static final String VERTICAL_AXIS = "|";
    private static final String ORIGIN = "+";
    private static final String HORIZONTAL_AXIS = "---";
    private static final String MARK_OF_POINT = ".";
    private static final String FOUR_BLANK = "    ";

    public static void showCoordinatePlane(AbstractFigure figure) {
        showVerticalNumbersWith(figure);
        showHorizontalAxis();
        showHorizontalNumbers();
    }

    private static void showHorizontalNumbers() {
        for (int x = Point.MIN_VALUE; x <= Point.MAX_VALUE; x++) {
            showAxisNumber(x);
        }
        emptyLine();
    }

    private static void showHorizontalAxis() {
        System.out.print(FOUR_BLANK + ORIGIN);
        for (int x = Point.MIN_VALUE; x <= Point.MAX_VALUE; x++) {
            System.out.print(HORIZONTAL_AXIS);
        }
        emptyLine();
    }

    private static void showVerticalNumbersWith(AbstractFigure figure) {
        for (int y = Point.MAX_VALUE; y > Point.MIN_VALUE; y--) {
            showAxisNumber(y);
            System.out.print(VERTICAL_AXIS);
            showPoint(figure, y);
            emptyLine();
        }
    }

    private static void emptyLine() {
        System.out.println();
    }

    private static void showPoint(AbstractFigure figure, int y) {
        for (int x = Point.MIN_VALUE; x < Point.MAX_VALUE; x++) {
            if (figure.hasPoint(x, y)) {
                System.out.printf("%4s", MARK_OF_POINT);
                continue;
            }
            System.out.print(FOUR_BLANK);
        }
    }

    private static void showAxisNumber(int index) {
        if (index % 2 == 0) {
            System.out.printf("%4s", index);
            return;
        }
        System.out.print(FOUR_BLANK);
    }
}

