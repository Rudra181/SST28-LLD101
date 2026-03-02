public class CodeGrader implements Grader {
    public int grade(Submission s, Rubric r) {
        int base = 50;
        return base + r.bonus;
    }
}
