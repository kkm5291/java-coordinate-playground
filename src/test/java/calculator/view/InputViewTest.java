package calculator.view;

import calculator.model.Coordinate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {

    private static String input;

    @BeforeEach
    void setUp() {
        input = "(10,10)-(14,14)";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

    }

    @Test
    @DisplayName("pattern에 맞지 않는 입력값")
    void invalidPatternInput_throwsIllegalArgumentException() {
        input = "(10 10) - (14 14)";
        assertThatThrownBy(() -> InputView.checkPatternOf(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(InputView.ERROR_INVALID_INPUT_MESSAGE);

    }

    @Test
    @DisplayName("빈 입력값")
    void emptyInput_throwsIllegalArgumentException() {
        input = " ";
        assertThatThrownBy(() -> InputView.checkEmptyOf(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(InputView.ERROR_INVALID_INPUT_MESSAGE);
    }

    @Test
    @DisplayName("좌표 간 중복값")
    void duplicateInput_throwsIllegalArgumentException() {
        input = "(10,10)-(10,10)";

        assertThatThrownBy(() -> InputView.generateCoordinates(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(InputView.ERROR_DUPLICATE_COORDINATES_FOUND);
    }
}

