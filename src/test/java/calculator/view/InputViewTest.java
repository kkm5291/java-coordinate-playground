package calculator.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputViewTest {

    private static String input;
    private static String threeInput;
    private static String fourInput;
    private static String fiveInput;

    @BeforeEach
    void setUp() {
        input = "(10,10)-(14,14)";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        threeInput = "(10,10)-(22,10)-(22,18)";
        fourInput = "(10,10)-(22,10)-(22,18)-(10,18)";
        fiveInput = "(10,10)-(22,10)-(22,18)-(10,18)-(10,10)";
        System.setIn(new ByteArrayInputStream(fourInput.getBytes()));

    }

    @Test
    @DisplayName("4개의 좌표가 주어지는 경우")
    void validInput_fourPoints() {
        InputView.checkPatternOf(fourInput);
    }

    @Test
    @DisplayName("3개의 좌표가 주어지는 경우")
    void validInput_threePoints() {
        InputView.checkPatternOf(threeInput);
    }


    @Test
    @DisplayName("5개의 좌표가 주어지는 경우")
    void validInput_fivePoints() {
        assertThatThrownBy(() -> InputView.checkPatternOf(fiveInput))
                .isInstanceOf(IllegalArgumentException.class);
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
}

