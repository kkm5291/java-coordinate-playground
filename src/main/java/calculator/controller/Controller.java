package calculator.controller;

import calculator.model.AbstractFigure;
import calculator.model.Line;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Controller {

    public static void main(String[] args) {
        AbstractFigure figure = InputView.inputCoordinate();
        OutputView.showCoordinatePlane(figure);
        System.out.println(figure.getArea());
    }
}
