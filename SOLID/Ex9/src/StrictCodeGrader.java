public class StrictCodeGrader implements Grader {
    public int grade(Submission s, Rubric r) {
        int base = Math.max(0, s.code.length() - 50);
        return Math.min(100, base + r.bonus);
    }
}
