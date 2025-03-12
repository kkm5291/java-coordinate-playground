package calculator.controller;

import calculator.model.Line;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Controller {

    public static void main(String[] args) {
        Line line = InputView.inputCoordinate();
        OutputView.showCoordinatePlane(line);
        System.out.println(line.getArea());
    }
}
