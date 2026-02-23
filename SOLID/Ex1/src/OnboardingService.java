import java.util.*;

public class OnboardingService {
    private final StudentRepository repository;
    private final InputParser parser;
    private final StudentValidator validator;
    private final OnboardingPrinter printer;

    public OnboardingService(StudentRepository repository) {
        this.repository = repository;
        this.parser = new InputParser();
        this.validator = new StudentValidator();
        this.printer = new OnboardingPrinter();
    }

    public void registerFromRawInput(String raw) {
        printer.printInput(raw);

        Map<String, String> fields = parser.parse(raw);
        StudentData data = parser.extractFields(fields);

        ValidationResult validation = validator.validate(data);
        if (!validation.valid) {
            printer.printValidationError();
            for (String error : validation.errors) {
                printer.printError(error);
            }
            return;
        }

        String studentId = IdUtil.nextStudentId(repository.count());
        StudentRecord record = new StudentRecord(studentId, data.name, data.email, data.phone, data.program);

        repository.save(record);

        printer.printSuccess(studentId, repository.count());
        printer.printRecord(record);
    }
}
