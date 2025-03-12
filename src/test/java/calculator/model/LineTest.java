package calculator.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class LineTest {

    private List<Point> points;

    @BeforeEach
    void setUp() {
         points = Arrays.asList(Point.of("10,10"), Point.of("10,10"));
    }

    @Test
    void 중복_좌표가_입력된_경우() {
        assertThrows(IllegalArgumentException.class, () -> new Line(points));
    }
}