package calculator.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {


    @Test
    void 좌표_범위_벗어나는_값이_들어온_경우() {
        assertThrows(IllegalArgumentException.class, () -> Point.of("0,26"));
        assertThrows(IllegalArgumentException.class, () -> Point.of("-1,10"));
        assertThrows(IllegalArgumentException.class, () -> Point.of("26,0"));
        assertThrows(IllegalArgumentException.class, () -> Point.of("26,26"));
        assertThrows(IllegalArgumentException.class, () -> Point.of("-1,-1"));
    }
}