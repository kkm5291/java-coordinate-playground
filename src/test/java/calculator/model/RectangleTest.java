package calculator.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RectangleTest {

    List<Point> points;
    Rectangle rectangle;

    @BeforeEach
    void setUp() {
        points = Arrays.asList(Point.of("1, 1"),
                Point.of("1, 15"),
                Point.of("15, 15"),
                Point.of("15, 1"));

        rectangle = new Rectangle(points);
    }

    @Test
    void equals_test() {
        Rectangle rectangle1 = new Rectangle(points);

        assertThat(rectangle).isEqualTo(rectangle1);
    }

    @Test
    void point_duplicate_test() {
        points = Arrays.asList(Point.of("1, 1"),
                Point.of("1, 1"),
                Point.of("15, 15"),
                Point.of("15, 1"));

        assertThrows(IllegalArgumentException.class, () -> new Rectangle(points));
    }

    @Test
    void check_validate_rectangle() {
        // 직사각형의 조건
        // 4개의 각이 반드시 90도를 이뤄야 함.
        assertThrows(IllegalArgumentException.class,
                () -> new Rectangle(Arrays.asList(Point.of("1, 1"),
                        Point.of("1, 1"),
                        Point.of("15, 15"),
                        Point.of("15, 1"))));

        assertThrows(IllegalArgumentException.class,
                () -> new Rectangle(Arrays.asList(Point.of("1, 1"),
                        Point.of("2, 2"),
                        Point.of("3, 1"),
                        Point.of("4, 2"))));

        assertThrows(IllegalArgumentException.class,
                () -> new Rectangle(Arrays.asList(Point.of("1, 1"),
                        Point.of("1, 5"),
                        Point.of("1, 4"),
                        Point.of("2, 5"))));
    }

    @Test
    void get_area_test() {
        assertThat(rectangle.getArea()).isEqualTo(196);
    }

    @Test
    void has_point_test() {
        assertThat(rectangle.hasPoint(1, 1)).isTrue();
        assertThat(rectangle.hasPoint(1, 13)).isFalse();
    }

    @AfterEach
    void tearDown() {
        points = null;
        rectangle = null;
    }
}