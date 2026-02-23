import java.util.*;

public class EligibilityEngine {
    private final FakeEligibilityStore store;
    private final List<EligibilityRule> rules;

    public EligibilityEngine(FakeEligibilityStore store) {
        this.store = store;
        this.rules = initializeRules();
    }

    private List<EligibilityRule> initializeRules() {
        List<EligibilityRule> ruleList = new ArrayList<>();
        ruleList.add(new DisciplinaryFlagRule());
        ruleList.add(new CgrRule(8.0));
        ruleList.add(new AttendanceRule(75));
        ruleList.add(new CreditsRule(20));
        return ruleList;
    }

    public void runAndPrint(StudentProfile student) {
        ReportPrinter printer = new ReportPrinter();
        EligibilityEngineResult result = evaluate(student);
        printer.print(student, result);
        store.save(student.rollNo, result.status);
    }

    public EligibilityEngineResult evaluate(StudentProfile student) {
        List<String> reasons = new ArrayList<>();

        for (EligibilityRule rule : rules) {
            String failureReason = rule.evaluate(student);
            if (failureReason != null) {
                reasons.add(failureReason);
                break;
            }
        }

        String status = reasons.isEmpty() ? "ELIGIBLE" : "NOT_ELIGIBLE";
        return new EligibilityEngineResult(status, reasons);
    }
}
