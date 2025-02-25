package calculator;

import calculator.model.Coordinate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoordinateTest {

    @Test
    @DisplayName("각 좌표의 최대값은 24까지")
    public void maxDistance() {
        assertThatThrownBy(() -> Coordinate.create(25, 25)).isInstanceOf(IllegalArgumentException.class);
    }
}
