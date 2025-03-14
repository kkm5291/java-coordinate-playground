package calculator.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FigureTypeEnumTest {

    List<Point> points;

    @Test
    void findByNumberOfPoints() {
        Arrays.stream(FigureTypeEnum.values())
                .forEach(e -> System.out.println(e instanceof FigureTypeEnum));
    }

    @Test
    void findFigureTypeByNumberOfPointsExceptionTest_when_not_found_number_of_points() {
        assertThrows(IllegalArgumentException.class, () -> FigureTypeEnum.findByNumberOfPoints(3));
    }

    @Test
    void 점개수로_enum_타입_찾기_line() {
        points = Arrays.asList(Point.of("1,1"), Point.of("2,2"));
        FigureTypeEnum lineFigure = FigureTypeEnum.findByNumberOfPoints(points.size());

        assertThat(lineFigure).isEqualTo(FigureTypeEnum.LINE);
        assertThat(lineFigure).isNotEqualTo(FigureTypeEnum.RECTANGLE);
    }

    @Test
    void 점개수로_enum_타입_찾기_rectangle() {
        points = Arrays.asList(Point.of("1,1"), Point.of("2,2"), Point.of("1,2"), Point.of("2,1"));
        FigureTypeEnum rectangleFigure = FigureTypeEnum.findByNumberOfPoints(points.size());

        assertThat(rectangleFigure).isEqualTo(FigureTypeEnum.RECTANGLE);
        assertThat(rectangleFigure).isNotEqualTo(FigureTypeEnum.LINE);
    }


}