package calculator.model;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public enum FigureTypeEnum {
    LINE(2, Line::new),
    RECTANGLE(4, Rectangle::new);

    public static final String ERROR_INVALID_POINT_NUMBER = "만들 수 없는 도형입니다.";
    private final int numberOfPoints;
    private final Function<List<Point>, AbstractFigure> creationStrategy;

    FigureTypeEnum(int numberOfPoints, Function<List<Point>, AbstractFigure> creationStrategy) {
        this.numberOfPoints = numberOfPoints;
        this.creationStrategy = creationStrategy;
    }

    public AbstractFigure createFigure(List<Point> points) {
        return creationStrategy.apply(points);
    }

    public static FigureTypeEnum findByNumberOfPoints(int numberOfPoints) {
        return Arrays.stream(values())
                .filter(figureTypeEnum -> figureTypeEnum.numberOfPoints == numberOfPoints)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_INVALID_POINT_NUMBER));    }


}
