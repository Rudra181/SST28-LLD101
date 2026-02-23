public class OnboardingPrinter {
    public void printInput(String raw) {
        System.out.println("INPUT: " + raw);
    }

    public void printValidationError() {
        System.out.println("ERROR: cannot register");
    }

    public void printError(String message) {
        System.out.println("- " + message);
    }

    public void printSuccess(String studentId, int totalCount) {
        System.out.println("OK: created student " + studentId);
        System.out.println("Saved. Total students: " + totalCount);
        System.out.println("CONFIRMATION:");
    }

    public void printRecord(StudentRecord record) {
        System.out.println(record);
    }
}
