package calculator.line;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;
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
}
