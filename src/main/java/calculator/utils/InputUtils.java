package calculator.utils;

import java.util.Scanner;

public class InputUtils {
    private static final Scanner sc = new Scanner(System.in);

    public static String input() {
        System.out.println("좌표를 입력하세요.");
        String input = sc.nextLine();

        validateInput(input);
        return input;
    }

    public static boolean validateInput(String input) {
        return validateEmptyInput(input) &&
                validateInputPattern(input);
    }

    protected static boolean validateEmptyInput(String input) {
        if (input.isEmpty()) {
            System.out.println("빈 값은 입력될 수 없습니다.");
        }
        return true;
    }


    protected static boolean validateInputPattern(String input) {

        String regex = "\\(\\d+,\\d+\\)-\\(\\d+,\\d+\\)";
        if (!input.matches(regex)) {
            System.out.println("입력 형식에 맞지 않는 입력값입니다.");
        }
        return true;
    }
}
