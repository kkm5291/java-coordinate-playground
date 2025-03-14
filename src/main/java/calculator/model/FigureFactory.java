package calculator.model;

import java.util.List;

public class FigureFactory {

    public static AbstractFigure create(List<Point> points) {

        FigureTypeEnum figure = FigureTypeEnum.findByNumberOfPoints(points.size());
        return figure.createFigure(points);
    }
}