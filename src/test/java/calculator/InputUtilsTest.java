package calculator;

import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class InputUtilsTest {


    private final InputStream systemIn = System.in;

    @BeforeEach
    void setUp() {
        String input = "(10,10)-(14,14)";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }


}

