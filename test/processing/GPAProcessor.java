package test.processing;

public class GPAProcessor {
    public static String calculateGrade(int score) {
        if (score >= 70 && score <= 100)
            return "A";
        else if (score >= 60)
            return "B";
        else if (score >= 50)
            return "C";
        else if (score >= 45)
            return "D";
        else if (score >= 40)
            return "E";
        else
            return "F";
    }

    public static int calculateGradeUnit(String grade) {
        switch (grade) {
            case "A":
                return 5;
            case "B":
                return 4;
            case "C":
                return 3;
            case "D":
                return 2;
            case "E":
                return 1;
            default:
                return 0;
        }
    }
}
