package test.input;

import java.util.Scanner;
import java.util.regex.Pattern;

public class InputHandler {
    public static int validateInput(Scanner scanner, int min, int max) {
        int input;
        while (true) {
            try {
                input = Integer.parseInt(scanner.nextLine());
                if (input >= min && input <= max) {
                    break;
                } else {
                    System.out.printf("Input must be between %d and %d. Try again: ", min, max);
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
        return input;
    }

    public static String validateCourseCode(Scanner scanner) {
        String courseCode;
        while (true) {
            courseCode = scanner.nextLine().toUpperCase();
            if (Pattern.matches("[A-Za-z]{2,3}[ .#][A-Za-z0-9]{3}", courseCode)) {
                break;
            } else {
                System.out.print("Invalid course code format. Please enter a valid code: ");
            }
        }
        return courseCode;
    }
}
