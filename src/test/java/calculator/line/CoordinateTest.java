package calculator.line;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoordinateTest {

    @Test
    @DisplayName("두 점 사이값 구하기")
    public void twoCoordinatesDistance() {
        Coordinate coordinateA = Coordinate.create(10, 10);
        Coordinate coordinateB = Coordinate.create(14, 15);

        double distance = coordinateA.calculateDistanceTo(coordinateB);
        assertThat(distance).isEqualTo(6.403124, offset(0.00001));
    }

    @Test
    @DisplayName("각 좌표의 최대값은 24까지")
    public void maxDistance() {
        assertThatThrownBy(() -> Coordinate.create(25, 25)).isInstanceOf(IllegalArgumentException.class);
    }
}
