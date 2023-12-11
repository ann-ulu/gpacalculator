package test.output;

import test.input.InputHandler;
import test.processing.GPAProcessor;

import java.util.Scanner;

public class GPACalculator {
    public static void main(String[] args) {
        System.out.println("Grade Point Average (GPA) Calculator\n");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of courses offered per semester (must be a number and cannot be greater than 20): ");
        int numCourses = InputHandler.validateInput(scanner, 1, 20);

        String[] courseNamesAndCodes = new String[numCourses];
        int[] courseUnits = new int[numCourses];
        int[] courseScores = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            System.out.print("Enter Course Name and Code (2 or 3 string letters, possibly containing . or #, space, followed by 3 digits): ");
            courseNamesAndCodes[i] = InputHandler.validateCourseCode(scanner);

            System.out.print("Enter Course Unit (must be a number and cannot be greater than 6): ");
            courseUnits[i] = InputHandler.validateInput(scanner, 1, 6);

            System.out.print("Enter Course Score (must be a number and not greater than 100): ");
            courseScores[i] = InputHandler.validateInput(scanner, 0, 100);
        }

        System.out.println("|----------------------------|-----------------------|------------|---------------------|");
        System.out.println("| COURSE & CODE              | COURSE UNIT           | GRADE      | GRADE-UNIT          |");
        System.out.println("|----------------------------|-----------------------|------------|---------------------|");

        for (int i = 0; i < numCourses; i++) {
            String courseNameAndCode = courseNamesAndCodes[i];
            int courseUnit = courseUnits[i];
            int courseScore = courseScores[i];
            String grade = GPAProcessor.calculateGrade(courseScore);
            int gradeUnit = GPAProcessor.calculateGradeUnit(grade);

            System.out.printf("| %-26s | %-21d | %-10s | %-19d |\n", courseNameAndCode, courseUnit, grade, gradeUnit);
        }

        System.out.println("|---------------------------------------------------------------------------------------|");

        double totalQualityPoints = 0;
        int totalGradeUnits = 0;

        for (int i = 0; i < numCourses; i++) {
            int courseUnit = courseUnits[i];
            String grade = GPAProcessor.calculateGrade(courseScores[i]);
            int gradeUnit = GPAProcessor.calculateGradeUnit(grade);
            totalQualityPoints += courseUnit * gradeUnit;
            totalGradeUnits += courseUnit;
        }

        if (totalGradeUnits > 0) {
            double gpa = totalQualityPoints / totalGradeUnits;
            System.out.printf("\nYour GPA is = %.2f to 2 decimal places.\n", gpa);
        } else {
            System.out.println("\nNo courses entered. GPA calculation aborted.");
        }

        scanner.close();
    }
}
