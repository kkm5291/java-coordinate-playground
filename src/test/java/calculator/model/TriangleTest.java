package calculator.model;

import calculator.view.InputView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

class TriangleTest {

    private String input;

    @BeforeEach
    void setUp() {
        input = "(10,10)-(14,15)-(20,8)";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @Test
    void calculate_triangle() {
        AbstractFigure figure = InputView.inputCoordinate();
        double area = figure.getArea();
        assertThat(area).isEqualTo(29.0, offset(0.0001));
    }

    @AfterEach
    void tearDown() {
        input = null;
    }
}