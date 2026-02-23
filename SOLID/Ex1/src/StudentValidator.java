import java.util.*;

public class StudentValidator {
    private static final List<String> ALLOWED_PROGRAMS = List.of("CSE", "AI", "SWE");

    public ValidationResult validate(StudentData data) {
        List<String> errors = new ArrayList<>();

        if (data.name.isBlank()) {
            errors.add("name is required");
        }

        if (data.email.isBlank() || !data.email.contains("@")) {
            errors.add("email is invalid");
        }

        if (data.phone.isBlank() || !data.phone.chars().allMatch(Character::isDigit)) {
            errors.add("phone is invalid");
        }

        if (!ALLOWED_PROGRAMS.contains(data.program)) {
            errors.add("program is invalid");
        }

        return errors.isEmpty() ? ValidationResult.success() : ValidationResult.failure(errors);
    }
}
